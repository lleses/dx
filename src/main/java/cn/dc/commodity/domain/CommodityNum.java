package cn.dc.commodity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品-数量
 */
@Entity
@Table(name = "commodity_num")
public class CommodityNum {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "commodity_id")
	private String commodityId;
	/** 商品数量 **/
	@Column(name = "num")
	private String num;

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
	public String getCommodityId() {
		return commodityId;
	}

	/**
	 * 
	 */
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * 
	 */
	public String getNum() {
		return num;
	}

	/**
	 * 
	 */
	public void setNum(String num) {
		this.num = num;
	}

}
