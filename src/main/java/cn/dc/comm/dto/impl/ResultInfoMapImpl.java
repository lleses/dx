package cn.dc.comm.dto.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.dc.comm.dto.ResultInfo;

/**
 * 统一返回的结果集合
 */
public class ResultInfoMapImpl<K, V> extends AbstractResultInfo implements ResultInfo {

	private Logger logger = Logger.getLogger(getClass());

	private Map<K, V> data;

	public ResultInfoMapImpl<K, V> succ() {
		return handle(ResultInfoMapImpl.SUCC_CODE, null, null, null);
	}

	public ResultInfoMapImpl<K, V> succ(Map<K, V> map) {
		return handle(ResultInfoMapImpl.SUCC_CODE, map, null, null);
	}

	public ResultInfoMapImpl<K, V> err() {
		return handle(ResultInfoMapImpl.ERROR_CODE, null, null, null);
	}

	public ResultInfoMapImpl<K, V> err(String message) {
		return handle(ResultInfoMapImpl.ERROR_CODE, null, message, null);
	}

	public ResultInfoMapImpl<K, V> err(Map<K, V> map) {
		return handle(ResultInfoMapImpl.ERROR_CODE, map, null, null);
	}

	public ResultInfoMapImpl<K, V> err(Map<K, V> map, String message) {
		return handle(ResultInfoMapImpl.ERROR_CODE, map, message, null);
	}

	public ResultInfoMapImpl<K, V> err(Map<K, V> map, String message, String url) {
		return handle(ResultInfoMapImpl.ERROR_CODE, map, message, url);
	}

	public ResultInfoMapImpl<K, V> succLog() {
		return handleLog(ResultInfoMapImpl.SUCC_CODE, null, null, null);
	}

	public ResultInfoMapImpl<K, V> succLog(Map<K, V> map) {
		return handleLog(ResultInfoMapImpl.SUCC_CODE, map, null, null);
	}

	public ResultInfoMapImpl<K, V> errLog() {
		return handleLog(ResultInfoMapImpl.ERROR_CODE, null, null, null);
	}

	public ResultInfoMapImpl<K, V> errLog(String message) {
		return handleLog(ResultInfoMapImpl.ERROR_CODE, null, message, null);
	}

	public ResultInfoMapImpl<K, V> errLog(Map<K, V> map) {
		return handleLog(ResultInfoMapImpl.ERROR_CODE, map, null, null);
	}

	public ResultInfoMapImpl<K, V> errLog(Map<K, V> map, String message) {
		return handleLog(ResultInfoMapImpl.ERROR_CODE, map, message, null);
	}

	public ResultInfoMapImpl<K, V> errLog(Map<K, V> map, String message, String url) {
		return handleLog(ResultInfoMapImpl.ERROR_CODE, map, message, url);
	}

	private ResultInfoMapImpl<K, V> handleLog(Integer code, Map<K, V> map, String message, String url) {
		logger.error(message);
		return handle(code, map, message, url);
	}

	private ResultInfoMapImpl<K, V> handle(Integer code, Map<K, V> map, String message, String url) {
		this.setCode(code);
		this.setData(map);
		this.setMessage(message);
		this.setMessage(url);
		return this;
	}

	public Map<K, V> getData() {
		return data;
	}

	public void setData(Map<K, V> data) {
		this.data = data;
	}

	public <T> T getObject(String key, Class<T> clazz) {
		JSONObject jsonObj = (JSONObject) JSON.toJSON(data);
		if (jsonObj == null) {
			return null;
		}
		return jsonObj.getObject(key, clazz);
	}

	public <T> List<T> getList(String key, Class<T> clazz) {
		JSONObject jsonObj = (JSONObject) JSON.toJSON(data);
		if (jsonObj == null) {
			return null;
		}
		JSONArray jsonArr = jsonObj.getJSONArray(key);
		if (jsonArr == null) {
			return null;
		}
		List<T> list = jsonArr.toJavaList(clazz);
		return list;
	}

}
