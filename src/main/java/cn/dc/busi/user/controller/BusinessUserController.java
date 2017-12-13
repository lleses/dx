package cn.dc.busi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商家用户
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("busi/user")
public class BusinessUserController {
//
//	@Autowired
//	private BusinessStoreRepository businessStoreDao;
//	@Autowired
//	private BusinessUserRepository businessUserDao;
//	@Autowired
//	private BusinessUserService businessUserService;
//
//	/** 检查是否已经绑定 **/
//	@RequestMapping("checkBind")
//	public String checkBind(HttpServletRequest request, String sessionId) {
//		//校验参数
//		ResultInfoMapImpl<String, Object> rs = businessUserService.checkBindCheckParams(sessionId);
//		if (!rs.checkSucc()) {
//			return rs.toJson();
//		}
//
//		//如果还没绑定，进入[登陆页]
//		//如果已经绑定，有一个店面,进入[首页]
//		//如果已经绑定，有多个店面,进入[店面列表选择页]
//
//		List<BusinessStoreAccountRelation> storeAccountRe = rs.getList("storeAccountRe", BusinessStoreAccountRelation.class);
//		//TODO 这里还有很多代码
//		if (storeAccountRe.size() == 1) {
//			//获取账单信息，推送信息
//
//			//只有一个店面,直接进入首页
//			return rs.go(ResultInfoImpl.TO_INDEX_VIEW).toJson();
//		} else {
//			//获取店面信息
//			Set<BusinessStore> stores = new HashSet<>();
//			for (BusinessStoreAccountRelation relation : storeAccountRe) {
//				BusinessStore store = businessStoreDao.findById(relation.getStoreId());
//				stores.add(store);
//			}
//			//有多个店面,则直接进入[店面列表选择页]
//			return rs.go(ResultInfoImpl.TO_STORE_LIST_VIEW).toJson();
//		}
//
//	}
//
//	//登陆
//	@RequestMapping("login")
//	public String login(HttpServletRequest request, String username, String password, String sessionId) {
//		//校验参数
//		ResultInfoMapImpl<String, Object> rsMap = businessUserService.checkBindCheckParams(sessionId);
//		if (!rsMap.checkSucc()) {
//			return rsMap.toJson();
//		}
//
//		List<BusinessStoreAccountRelation> storeAccountRe = rsMap.getList("storeAccountRe", BusinessStoreAccountRelation.class);
//		BusinessAccount account = rsMap.getObject("account", BusinessAccount.class);
//		BusinessUser user = rsMap.getObject("user", BusinessUser.class);
//
//		//绑定账号
//		user.setAccountId(account.getId());
//		user.setEt(new Date());
//		businessUserDao.save(user);
//
//		ResultInfoImpl<Object> rs = new ResultInfoImpl<Object>();
//		//TODO 这里还有很多代码
//		if (storeAccountRe.size() == 1) {
//			//[code:1]--只有一个店面,直接进入首页
//
//			//获取账单信息，推送信息
//
//			return rs.go(ResultInfoImpl.TO_INDEX_VIEW, null).toJson();
//		} else {
//			//[code:2]--有多个店面,则直接进入[店面列表选择页]]
//			//获取店面信息
//			Set<BusinessStore> stores = new HashSet<>();
//			for (BusinessStoreAccountRelation relation : storeAccountRe) {
//				BusinessStore store = businessStoreDao.findById(relation.getStoreId());
//				stores.add(store);
//			}
//			return rs.go(ResultInfoImpl.TO_STORE_LIST_VIEW, stores).toJson();
//		}
//	}

}
