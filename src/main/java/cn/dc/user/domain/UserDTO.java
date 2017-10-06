package cn.dc.user.domain;

/**
 * 用户
 */
public class UserDTO {

	private Integer id;
	/** 用户名称 **/
	private String name;
	/** 用户唯一标识 **/
	private String openid;

	private String sessionKey;

	/**
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 
	 */
	public String getSessionKey() {
		return sessionKey;
	}

	/**
	 * 
	 */
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

}
