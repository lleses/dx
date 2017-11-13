package cn.dc.commodity.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 套餐
 */
@Entity
@Table(name = "t_tc")
public class Tc {

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
	/** 图片路径 **/
	@Column(name = "img_path")
	private String imgPath;

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

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	/**
	 * 
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * 
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
