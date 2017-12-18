package cn.dc.db.module.product.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	/** 门店ID **/
	private String storeId;
	/** 产品 **/
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
	private Set<Product> product = new HashSet<>();;
	/** 排序号 **/
	private Integer serialNum;

	public ProductType() {
	}

	public ProductType(String id) {
		this.setId(id);
	}

	public ProductType(String name, String storeId) {
		super();
		this.name = name;
		this.storeId = storeId;
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
	 * 门店ID
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 门店ID
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

	/**
	 * 产品
	 */
	public Set<Product> getProduct() {
		return product;
	}

	/**
	 * 产品
	 */
	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
