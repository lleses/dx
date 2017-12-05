package cn.dc.commodity.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.dc.common.entity.AbstractBasicEntity;

/**
 * 商品类别
 */
@Entity
@Table(name = "t_commodity_type")
public class CommodityType extends AbstractBasicEntity {

	/** 名称 **/
	private String name;
	/** 门店Id **/
	private String storeId;
	/** 排序号 **/
	private Integer serialNum;

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
	public Integer getSerialNum() {
		return serialNum;
	}

	/**
	 * 
	 */
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

}
