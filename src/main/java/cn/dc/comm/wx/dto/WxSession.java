package cn.dc.comm.wx.dto;

/**
 * 微信session信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public class WxSession {

	public String openid;
	public String sessionKey;
	/** 过期时间(毫秒) **/
	public Long expiresIn;

	public WxSession() {
	}

	public WxSession(String openid, String sessionKey, Long expiresIn) {
		this.openid = openid;
		this.sessionKey = sessionKey;
		this.expiresIn = expiresIn;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	/**
	 * 过期时间
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * 过期时间
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
