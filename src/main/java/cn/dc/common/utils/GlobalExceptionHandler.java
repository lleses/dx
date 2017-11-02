package cn.dc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一拦截错误日志
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = Logger.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
	public void errorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error(e);
	}

}
