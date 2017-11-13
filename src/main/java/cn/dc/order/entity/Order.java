package cn.dc.order.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.dc.common.utils.IdUtils;

/**
 * 订单
 */
@Entity
@Table(name = "t_order")
public class Order {

	@Id
	private String id;
	/** 顾客电话 **/
	private String phone;
	/** 送货地址 **/
	private String address;
	/** 总金额(所有商品) **/
	private BigDecimal money;
	/** 支付状态 **/
	@Enumerated(EnumType.STRING) 
	private PayStatusEnum payStatus;
	/** 订单状态 **/
	@Enumerated(EnumType.STRING) 
	private OrderStatusEnum orderStatus;
	/** 创建时间 */
	private Date ct;
	/** appId */
	private String appId;

	public Order() {
	}

	public Order(String phone, String address, BigDecimal money, String appId) {
		this.id = IdUtils.id32();
		this.phone = phone;
		this.address = address;
		this.money = money;
		this.appId = appId;
		this.payStatus = PayStatusEnum.WZF;//未支付 
		this.orderStatus = OrderStatusEnum.DSL;//用户已下单,等待受理
		this.ct = new Date();
	}

	/**
	 * 
	 */
	@Transient
	public String getCtYYYYMMDD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(ct);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public PayStatusEnum getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(PayStatusEnum payStatus) {
		this.payStatus = payStatus;
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
