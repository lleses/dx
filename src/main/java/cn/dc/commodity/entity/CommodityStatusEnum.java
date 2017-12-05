package cn.dc.commodity.entity;

/**
 * 菜品状态
 */
public enum CommodityStatusEnum {

	/** 上架 **/
	SJ("上架"),
	/** 下架 **/
	XJ("下架"),
	/** 沽清 **/
	GQ("沽清");

	private String val;

	private CommodityStatusEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
