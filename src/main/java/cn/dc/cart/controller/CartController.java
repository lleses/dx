package cn.dc.cart.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.cart.dao.CartRelationshipRepository;
import cn.dc.cart.dao.CartRepository;
import cn.dc.cart.entity.Cart;
import cn.dc.cart.entity.CartRelationship;
import cn.dc.commodity.entity.Commodity;
import cn.dc.common.redis.RedisUtil;
import cn.dc.user.dao.UserRepository;
import cn.dc.user.entity.User;

/**
 * 购物车
 */
@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartRepository cartDao;
	@Autowired
	private CartRelationshipRepository cartRelationshipDao;
	@Autowired
	private UserRepository userDao;
	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping("index")
	public String index(HttpServletRequest request, String sessionId) {
		Integer userId = redisUtil.getUserId(sessionId);
		User user = userDao.findById(userId);
		Cart cart = cartDao.findByUserId(userId);
		List<CartRelationship> CartRelationships = new ArrayList<>();
		if (cart != null) {
			CartRelationships = cartRelationshipDao.findByCartId(cart.getId());
		}
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("cartRelationships", CartRelationships);
		String json = JSON.toJSONString(map);
		return json;
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, String sessionId, int commodityId, long price) {
		Integer userId = redisUtil.getUserId(sessionId);
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
			cart.setMoney(new BigDecimal(price));
			cartDao.save(cart);
		} else {
			BigDecimal money = cart.getMoney();
			money = money.add(new BigDecimal(price));
			cart.setMoney(money);
			cartDao.save(cart);
		}

		CartRelationship cartRelationship = cartRelationshipDao.findByCartIdAndCommodityId(cart.getId(), commodityId);
		if (cartRelationship == null) {
			cartRelationship = new CartRelationship();
			cartRelationship.setCartId(cart.getId());
			cartRelationship.setCommodity(new Commodity(commodityId));
			cartRelationship.setNum(1);
			cartRelationship.setMoney(new BigDecimal(price));
			cartRelationshipDao.save(cartRelationship);
		} else {
			int num = cartRelationship.getNum();
			num++;
			cartRelationship.setNum(num);
			cartRelationship.setMoney(new BigDecimal(num * price));
			cartRelationshipDao.save(cartRelationship);
		}
		return "1";
	}

	@RequestMapping("less")
	public String less(HttpServletRequest request, String sessionId, int commodityId, long price) {
		Integer userId = redisUtil.getUserId(sessionId);
		Cart cart = cartDao.findByUserId(userId);
		if (cart != null) {
			BigDecimal money = cart.getMoney();
			money = money.subtract(new BigDecimal(price));

			if (checkMoney(money)) {
				cart.setMoney(money);
				cartDao.save(cart);
			}

			CartRelationship cartRelationship = cartRelationshipDao.findByCartIdAndCommodityId(cart.getId(), commodityId);
			if (cartRelationship != null) {
				int num = cartRelationship.getNum();
				num--;
				if (num > 0) {
					cartRelationship.setNum(num);
					cartRelationship.setMoney(new BigDecimal(num * price));
					cartRelationshipDao.save(cartRelationship);
				} else {
					cartRelationshipDao.delete(cartRelationship);
				}
			}

			if (!checkMoney(money)) {
				cartDao.delete(cart);
			}
		}
		return "1";
	}

	/** 判断金额是否大于0(true:金额>0, false:金额=<0) **/
	private boolean checkMoney(BigDecimal money) {
		//结果是:-1 小于,0 等于,1 大于
		if (money.compareTo(new BigDecimal(0)) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("saveUserInfo")
	public String saveUserInfo(HttpServletRequest request, String sessionId, User user) {
		Integer userId = redisUtil.getUserId(sessionId);
		User us = userDao.findById(userId);
		us.setName(user.getName());
		us.setPhone(user.getPhone());
		us.setAddress(user.getAddress());
		us.setDetailedAddress(user.getDetailedAddress());
		userDao.save(us);
		return "1";
	}

}
