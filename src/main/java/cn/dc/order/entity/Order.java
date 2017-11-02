package cn.dc.order.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private Integer id;
	/** 顾客电话 **/
	private String phone;
	/** 送货地址 **/
	private String address;
	/** 总金额(所有商品) **/
	private BigDecimal money;
	/** 支付状态 **/
	private PayStatusEnum payStatus;
	/** 订单状态 **/
	private OrderStatusEnum orderStatus;
	/** 创建时间 */
	private Date ct;
	/** 店铺ID */
	private String storeId;

	public Order() {
	}

	public Order(String phone, String address, BigDecimal money,String storeId) {
		//this.id = IdUtils.id32();
		this.phone = phone;
		this.address = address;
		this.money = money;
		this.storeId = storeId;
		this.payStatus = PayStatusEnum.WZF;//未支付 
		this.orderStatus = OrderStatusEnum.DSL;//用户已下单,等待受理
	}

	/**
	 * 
	 */
	@Transient
	public String getCtYYYYMMDD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(ct);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	

}
