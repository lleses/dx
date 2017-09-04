package cn.dc.commodity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_commodity")
public class Commodity {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private int type;
	@Column(name = "remark")
	private String remark;
	@Column(name = "price")
	private int price;

	/**
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	public void setId(Long id) {
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
	public int getType() {
		return type;
	}

	/**
	 * 
	 */
	public void setType(int type) {
		this.type = type;
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

	/**
	 * 
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commodity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
