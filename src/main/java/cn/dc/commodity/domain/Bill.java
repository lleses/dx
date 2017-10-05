package cn.dc.commodity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 账单记录
 */
@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue
	private Integer id;
	/** 是否临时已经支付 **/
	private boolean isPay;
	/** 用户id **/
	private String userId;

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
	public boolean isPay() {
		return isPay;
	}

	/**
	 * 
	 */
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

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

}
