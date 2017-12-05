package cn.dc.db.module.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.db.comm.entity.AbstractBasicEntity;

/**
 * 产品类别
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Entity
@Table(name = "t_product_type")
public class ProductType extends AbstractBasicEntity {

	/** 名称 **/
	private String name;
	/** 门店Id **/
	private String storeId;
	/** 排序号 **/
	private Integer serialNum;

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

}
