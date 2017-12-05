package cn.dc.db.module.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 商家 店面-账号 关系
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_business_store_account_relation")
public class BusinessStoreAccountRelation extends AbstractBasicEntity {

	/** 账号ID **/
	private String accountId;
	/** 门店ID **/
	private String storeId;

	public BusinessStoreAccountRelation() {
	}

	public BusinessStoreAccountRelation(String accountId, String storeId) {
		super();
		this.accountId = accountId;
		this.storeId = storeId;
	}

	/**
	 * 账号ID
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * 账号ID
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * 门店ID
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 门店ID
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

}
