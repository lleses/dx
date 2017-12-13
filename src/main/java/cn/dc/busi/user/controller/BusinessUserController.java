package cn.dc.busi.user.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.busi.user.service.BusinessUserService;
import cn.dc.comm.dto.impl.ResultInfoMapImpl;
import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessAccount;
import cn.dc.db.module.busi.entity.BusinessUser;

/**
 * 商家用户
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("busi/user")
public class BusinessUserController {

	@Autowired
	private BusinessUserRepository businessUserDao;
	@Autowired
	private BusinessUserService businessUserService;

	/** 检查是否已经绑定 **/
	@RequestMapping("checkBind")
	public String checkBind(HttpServletRequest request, String sessionId) {
		//校验参数
		ResultInfoMapImpl<String, Object> rs = businessUserService.checkBindCheckParams(sessionId);
		if (!rs.checkSucc()) {
			return rs.toJson();
		}
		return businessUserService.toGo(rs).toJson();
	}

	/** 登陆 **/
	@RequestMapping("login")
	public String login(HttpServletRequest request, String username, String password, String sessionId) {
		//校验参数
		ResultInfoMapImpl<String, Object> rsMap = businessUserService.loginCheckParams(sessionId, username, password);
		if (!rsMap.checkSucc()) {
			return rsMap.toJson();
		}

		BusinessAccount account = rsMap.getObject("account", BusinessAccount.class);
		BusinessUser user = rsMap.getObject("user", BusinessUser.class);
		//绑定账号
		user.setAccountId(account.getId());
		user.setEt(new Date());
		businessUserDao.save(user);
		return businessUserService.toGo(rsMap).toJson();
	}

}
