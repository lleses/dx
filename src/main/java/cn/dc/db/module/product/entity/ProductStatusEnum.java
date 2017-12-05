package cn.dc.db.module.product.entity;

/**
 * 产品状态
 */
public enum ProductStatusEnum {

	/** 上架 **/
	SJ("上架"),
	/** 下架 **/
	XJ("下架"),
	/** 沽清 **/
	GQ("沽清");

	private String val;

	private ProductStatusEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
