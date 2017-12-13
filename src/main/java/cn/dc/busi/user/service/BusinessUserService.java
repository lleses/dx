package cn.dc.busi.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessUser;

@Service
public class BusinessUserService {
	@Autowired
	private BusinessUserRepository businessUserDao;
//	@Autowired
//	private BusinessRepository businessDao;
//	@Autowired
//	private BusinessStoreRepository businessStoreDao;
//	@Autowired
//	private BusinessAccountRepository businessAccountDao;
//	@Autowired
//	private BusinessStoreAccountRelationRepository businessStoreAccountRelationDao;
//	@Autowired
//	private BusinessUserPushRepository businessUserPushDao;
//	@Autowired
//	private BusinessUserService businessUserService;
//	@Autowired
//	private RedisUtil redisUtil;
//
//	/**
//	 * 校验参数
//	 * 
//	 * @param sessionId
//	 * @return
//	 * 		统一返回的结果集合
//	 */
//	public ResultInfoMapImpl<String, Object> checkBindCheckParams(String sessionId) {
//		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
//		if (sessionId == null) {
//			return rs.errLog(this.getClass().getName() + "--sessionId为空");
//		}
//		String openId = redisUtil.getOpenId(sessionId);
//		if (openId == null) {
//			return rs.errLog(this.getClass().getName() + "--openId为空");
//		}
//		//检查商家用户是否存在
//		BusinessUser businessUser = businessUserDao.findByOpenId(openId);
//		if (businessUser == null) {
//			return rs.errLog(this.getClass().getName() + "--businessUser对象为空");
//		} else if (businessUser.getAccountId() == null) {
//			//用户没有绑定账号，跳转登陆页
//			return rs.go(ResultInfoImpl.TO_LOGIN_VIEW);
//		}
//		//检查商家用户的账号和店面的绑定是否正常
//		List<BusinessStoreAccountRelation> storeAccountRe = businessStoreAccountRelationDao.findByAccountId(businessUser.getAccountId());
//		if (storeAccountRe == null || storeAccountRe.isEmpty()) {
//			return rs.errLog(this.getClass().getName() + "--storeAccountRe为空");
//		}
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("storeAccountRe", storeAccountRe);
//		return rs.succ(map);
//
//	}
//
//	/**
//	 * 校验参数
//	 * 
//	 * @param sessionId
//	 * @return
//	 * 		统一返回的结果集合
//	 */
//	public ResultInfoMapImpl<String, Object> loginCheckParams(String sessionId, String username, String password) {
//		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
//		//校验参数有效性
//		if (sessionId == null || username == null || password == null) {
//			return rs.errLog(this.getClass().getName() + "--值为空,sessionId=" + sessionId + ",username=" + username + ",password=" + password);
//		}
//		String openId = redisUtil.getOpenId(sessionId);
//		if (openId == null) {
//			return rs.errLog(this.getClass().getName() + "--openId为空");
//		}
//		//核对账号信息有效性
//		password = IdUtils.md5(password);
//		BusinessAccount account = businessAccountDao.findByUsernameAndPassword(username, password);
//		if (account == null) {
//			return rs.err("账号密码不正确");
//		}
//		//核对商家用户信息有效性
//		BusinessUser user = businessUserDao.findByOpenId(openId);
//		if (user == null) {
//			return rs.errLog(this.getClass().getName() + "--商家用户不存在");
//		}
//
//		//检查商家用户的账号和店面的绑定是否正常
//		List<BusinessStoreAccountRelation> storeAccountRe = businessStoreAccountRelationDao.findByAccountId(account.getId());
//		if (storeAccountRe == null || storeAccountRe.isEmpty()) {
//			return rs.errLog(this.getClass().getName() + "--storeAccountRe为空");
//		}
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("storeAccountRe", storeAccountRe);
//		map.put("user", user);
//		map.put("account", account);
//		return rs.succ();
//
//	}
//
	/**
	 * 判断是否需要新增商家用户信息，并返回商家用户ID
	 * 
	 * @param wxSession
	 * 			微信session信息
	 * @param businessId
	 * 			商家ID
	 * @return
	 * 		消费者ID
	 */
	public String checkAddAndGetBusinessUserId(String openId, String businessId) {
		BusinessUser businessUser = businessUserDao.findByOpenId(openId);
		if (businessUser == null) {
			businessUser = new BusinessUser(openId, null);
			businessUserDao.save(businessUser);
		}
		return businessUser.getId();
	}

}
