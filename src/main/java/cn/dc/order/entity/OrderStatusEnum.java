package cn.dc.order.entity;

/**
 * 订单状态<br>
 * 
 * 微信支付: 用户已下单,等待受理 -> 订单已受理,等待配送 -> 退款中 ->已退款<br>
 * 微信支付: 用户已下单,等待受理 -> 订单已受理,等待配送 -> 已完成<br>
 * 
 */
public enum OrderStatusEnum {

	/** 用户已下单,等待受理 **/
	DSL("用户已下单,等待受理"),
	/** 订单已受理,等待配送 **/
	DPS("订单已受理,等待配送"),
	/** 退款中 **/
	TKZ("退款中"),
	/** 已退款 **/
	YTK("已退款"),
	/** 已完成 **/
	YWC("已完成");

	private String val;

	private OrderStatusEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
