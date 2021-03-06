package cn.dc.db.comm.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import cn.dc.comm.utils.IdUtils;

/**
 * 基础实体类
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@MappedSuperclass
public abstract class AbstractBasicEntity {

	@Id
	private String id;
	/** 创建时间 **/
	private Date ct;
	/** 修改时间 **/
	private Date et;
	/** 标记删除(true:逻辑删除 false:启用) **/
	private Boolean flagDel;

	public AbstractBasicEntity() {
		this.id = IdUtils.id32();
		this.ct = new Date();
		this.et = new Date();
		this.flagDel = false;
	}

	/**
	 * ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 创建时间
	 */
	public Date getCt() {
		return ct;
	}

	/**
	 * 创建时间
	 */
	public void setCt(Date ct) {
		this.ct = ct;
	}

	/**
	 * 修改时间
	 */
	public Date getEt() {
		return et;
	}

	/**
	 * 修改时间
	 */
	public void setEt(Date et) {
		this.et = et;
	}

	/**
	 * 标记删除(true:逻辑删除 false:启用)
	 */
	public Boolean isFlagDel() {
		return flagDel;
	}

	/**
	 * 标记删除(true:逻辑删除 false:启用)
	 */
	public void setFlagDel(Boolean flagDel) {
		this.flagDel = flagDel;
	}

}
