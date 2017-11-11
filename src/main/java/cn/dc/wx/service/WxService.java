package cn.dc.wx.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.dc.busi.dao.BusinessRepository;
import cn.dc.busi.entity.Business;
import cn.dc.common.redis.RedisUtil;
import cn.dc.common.utils.HttpUtils;
import cn.dc.wx.utils.WxConfig;

@Service
public class WxService {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private BusinessRepository businessDao;

	/**
	 * 根据小程序登录返回的code获取openid和session_key
	 * @param wxcode
	 * @return
	 */
	public JSONObject getWxSession(String wxCode, String appId) {
		Business business = businessDao.findByAppId(appId);
		StringBuffer sb = new StringBuffer();
		sb.append("appid=").append(appId);
		sb.append("&secret=").append(business.getAppSecret());
		sb.append("&js_code=").append(wxCode);
		sb.append("&grant_type=").append(WxConfig.GRANT_TYPE);
		String res = HttpUtils.sendGet(WxConfig.SESSION_URL, sb.toString());
		if (res == null || res.equals("")) {
			return null;
		}
		return JSON.parseObject(res);
	}

	/**
	 * 缓存微信openId和session_key
	 * @param wxOpenId		微信用户唯一标识
	 * @param wxSessionKey	微信服务器会话密钥
	 * @param expires		会话有效期, 以秒为单位, 例如2592000代表会话有效期为30天
	 * @param userId		用户ID
	 * @return
	 */
	public String create3rdSession(HttpServletRequest request, String wxOpenId, String wxSessionKey, Long expires, Integer userId) {
		String sessionId = RandomStringUtils.randomAlphanumeric(64);
		StringBuffer sb = new StringBuffer();
		sb.append(wxSessionKey).append("#").append(wxOpenId).append("#").append(userId);
		redisUtil.add(sessionId, expires, sb.toString());
		return sessionId;
	}
}
