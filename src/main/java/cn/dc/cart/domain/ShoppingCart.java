package cn.dc.cart.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.dc.commodity.domain.Commodity;
import cn.dc.user.domain.User;

/**
 * 购物车
 */
@Entity
@Table(name = "t_shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户 **/
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
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
	public User getUser() {
		return user;
	}

	/**
	 * 
	 */
	public void setUser(User user) {
		this.user = user;
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
