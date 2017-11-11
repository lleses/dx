package cn.dc.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 */
@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户唯一标识 **/
	private String openid;
	/** 用户名称 **/
	private String name;
	/** 用户电话 **/
	private String phone;
	/** 地图地址 **/
	private String address;
	/** 详细地址 **/
	private String detailedAddress;

	private String appId;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

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
	public String getAppId() {
		return appId;
	}

	/**
	 * 
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

}
