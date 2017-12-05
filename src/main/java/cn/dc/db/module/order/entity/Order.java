package cn.dc.db.module.order.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 订单
 */
@Entity
@Table(name = "t_order")
public class Order extends AbstractBasicEntity {

	/** 支付类型 **/
	@Enumerated(EnumType.STRING)
	private PayTypeEnum payType;
	/** 订单状态 **/
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;
	/** 门店ID **/
	private String storeId;
	/** 消费者ID **/
	private String userId;
	/** 收货人 **/
	private String people;
	/** 送货地址 **/
	private String address;
	/** 收货电话 **/
	private String phone;
	/** 实收金额(所有商品) **/
	private BigDecimal actualMoney;
	/** 总金额(所有商品) **/
	private BigDecimal totalMoney;
	/** 台号 **/
	private Integer deskNum;
	/** 备注 **/
	private String remark;

	public Order() {
	}

	public Order(String storeId, String userId) {
		super();
		//待支付
		this.orderStatus = OrderStatusEnum.DZF;
		this.storeId = storeId;
		this.userId = userId;
	}

	/**
	 * 支付类型
	 */
	public PayTypeEnum getPayType() {
		return payType;
	}

	/**
	 * 支付类型
	 */
	public void setPayType(PayTypeEnum payType) {
		this.payType = payType;
	}

	/**
	 * 订单状态
	 */
	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 订单状态
	 */
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
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

	/**
	 * 消费者ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 消费者ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 收货人
	 */
	public String getPeople() {
		return people;
	}

	/**
	 * 收货人
	 */
	public void setPeople(String people) {
		this.people = people;
	}

	/**
	 * 送货地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 送货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 收货电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 收货电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 实收金额(所有商品)
	 */
	public BigDecimal getActualMoney() {
		return actualMoney;
	}

	/**
	 * 实收金额(所有商品)
	 */
	public void setActualMoney(BigDecimal actualMoney) {
		this.actualMoney = actualMoney;
	}

	/**
	 * 总金额(所有商品)
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	/**
	 * 总金额(所有商品)
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * 台号
	 */
	public Integer getDeskNum() {
		return deskNum;
	}

	/**
	 * 台号
	 */
	public void setDeskNum(Integer deskNum) {
		this.deskNum = deskNum;
	}

	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
