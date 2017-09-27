package cn.dc.client.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 客户信息
 */
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	private Integer id;
	/** 首页Logo **/
	@Column(name = "logo_path")
	private String logoPath;

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
	public String getLogoPath() {
		return logoPath;
	}

	/**
	 * 
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

}
