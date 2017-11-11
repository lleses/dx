package cn.dc.cart.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.dc.commodity.domain.Commodity;

/**
 * 购物车订购关系
 */
@Entity
@Table(name = "t_cart_relationship")
public class CartRelationship {

	@Id
	@GeneratedValue
	private Integer id;
	/** 购物车id **/
	private Integer cartId;
	/** 商品 **/
	@OneToOne
	@JoinColumn(name = "commodity_id")
	private Commodity commodity;
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
	public Integer getCartId() {
		return cartId;
	}

	/**
	 * 
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	/**
	 * 
	 */
	public Commodity getCommodity() {
		return commodity;
	}

	/**
	 * 
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
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
