package cn.dc.cart.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 购物车
 */
@Entity
@Table(name = "t_cart")
public class Cart {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户id **/
	private Integer userId;
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
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
