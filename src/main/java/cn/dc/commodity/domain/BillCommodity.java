package cn.dc.commodity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 账单-商品数量 关系(1对多)
 */
@Entity
@Table(name = "bill_commodity")
public class BillCommodity {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "bill_id")
	private String billId;
	@Column(name = "commodity_num_id")
	private String commodityNumId;

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
	public String getBillId() {
		return billId;
	}

	/**
	 * 
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}

	/**
	 * 
	 */
	public String getCommodityNumId() {
		return commodityNumId;
	}

	/**
	 * 
	 */
	public void setCommodityNumId(String commodityNumId) {
		this.commodityNumId = commodityNumId;
	}

}
