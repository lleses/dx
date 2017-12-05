package cn.dc.db.module.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 商家门店信息
 */
@Entity
@Table(name = "t_business_store")
public class BusinessStore extends AbstractBasicEntity {

	/** 名称 **/
	private String name;
	/** 商家ID **/
	private String businessId;
	/** 积分功能开关,默认关闭 (true:开启 false:关闭) **/
	private boolean integralSwitch;
	/** 积分兑换比例(例如  1000, 相当于1000积分等于1块) **/
	private float integralScale;
	/** 会员功能开关,默认关闭 (true:开启 false:关闭) **/
	private boolean memberSwitch;
	/** 成为会员所需要的积分 **/
	private int menberIntegral;
	/** 会员等级,非会员时值为null **/
	private Integer level;

	public BusinessStore() {
	}

	public BusinessStore(String name, String businessId) {
		super();
		this.name = name;
		this.businessId = businessId;
		this.integralSwitch = false;
		this.integralScale = 100;
		this.memberSwitch = false;
		this.menberIntegral = 500;
		this.level = null;
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
	 * 积分功能开关,默认关闭 (true:开启 false:关闭)
	 */
	public boolean isIntegralSwitch() {
		return integralSwitch;
	}

	/**
	 * 积分功能开关,默认关闭 (true:开启 false:关闭)
	 */
	public void setIntegralSwitch(boolean integralSwitch) {
		this.integralSwitch = integralSwitch;
	}

	/**
	 * 积分兑换比例(例如 1000, 相当于1000积分等于1块)
	 */
	public float getIntegralScale() {
		return integralScale;
	}

	/**
	 * 积分兑换比例(例如 1000, 相当于1000积分等于1块)
	 */
	public void setIntegralScale(float integralScale) {
		this.integralScale = integralScale;
	}

	/**
	 * 会员功能开关,默认关闭 (true:开启 false:关闭)
	 */
	public boolean isMemberSwitch() {
		return memberSwitch;
	}

	/**
	 * 会员功能开关,默认关闭 (true:开启 false:关闭)
	 */
	public void setMemberSwitch(boolean memberSwitch) {
		this.memberSwitch = memberSwitch;
	}

	/**
	 * 成为会员所需要的积分
	 */
	public int getMenberIntegral() {
		return menberIntegral;
	}

	/**
	 * 成为会员所需要的积分
	 */
	public void setMenberIntegral(int menberIntegral) {
		this.menberIntegral = menberIntegral;
	}

	/**
	 * 会员等级,非会员时值为null
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 会员等级,非会员时值为null
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

}
