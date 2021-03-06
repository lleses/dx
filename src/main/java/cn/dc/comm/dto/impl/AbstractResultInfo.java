package cn.dc.comm.dto.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回结果信息基础类
 */
public abstract class AbstractResultInfo {

	/** 成功 **/
	public static final Integer SUCC_CODE = 0;
	/** 失败 **/
	public static final Integer ERROR_CODE = 100;
	/** 跳转登陆页 **/
	public static final Integer TO_LOGIN_VIEW = 30;
	/** 跳转门店列表页 **/
	public static final Integer TO_STORE_LIST_VIEW = 31;
	/** 跳转首页 **/
	public static final Integer TO_INDEX_VIEW = 32;

	protected Integer code;
	protected String message;
	protected String url;

	public String toJson() {
		return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
	}

	/**
	 * 判断返回结果是否正常
	 * 
	 * @return 
	 * 		true:正常 false:异常
	 */
	public boolean checkSucc() {
		if (SUCC_CODE.equals(code)) {
			return true;
		}
		return false;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
