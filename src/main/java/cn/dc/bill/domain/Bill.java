package cn.dc.bill.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.dc.user.domain.User;

/**
 * 账单记录
 */
@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue
	private Integer id;
	/** 用户 **/
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	/** 金额 **/
	@Column(name = "money")
	private BigDecimal money;

	private Date ct;

	public Bill() {
	}

	public Bill(User user, BigDecimal money) {
		this.user = user;
		this.money = money;
		this.ct = new Date();
	}

	/**
	 * 
	 */
	@Transient
	public String getCtStr() {
		return new SimpleDateFormat("yyyy-MM-dd").format(ct);
	}

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
	public Date getCt() {
		return ct;
	}

	/**
	 * 
	 */
	public void setCt(Date ct) {
		this.ct = ct;
	}

}
