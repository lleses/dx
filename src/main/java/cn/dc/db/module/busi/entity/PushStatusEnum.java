package cn.dc.db.module.busi.entity;

/**
 * 推送状态
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public enum PushStatusEnum {

	/** 未推送 **/
	WTS("未推送"),
	/** 已推送 **/
	YTS("已推送");

	private String val;

	private PushStatusEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
