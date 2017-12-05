package cn.dc.db.module.order.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 订单记录
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_order_record")
public class OrderRecord extends AbstractBasicEntity {

	/** 订单ID **/
	private String orderId;
	/** 订单状态 **/
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;

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
	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 
	 */
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

}
