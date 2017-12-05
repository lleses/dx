package cn.dc.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.common.entity.AbstractBasicEntity;

/**
 * 商家用户信息
 */
@Entity
@Table(name = "t_business_user")
public class BusinessUser extends AbstractBasicEntity {

	/** 微信openId **/
	private String openId;
	/** 权限账号Id **/
	private String accountId;
	/** 用户真实名称 **/
	private String name;
	/** 微信昵称 **/
	private String nickname;

	public BusinessUser() {
	}

	public BusinessUser(String openId, String accountId, String name, String nickname) {
		super();
		this.openId = openId;
		this.accountId = accountId;
		this.name = name;
		this.nickname = nickname;
	}

	/**
	 * 微信openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * 微信openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * 权限账号Id
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * 权限账号Id
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * 用户真实名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 用户真实名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 微信昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 微信昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
