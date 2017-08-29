package cn.dx.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {

	//等价于@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "price")
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + "]";
	}

}
