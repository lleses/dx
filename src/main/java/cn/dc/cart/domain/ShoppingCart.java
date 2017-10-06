package cn.dc.cart.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 购物车
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户id **/
	private int userId;
	/** 商品id **/
	private int commodityId;
	/** 该商品订购数量 **/
	private int num;
	/** 总金额 **/
	private BigDecimal money;

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
	public int getUserId() {
		return userId;
	}

	/**
	 * 
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 
	 */
	public int getCommodityId() {
		return commodityId;
	}

	/**
	 * 
	 */
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
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

}
