package cn.dc.comm.wx.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.dc.comm.reids.RedisUtil;
import cn.dc.comm.utils.HttpUtils;
import cn.dc.comm.wx.utils.WxConfig;
import cn.dc.db.module.busi.entity.Business;

@Service
public class WxService {

	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 获取Session
	 * 
	 * @param wxcode
	 * @return
	 * 			openid、session_key、expires_in
	 */
	public JSONObject getWxSession(String wxCode, Business business) {
		StringBuffer sb = new StringBuffer();
		sb.append("appid=").append(business.getAppId());
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
	 * 
	 * @param wxOpenId		
	 * 			微信用户唯一标识
	 * @param wxSessionKey	
	 * 			微信服务器会话密钥
	 * @param expires		
	 * 			会话有效期, 以秒为单位, 例如2592000代表会话有效期为30天
	 * @param userId		
	 * 			消费者ID
	 * @return
	 * 			sessionId
	 */
	public String create3rdSession(HttpServletRequest request, String wxOpenId, String wxSessionKey, Long expires, String userId) {
		String sessionId = RandomStringUtils.randomAlphanumeric(64);
		StringBuffer sb = new StringBuffer();
		sb.append(wxSessionKey).append("#").append(wxOpenId).append("#").append(userId);
		redisUtil.add(sessionId, expires, sb.toString());
		return sessionId;
	}
}
