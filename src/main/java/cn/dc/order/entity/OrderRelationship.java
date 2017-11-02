package cn.dc.order.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 订购关系
 */
@Entity
@Table(name = "t_order_relationship")
public class OrderRelationship {

	/** 订单ID **/
	private Integer orderId;
	/** 商品名称 **/
	private String name;
	/** 商品单位(例如份、个、杯) **/
	private String priceType;
	/** 该商品订购数量 **/
	private int num;
	/** 总金额(该商品) **/
	private BigDecimal money;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
