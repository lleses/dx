package cn.dc.order.entity;

/**
 * 支付状态
 */
public enum PayStatusEnum {

	WZF("未支付"), YZF("已支付");

	private String val;

	private PayStatusEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
