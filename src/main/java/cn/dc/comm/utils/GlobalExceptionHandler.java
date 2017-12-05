package cn.dc.comm.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dc.comm.dto.impl.ResultInfoImpl;

/**
 * 统一拦截错误日志
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String errorHandler(HttpServletRequest req, Exception e) throws Exception {
		ResultInfoImpl<String> rs = new ResultInfoImpl<>();
		rs = rs.errLog("Some Data", e.getMessage(), req.getRequestURL().toString());
		return rs.toJson();
	}

}
