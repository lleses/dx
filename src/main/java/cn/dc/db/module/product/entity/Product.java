package cn.dc.db.module.product.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 产品
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_product")
public class Product extends AbstractBasicEntity {

	/** 门店Id **/
	private String storeId;
	/** 菜品类型Id **/
	private String productTypeId;
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
	 * 门店Id
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 门店Id
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * 菜品类型Id
	 */
	public String getProductTypeId() {
		return productTypeId;
	}

	/**
	 * 菜品类型Id
	 */
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	/**
	 * 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 菜品状态
	 */
	public ProductStatusEnum getProductStatus() {
		return productStatus;
	}

	/**
	 * 菜品状态
	 */
	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * 图片路径
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * 图片路径
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * 原价
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 原价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 会员价
	 */
	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	/**
	 * 会员价
	 */
	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	/**
	 * 单位
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 排序号
	 */
	public Integer getSerialNum() {
		return serialNum;
	}

	/**
	 * 排序号
	 */
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
