package cn.dc.db.module.order.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 订购关系
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_order_relationship")
public class OrderRelationship extends AbstractBasicEntity {

	/** 订单ID **/
	private String orderId;
	/** 菜品ID **/
	private String commodityId;
	/** 总金额(该商品) **/
	private BigDecimal money;
	/** 该商品订购数量 **/
	private int num;

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
	public String getCommodityId() {
		return commodityId;
	}

	/**
	 * 
	 */
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * 
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * 
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 
	 */
	public void setNum(int num) {
		this.num = num;
	}

}
