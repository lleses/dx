package cn.dc.commodity.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品
 */
@Entity
@Table(name = "commodity")
public class Commodity {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "remark")
	private String remark;
	/** 价格类型 **/
	@Column(name = "price_type")
	private String priceType;
	/** 原价 **/
	@Column(name = "price")
	private BigDecimal price;
	/** 会员价 **/
	@Column(name = "member_price")
	private BigDecimal memberPrice;
	@Column(name = "commodity_type_id")
	private int commodityTypeId;

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
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	public int getCommodityTypeId() {
		return commodityTypeId;
	}

	public void setCommodityTypeId(int commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

}
