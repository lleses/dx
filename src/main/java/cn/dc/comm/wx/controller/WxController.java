package cn.dc.comm.wx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.wx.dto.WxSession;
import cn.dc.comm.wx.service.WxService;
import cn.dc.db.module.busi.entity.Business;

/**
 * 微信接口相关
 * 
 * @author 余狄龙
 * @date   2017年11月13日
 */
@RestController
@RequestMapping("wx")
public class WxController {

	@Autowired
	private WxService wxService;

	/**
	 * 根据客户端传过来的code从微信服务器获取appid和session_key，
	 * 然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
	 * 
	 * @param wxCode	
	 * 			小程序登录时获取的code
	 * @return
	 */
	@RequestMapping(value = "createSession", method = RequestMethod.GET)
	public String createSession(HttpServletRequest request, String sessionId, String code, String appId, String clientType) {
		//检查参数是否合法
		ResultInfoImpl<Business> rsBusiness = wxService.checkParams(sessionId, code, appId, clientType);
		if (!rsBusiness.checkSucc()) {
			return rsBusiness.toJson();
		}

		//判断是否需要请求微信接口(true:不需要请求 false:请求微信接口)
		boolean isRequesetWx = wxService.isNeedToRequestWx(sessionId);
		if (isRequesetWx) {
			ResultInfoImpl<String> resul = new ResultInfoImpl<String>();
			return resul.succ(sessionId).toJson();//session还没过期，不需要请求微信接口
		}

		//请求微信,获取Session
		Business business = rsBusiness.getData();
		ResultInfoImpl<WxSession> rs = wxService.getWxSession(code, business);
		if (!rs.checkSucc()) {
			return rs.toJson();
		}

		WxSession wxSession = rs.getData();

		//获取商家微信用户ID/消费者ID
		String userId = wxService.getUserId(wxSession.getOpenid(), clientType, business.getId());

		//缓存session信息,并返回sessionId
		sessionId = wxService.saveSessionAndCreateSessionId(//
				request, //
				wxSession.getOpenid(), //
				wxSession.getSessionKey(), //
				wxSession.getExpiresIn(), //
				userId//
		);

		ResultInfoImpl<String> rsJson = new ResultInfoImpl<>();
		return rsJson.succ(sessionId).toJson();
	}

}
