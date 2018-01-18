package cn.dc.db.module.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 消费者信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_consumer")
public class Consumer extends AbstractBasicEntity {

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
	/** 会员等级(0:普通 1:1级会员) **/
	private Integer level;
	/** 已经选中的店铺ID **/
	private String checkedStoreId;

	/**
	 * openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 地图地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 地图地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 详细地址
	 */
	public String getDetailedAddress() {
		return detailedAddress;
	}

	/**
	 * 详细地址
	 */
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	/**
	 * 商家ID
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * 商家ID
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * 会员等级(0:普通 1:1级会员)
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 会员等级(0:普通 1:1级会员)
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 已经选中的店铺ID
	 */
	public String getCheckedStoreId() {
		return checkedStoreId;
	}

	/**
	 * 已经选中的店铺ID
	 */
	public void setCheckedStoreId(String checkedStoreId) {
		this.checkedStoreId = checkedStoreId;
	}

}
