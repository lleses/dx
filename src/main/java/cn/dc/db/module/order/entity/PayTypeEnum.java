package cn.dc.db.module.order.entity;

/**
 * 支付类型
 */
public enum PayTypeEnum {

	/** 微信支付 **/
	WXZF("微信支付"),
	/** 到店支付 **/
	DDZF("到店支付"),
	/** 积分支付 **/
	JFZF("积分支付");

	private String val;

	private PayTypeEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
