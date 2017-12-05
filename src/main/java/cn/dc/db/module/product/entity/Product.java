package cn.dc.db.module.product.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 产品
 */
@Entity
@Table(name = "t_product")
public class Product extends AbstractBasicEntity {

	/** 门店Id **/
	private String storeId;
	/** 菜品类型Id **/
	private String commodityTypeId;
	/** 名称 **/
	private String name;
	/** 菜品状态 **/
	@Enumerated(EnumType.STRING)
	private ProductStatusEnum productStatus;
	/** 图片路径 **/
	private String imgPath;
	/** 原价 **/
	private BigDecimal price;
	/** 会员价 **/
	private BigDecimal memberPrice;
	/** 单位 **/
	private String unit;
	/** 排序号 **/
	private Integer serialNum;
	/** 备注 **/
	private String remark;

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
	public String getCommodityTypeId() {
		return commodityTypeId;
	}

	/**
	 * 
	 */
	public void setCommodityTypeId(String commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
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
	public ProductStatusEnum getProductStatus() {
		return productStatus;
	}

	/**
	 * 
	 */
	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
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

	/**
	 * 
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 
	 */
	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	/**
	 * 
	 */
	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	/**
	 * 
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 
	 */
	public Integer getSerialNum() {
		return serialNum;
	}

	/**
	 * 
	 */
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
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

}
