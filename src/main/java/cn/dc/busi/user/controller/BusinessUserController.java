package cn.dc.busi.user.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.comm.utils.IdUtils;
import cn.dc.db.module.busi.dao.BusinessAccountRepository;
import cn.dc.db.module.busi.dao.BusinessRepository;
import cn.dc.db.module.busi.dao.BusinessStoreAccountRelationRepository;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.dao.BusinessUserPushRepository;
import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessAccount;
import cn.dc.db.module.busi.entity.BusinessStore;
import cn.dc.db.module.busi.entity.BusinessStoreAccountRelation;
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
	private BusinessRepository businessDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	@Autowired
	private BusinessAccountRepository businessAccountDao;
	@Autowired
	private BusinessStoreAccountRelationRepository businessStoreAccountRelationDao;
	@Autowired
	private BusinessUserRepository businessUserDao;
	@Autowired
	private BusinessUserPushRepository businessUserPushDao;
	@Autowired
	private RedisUtil redisUtil;

	//检查是否已经绑定
	@RequestMapping("checkBind")
	public String checkBind(HttpServletRequest request, String sessionId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null) {
			return rs.errLog("busi/user/checkBind--sessionId为空").toJson();
		}
		String openId = redisUtil.getOpenId(sessionId);
		if (openId == null) {
			return rs.errLog("busi/user/checkBind--openId为空").toJson();
		}
		//检查商家用户是否存在
		BusinessUser businessUser = businessUserDao.findByOpenId(openId);
		if (businessUser == null) {
			return rs.errLog("busi/user/checkBind--businessUser对象为空").toJson();
		} else if (businessUser.getAccountId() == null) {
			//[code:1]--用户没有绑定账号，跳转登陆页
			return rs.go(ResultInfoImpl.TO_LOGIN_VIEW, null).toJson();
		}
		//检查商家用户的账号和店面的绑定是否正常
		List<BusinessStoreAccountRelation> storeAccountRe = businessStoreAccountRelationDao.findByAccountId(businessUser.getAccountId());
		if (storeAccountRe == null || storeAccountRe.isEmpty()) {
			return rs.errLog("busi/user/checkBind--storeAccountRe为空").toJson();
		}

		//TODO 这里还有很多代码
		if (storeAccountRe.size() == 1) {
			//[code:2]--只有一个店面,直接进入首页

			//获取账单信息，推送信息

			return rs.go(ResultInfoImpl.TO_INDEX_VIEW, null).toJson();
		} else {
			//[code:3]--有多个店面,则直接进入[店面列表选择页]]
			//获取店面信息
			Set<BusinessStore> stores = new HashSet<>();
			for (BusinessStoreAccountRelation relation : storeAccountRe) {
				BusinessStore store = businessStoreDao.findById(relation.getStoreId());
				stores.add(store);
			}
			return rs.go(ResultInfoImpl.TO_STORE_LIST_VIEW, stores).toJson();
		}

	}

	//登陆
	@RequestMapping("login")
	public String login(HttpServletRequest request, String username, String password, String sessionId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		//校验参数有效性
		if (sessionId == null || username == null || password == null) {
			return rs.errLog("busi/user/login--值为空,sessionId=" + sessionId + ",username=" + username + ",password=" + password).toJson();
		}
		String openId = redisUtil.getOpenId(sessionId);
		if (openId == null) {
			return rs.errLog("busi/user/login--openId为空").toJson();
		}
		//核对账号信息有效性
		password = IdUtils.md5(password);
		BusinessAccount account = businessAccountDao.findByUsernameAndPassword(username, password);
		if (account == null) {
			return rs.err("账号密码不正确").toJson();
		}
		//核对商家用户信息有效性
		BusinessUser user = businessUserDao.findByOpenId(openId);
		if (user == null) {
			return rs.errLog("busi/user/login--商家用户不存在").toJson();
		}
		//绑定账号
		user.setAccountId(account.getId());
		user.setEt(new Date());
		businessUserDao.save(user);

		//检查商家用户的账号和店面的绑定是否正常
		List<BusinessStoreAccountRelation> storeAccountRe = businessStoreAccountRelationDao.findByAccountId(account.getId());
		if (storeAccountRe == null || storeAccountRe.isEmpty()) {
			return rs.errLog("busi/user/login--storeAccountRe为空").toJson();
		}

		//TODO 这里还有很多代码
		if (storeAccountRe.size() == 1) {
			//[code:1]--只有一个店面,直接进入首页

			//获取账单信息，推送信息

			return rs.go(ResultInfoImpl.TO_INDEX_VIEW, null).toJson();
		} else {
			//[code:2]--有多个店面,则直接进入[店面列表选择页]]
			//获取店面信息
			Set<BusinessStore> stores = new HashSet<>();
			for (BusinessStoreAccountRelation relation : storeAccountRe) {
				BusinessStore store = businessStoreDao.findById(relation.getStoreId());
				stores.add(store);
			}
			return rs.go(ResultInfoImpl.TO_STORE_LIST_VIEW, stores).toJson();
		}
	}

}
