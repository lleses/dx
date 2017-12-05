package cn.dc.db.module.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 商家信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_business")
public class Business extends AbstractBasicEntity {

	/** appID **/
	private String appId;
	/** app密码 **/
	private String appSecret;
	/** 商家名称 **/
	private String name;

	public Business() {
	}

	public Business(String appId, String appSecret, String name) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
		this.name = name;
	}

	/**
	 * appID
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * appID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * app密码
	 */
	public String getAppSecret() {
		return appSecret;
	}

	/**
	 * app密码
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	/**
	 * 商家名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商家名称
	 */
	public void setName(String name) {
		this.name = name;
	}

}
