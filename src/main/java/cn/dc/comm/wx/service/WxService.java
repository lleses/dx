package cn.dc.comm.wx.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.dc.busi.user.service.BusinessUserService;
import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.comm.utils.HttpUtils;
import cn.dc.comm.wx.config.WxConfig;
import cn.dc.comm.wx.dto.WxSession;
import cn.dc.db.module.busi.dao.BusinessRepository;
import cn.dc.db.module.busi.entity.Business;
import cn.dc.user.consumer.service.ConsumerService;

@Service
public class WxService {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private BusinessRepository businessDao;
	@Autowired
	private ConsumerService consumerService;
	@Autowired
	private BusinessUserService businessUserService;

	/**
	 * 检查参数是否合法
	 * 
	 * @param sessionId
	 * @param code
	 * @param appId
	 * @return
	 * 		统一返回的结果集合
	 */
	public ResultInfoImpl<Business> checkParams(String sessionId, String code, String appId, String clientType) {
		ResultInfoImpl<Business> rs = new ResultInfoImpl<>();
		if (!"user".equals(clientType) && !"busi".equals(clientType)) {
			return rs.errLog("wxServic/checkParams--客户端类型错误");
		}
		if (sessionId == null || code == null || appId == null) {
			return rs.errLog("wxServic/checkParams--值为空: sessionId=" + sessionId + ",code=" + code + ",appId=" + appId);
		}
		Business business = businessDao.findByAppId(appId);
		if (business == null) {
			return rs.errLog("wxServic/checkParams--business对象为空");
		}
		return rs.succ(business);
	}

	/**
	 * 判断是否需要请求微信接口
	 * 
	 * @param sessionId
	 * @return 
	 * 			true:不需要请求 false:请求微信接口
	 */
	public boolean isNeedToRequestWx(String sessionId) {
		//初始登陆，客户端并没有传sessionId过来，所以为null
		if (sessionId == null || "".equals(sessionId)) {
			return false;
		}
		String sessionVal = (String) redisUtil.get(sessionId);
		if (sessionVal == null) {
			return false;//session已过期
		}
		return true;
	}

	/**
	 * 请求微信,获取Session
	 * 
	 * @param wxcode
	 * @return
	 * 			openid、session_key、expires_in
	 */
	public ResultInfoImpl<WxSession> getWxSession(String wxCode, Business business) {
		StringBuffer sb = new StringBuffer();
		sb.append("appid=").append(business.getAppId());
		sb.append("&secret=").append(business.getAppSecret());
		sb.append("&js_code=").append(wxCode);
		sb.append("&grant_type=").append(WxConfig.GRANT_TYPE);
		String res = HttpUtils.sendGet(WxConfig.SESSION_URL, sb.toString());

		ResultInfoImpl<WxSession> rs = new ResultInfoImpl<>();
		if (res == null || res.equals("")) {
			return rs.errLog("请求微信接口,获取session失败");
		}

		JSONObject wxSession = JSON.parseObject(res);
		String openid = wxSession.getString("openid");
		if (openid == null) {
			rs = rs.errLog("WxService/getWxSession--openid值为空");
			return rs;
		}
		String sessionKey = wxSession.getString("session_key");
		Long expiresIn = wxSession.getLong("expires_in");
		return rs.succ(new WxSession(openid, sessionKey, expiresIn));
	}

	/**
	 * 缓存session信息,并返回sessionId
	 * 
	 * @param wxOpenId		
	 * 			微信用户唯一标识
	 * @param wxSessionKey	
	 * 			微信服务器会话密钥
	 * @param expires		
	 * 			会话有效期, 以秒为单位, 例如2592000代表会话有效期为30天
	 * @param userId		
	 * 			商家微信用户ID/消费者ID
	 * @return
	 * 			sessionId
	 */
	public String saveSessionAndCreateSessionId(HttpServletRequest request, String wxOpenId, String wxSessionKey, Long expires, String userId) {
		String sessionId = RandomStringUtils.randomAlphanumeric(64);
		StringBuffer sb = new StringBuffer();
		sb.append(wxSessionKey).append("#").append(wxOpenId).append("#").append(userId);
		redisUtil.add(sessionId, expires, sb.toString());
		return sessionId;
	}

	/**
	 * 获取商家微信用户ID/消费者ID
	 * 
	 * @param openid
	 * @param clientType
	 * 			客户端类型(user/busi)
	 * @param businessId
	 * 			商家ID
	 * @return
	 * 		当客户端类型为"user":消费者ID<br>
	 * 		当客户端类型为"busi":商家微信用户ID
	 */
	public String getUserId(String openid, String clientType, String businessId) {
		String userId = "";
		if ("user".equals(clientType)) {
			//判断是否需要新增消费者信息，并返回消费者ID
			userId = consumerService.checkAddAndGetConsumerId(openid, businessId);
		} else {
			//判断是否需要新增商家用户信息，并返回商家用户ID
			userId = businessUserService.checkAddAndGetBusinessUserId(openid, businessId);
		}
		return userId;
	}

}
