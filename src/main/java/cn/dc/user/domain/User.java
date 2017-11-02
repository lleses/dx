package cn.dc.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户名称 **/
	private String name;
	/** 用户唯一标识 **/
	private String openid;
	private String sessionId;

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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
