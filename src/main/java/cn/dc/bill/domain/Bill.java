package cn.dc.bill.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
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
	/** 用户id **/
	@Column(name = "user_id")
	private String userId;
	/** 金额 **/
	@Column(name = "money")
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
