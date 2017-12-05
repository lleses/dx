package cn.dc.db.module.cart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 购物车
 * 
 * @author 余狄龙
 * @date 2017年12月6日
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
	 * 消费者用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 消费者用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * 菜品ID
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * 菜品ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 数量
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

}
