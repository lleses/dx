package cn.dc.busi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.busi.dao.BusinessAccountRepository;
import cn.dc.busi.dao.BusinessRepository;
import cn.dc.busi.dao.BusinessStoreAccountRelationRepository;
import cn.dc.busi.dao.BusinessStoreRepository;
import cn.dc.busi.dao.BusinessUserPushRepository;
import cn.dc.busi.dao.BusinessUserRepository;
import cn.dc.busi.entity.BusinessAccount;
import cn.dc.busi.entity.BusinessUser;
import cn.dc.common.redis.RedisUtil;
import cn.dc.common.utils.IdUtils;

@RestController
@RequestMapping("business")
public class BusinessController {

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
		String openId = redisUtil.getOpenId(sessionId);
		//检查商家用户是否存在
		
		//如果不存在则返回登陆页
		
		
		
		//如果存在则直接进入首页
		//获取店面id
		
		
		
		return null;
	}

	//登陆
	@RequestMapping("login")
	public String login(HttpServletRequest request, String username, String password, String sessionId) {
		String openId = redisUtil.getOpenId(sessionId);
		password = IdUtils.md5(password);
		BusinessAccount account = businessAccountDao.findByUsername(username);
		if (account == null) {
			return "账号不存在";
		}
		//商家用户
		BusinessUser user = businessUserDao.findByOpenId(openId);
		if (user == null) {
			user = new BusinessUser(openId, account.getId(), null, null);
			businessUserDao.save(user);
		}

		//		Integer userId = redisUtil.getUserId(sessionId);
		//		User user = userDao.findById(userId);
		//		Cart cart = cartDao.findByUserId(userId);
		//		List<CartRelationship> CartRelationships = new ArrayList<>();
		//		if (cart != null) {
		//			CartRelationships = cartRelationshipDao.findByCartId(cart.getId());
		//		}
		//		Map<String, Object> map = new HashMap<>();
		//		map.put("user", user);
		//		map.put("cartRelationships", CartRelationships);
		//String json = JSON.toJSONString(map);
		return null;
	}

}
