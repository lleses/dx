package cn.dc.user.cart.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.db.module.cart.dao.CartRepository;
import cn.dc.db.module.cart.entity.Cart;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.entity.Product;
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
	private ProductRepository productDao;
	@Autowired
	private ConsumerRepository consumerDao;
	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping("toPay")
	public String toPay(HttpServletRequest request, String sessionId, String storeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null) {
			rs = rs.errLog(this.getClass().getName() + "--值为空: sessionId=" + sessionId + ",storeId=" + storeId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog(this.getClass().getName() + "--值为空: userId=" + userId);
			return rs.toJson();
		}
		Consumer consumer = consumerDao.findById(userId);
		if (consumer == null) {
			rs = rs.errLog(this.getClass().getName() + "--user对象为空");
			return rs.toJson();
		}
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		BigDecimal zj = new BigDecimal(0);
		Integer level = consumer.getLevel();
		List<Product> products = new ArrayList<>();
		for (Cart cart : carts) {
			Product product = productDao.findById(cart.getProductId());
			BigDecimal dj = new BigDecimal(0);//菜品x数量的价格
			if (level == null || level == 0) {//普通会员
				dj = product.getPrice().multiply(new BigDecimal(cart.getNum()));
			} else {//1级会员
				dj = product.getMemberPrice().multiply(new BigDecimal(cart.getNum()));
			}
			zj = zj.add(dj);
			products.add(product);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("carts", carts);
		map.put("zj", zj);
		map.put("level", level);
		map.put("products", products);
		String json = rs.succ(map).toJson();
		return json;
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, String sessionId, String storeId, String productId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null || productId == null) {
			rs = rs.errLog(this.getClass().getName() + "--值为空: sessionId=" + sessionId + ",storeId=" + storeId + ",productId=" + productId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog(this.getClass().getName() + "--userId值为空");
			return rs.toJson();
		}
		Cart cart = cartDao.findByUserIdAndStoreIdAndProductId(userId, storeId, productId);
		if (cart == null) {
			cart = new Cart(userId, storeId, productId);
		} else {
			cart.setNum(cart.getNum() + 1);
		}
		cartDao.save(cart);
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		Map<String, Object> map = new HashMap<>();
		map.put("carts", carts);
		String json = rs.succ(map).toJson();
		return json;
	}

	@RequestMapping("less")
	public String less(HttpServletRequest request, String sessionId, String productId, String storeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (sessionId == null || storeId == null || productId == null) {
			rs = rs.errLog(this.getClass().getName() + "--值为空: sessionId=" + sessionId + ",storeId=" + storeId + ",productId=" + productId);
			return rs.toJson();
		}
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs = rs.errLog(this.getClass().getName() + "--userId值为空");
			return rs.toJson();
		}
		Cart cart = cartDao.findByUserIdAndStoreIdAndProductId(userId, storeId, productId);
		if (cart == null) {
			rs = rs.errLog(this.getClass().getName() + "--cart对象为空");
			return rs.toJson();
		}
		Integer num = cart.getNum();
		if (num == null) {
			rs = rs.errLog(this.getClass().getName() + "--数量为空");
			return rs.toJson();
		}
		if (num <= 1) {
			cartDao.delete(cart);
		} else {
			cart.setNum(cart.getNum() - 1);
			cartDao.save(cart);
		}
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		Map<String, Object> map = new HashMap<>();
		map.put("carts", carts);
		String json = rs.succ(map).toJson();
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
