package cn.dc.user.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.db.module.cart.dao.CartRepository;
import cn.dc.db.module.cart.entity.Cart;
import cn.dc.db.module.user.dao.ConsumerRepository;
import cn.dc.db.module.user.entity.Consumer;

/**
 * 购物车
 */
@RestController
@RequestMapping("user/cart")
public class CartController {

	@Autowired
	private CartRepository cartDao;
	@Autowired
	private ConsumerRepository consumerDao;
	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping("toPay")
	public String toPay(HttpServletRequest request, String sessionId, String storeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null) {
			rs = rs.errLog("cart/toPay--值为空: sessionId=" + sessionId + ",storeId=" + storeId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog("cart/toPay--值为空: userId=" + userId);
			return rs.toJson();
		}
		Consumer user = consumerDao.findById(userId);
		if (user == null) {
			rs = rs.errLog("cart/toPay--user对象为空");
			return rs.toJson();
		}
		List<Cart> cart = cartDao.findByUserIdAndStoreId(userId, storeId);
		String json = rs.succ(cart).toJson();
		return json;
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, String sessionId, String storeId, String productId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null || productId == null) {
			rs = rs.errLog("cart/add--值为空: sessionId=" + sessionId + ",storeId=" + storeId + ",productId=" + productId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog("cart/add--userId值为空");
			return rs.toJson();
		}
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			cart = new Cart(userId, storeId, productId);
		} else {
			cart.setNum(cart.getNum() + 1);
		}
		cartDao.save(cart);
		String json = rs.succ().toJson();
		return json;
	}

	@RequestMapping("less")
	public String less(HttpServletRequest request, String sessionId, String productId, String storeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null || productId == null) {
			rs = rs.errLog("cart/less--值为空: sessionId=" + sessionId + ",storeId=" + storeId + ",productId=" + productId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog("cart/less--userId值为空");
			return rs.toJson();
		}
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			rs = rs.errLog("cart/less--cart对象为空");
			return rs.toJson();
		}

		Integer num = cart.getNum();
		if (num == null) {
			rs = rs.errLog("cart/less--数量为空");
			return rs.toJson();
		}

		if (num <= 1) {
			cartDao.delete(cart);
		} else {
			cart.setNum(cart.getNum() - 1);
			cartDao.save(cart);
		}
		String json = rs.succ().toJson();
		return json;
	}

	//	@RequestMapping("saveUserInfo")
	//	public String saveUserInfo(HttpServletRequest request, String sessionId, User user) {
	//		Integer userId = redisUtil.getUserId(sessionId);
	//		User us = userDao.findById(userId);
	//		us.setName(user.getName());
	//		us.setPhone(user.getPhone());
	//		us.setAddress(user.getAddress());
	//		us.setDetailedAddress(user.getDetailedAddress());
	//		userDao.save(us);
	//		return "1";
	//	}

}
