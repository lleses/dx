package cn.dc.commodity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品类别
 */
@Entity
@Table(name = "commodity_type")
public class CommodityType {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "name")
	private String name;
	/** 排序号码 **/
	@Column(name = "serial_num")
	private Integer serialNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

}
