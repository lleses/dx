package cn.dc.comm.dto.impl;

import org.apache.log4j.Logger;

import cn.dc.comm.dto.ResultInfo;

/**
 * 统一返回的结果集合
 */
public class ResultInfoImpl<T> extends AbstractResultInfo implements ResultInfo {

	private Logger logger = Logger.getLogger(getClass());

	private T data;

	public ResultInfoImpl<T> succ() {
		return handle(ResultInfoImpl.SUCC_CODE, null, null, null);
	}

	public ResultInfoImpl<T> succ(T entity) {
		return handle(ResultInfoImpl.SUCC_CODE, entity, null, null);
	}

	public ResultInfoImpl<T> err() {
		return handle(ResultInfoImpl.ERROR_CODE, null, null, null);
	}

	public ResultInfoImpl<T> err(String message) {
		return handle(ResultInfoImpl.ERROR_CODE, null, message, null);
	}

	public ResultInfoImpl<T> err(T entity) {
		return handle(ResultInfoImpl.ERROR_CODE, entity, null, null);
	}

	public ResultInfoImpl<T> err(T entity, String message) {
		return handle(ResultInfoImpl.ERROR_CODE, entity, message, null);
	}

	public ResultInfoImpl<T> err(T entity, String message, String url) {
		return handle(ResultInfoImpl.ERROR_CODE, entity, message, url);
	}

	public ResultInfoImpl<T> succLog() {
		return handleLog(ResultInfoImpl.SUCC_CODE, null, null, null);
	}

	public ResultInfoImpl<T> succLog(T entity) {
		return handleLog(ResultInfoImpl.SUCC_CODE, entity, null, null);
	}

	public ResultInfoImpl<T> errLog() {
		return handleLog(ResultInfoImpl.ERROR_CODE, null, null, null);
	}

	public ResultInfoImpl<T> errLog(String message) {
		return handleLog(ResultInfoImpl.ERROR_CODE, null, message, null);
	}

	public ResultInfoImpl<T> errLog(T entity) {
		return handleLog(ResultInfoImpl.ERROR_CODE, entity, null, null);
	}

	public ResultInfoImpl<T> errLog(T entity, String message) {
		return handleLog(ResultInfoImpl.ERROR_CODE, entity, message, null);
	}

	public ResultInfoImpl<T> errLog(T entity, String message, String url) {
		return handleLog(ResultInfoImpl.ERROR_CODE, entity, message, url);
	}

	private ResultInfoImpl<T> handleLog(Integer code, T entity, String message, String url) {
		if (entity instanceof Exception) {
			logger.error(entity);
		} else {
			logger.error(message);
		}
		return handle(code, entity, message, url);
	}

	private ResultInfoImpl<T> handle(Integer code, T entity, String message, String url) {
		this.setData(entity);
		this.setCode(code);
		this.setMessage(message);
		this.setUrl(url);
		return this;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
