package cn.dc.db.module.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 商家账号信息
 */
@Entity
@Table(name = "t_business_account")
public class BusinessAccount extends AbstractBasicEntity {

	/** 账号 **/
	private String username;
	/** 密码 **/
	private String password;

	public BusinessAccount() {
	}

	public BusinessAccount(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * 账号
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 账号
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
