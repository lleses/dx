package cn.dc.db.module.cart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 购物车
 */
@Entity
@Table(name = "t_cart")
public class Cart extends AbstractBasicEntity {

	/** 消费者用户ID **/
	private String userId;
	/** 门店ID **/
	private String storeId;
	/** 菜品ID **/
	private String productId;
	/** 数量 **/
	private Integer num;

	/**
	 * 
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * 
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * 
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

}
