package cn.dc.busi.business.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.dto.impl.ResultInfoMapImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.db.module.busi.dao.BusinessStoreAccountRelationRepository;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessStore;
import cn.dc.db.module.busi.entity.BusinessStoreAccountRelation;
import cn.dc.db.module.busi.entity.BusinessUser;

@RestController
@RequestMapping("busi")
public class BusinessController {

	//	@Autowired
	//	private BusinessRepository businessDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	//	@Autowired
	//	private BusinessAccountRepository businessAccountDao;
	@Autowired
	private BusinessStoreAccountRelationRepository businessStoreAccountRelationDao;
	@Autowired
	private BusinessUserRepository businessUserDao;
	//	@Autowired
	//	private BusinessUserPushRepository businessUserPushDao;
	@Autowired
	private RedisUtil redisUtil;

	//TODO
	//订单信息
	//推送信息
	@RequestMapping("index")
	public String index(HttpServletRequest request, String sessionId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		String openId = redisUtil.getOpenId(sessionId);
		if (openId == null) {
			return rs.errLog(this.getClass().getName() + "--openId为空").toJson();
		}
		BusinessUser businessUser = businessUserDao.findByOpenId(openId);
		if (businessUser == null) {
			return rs.errLog(this.getClass().getName() + "--businessUser对象为空").toJson();
		} else if (businessUser.getAccountId() == null) {
			//用户没有绑定账号，跳转登陆页
			return rs.go(ResultInfoImpl.TO_LOGIN_VIEW).toJson();
		}
		//检查商家用户的账号和店面的绑定是否正常
		List<BusinessStoreAccountRelation> storeAccountRe = businessStoreAccountRelationDao.findByAccountId(businessUser.getAccountId());
		if (storeAccountRe == null || storeAccountRe.isEmpty()) {
			return rs.errLog(this.getClass().getName() + "--storeAccountRe为空").toJson();
		}
		//门店信息
		Set<BusinessStore> stores = new HashSet<>();
		for (BusinessStoreAccountRelation relation : storeAccountRe) {
			BusinessStore store = businessStoreDao.findById(relation.getStoreId());
			stores.add(store);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("stores", stores);
		return rs.succ(map).toJson();
	}

}
