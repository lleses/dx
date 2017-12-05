package cn.dc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dc.common.vo.ResultInfo;

/**
 * 统一拦截错误日志
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = Logger.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultInfo<String> errorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error(e);
		ResultInfo<String> r = new ResultInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ResultInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}

}
