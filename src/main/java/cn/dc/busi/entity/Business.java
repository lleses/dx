package cn.dc.busi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商家信息
 */
@Entity
@Table(name = "t_business")
public class Business {

	@Id
	private String appId;
	/** app密码 **/
	private String appSecret;
	/** 商家名称 **/
	private String name;

	/**
	 * 
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 
	 */
	public String getAppSecret() {
		return appSecret;
	}

	/**
	 * 
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
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

}
