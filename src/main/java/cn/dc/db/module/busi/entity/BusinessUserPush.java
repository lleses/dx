package cn.dc.db.module.busi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 商家用户消息推送
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_business_user_push")
public class BusinessUserPush extends AbstractBasicEntity {

	/** 商家用户ID **/
	private String businessUserId;
	/** 订单ID **/
	private String orderId;
	/** 消息推送状态 **/
	private PushStatusEnum pushStatus;

	/**
	 * 
	 */
	public String getBusinessUserId() {
		return businessUserId;
	}

	/**
	 * 
	 */
	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
	}

	/**
	 * 
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 */
	public PushStatusEnum getPushStatus() {
		return pushStatus;
	}

	/**
	 * 
	 */
	public void setPushStatus(PushStatusEnum pushStatus) {
		this.pushStatus = pushStatus;
	}

}
