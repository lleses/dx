package cn.dc.order.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 订单记录
 */
@Entity
@Table(name = "t_order_record")
public class OrderRecord {

	/** 订单ID **/
	private Integer orderId;
	/** 订单状态 **/
	private OrderStatusEnum orderStatus;
	/** 创建时间 */
	private Date ct;

	/**
	 * 
	 */
	@Transient
	public String getCtYYYYMMDD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(ct);
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) {
		this.ct = ct;
	}

}
