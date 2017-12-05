package cn.dc.db.module.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 消费者信息
 */
@Entity
@Table(name = "t_user")
public class User extends AbstractBasicEntity {

	/** openid **/
	private String openid;
	/** 名称 **/
	private String name;
	/** 电话 **/
	private String phone;
	/** 地图地址 **/
	private String address;
	/** 详细地址 **/
	private String detailedAddress;
	/** 商家ID **/
	private String businessId;
	/** 会员等级 **/
	private Integer level;
	
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
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 */
	public String getDetailedAddress() {
		return detailedAddress;
	}

	/**
	 * 
	 */
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	/**
	 * 
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * 
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * 
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

}
