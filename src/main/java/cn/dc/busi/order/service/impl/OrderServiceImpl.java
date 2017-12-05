package cn.dc.busi.order.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.busi.order.service.OrderService;
import cn.dc.comm.dto.ResultInfo;
import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.dto.impl.ResultInfoMapImpl;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.entity.BusinessStore;
import cn.dc.db.module.cart.dao.CartRepository;
import cn.dc.db.module.cart.entity.Cart;
import cn.dc.db.module.order.dao.OrderRepository;
import cn.dc.db.module.order.entity.Order;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.user.dao.UserRepository;
import cn.dc.db.module.user.entity.User;

/**
 * 订单业务逻辑
 * 
 * @author didi
 * @date 2017年12月6日
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private CartRepository cartDao;
	@Autowired
	private ProductRepository productDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	@Autowired
	private UserRepository userDao;

	/**
	 *  创建订单
	 *  
	 * @param order
	 * 			订单entity
	 * @return
	 * 			统一返回的结果集合
	 */
	public ResultInfo createOrder(Order order) {
		//验证订单参数是否有误
		ResultInfoMapImpl<String, Object> rs = checkParams(order);
		if (rs.isErr()) {
			return rs;
		}
		//计算金额,并装进order
		order = calculateMoney(rs);
		//保存订单
		orderDao.save(order);
		return new ResultInfoImpl<>().succ();
	}

	/**
	 * 验证订单参数是否有误
	 * 
	 * @param userId
	 * 			消费者ID
	 * @param storeId
	 * 			店铺ID
	 * @param payType
	 * 			支付类型
	 * @return
	 * 			统一返回的结果集合
	 */
	private ResultInfoMapImpl<String, Object> checkParams(Order order) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		String userId = order.getUserId();
		String storeId = order.getStoreId();
		if (userId == null || storeId == null) {
			return rs.err("值不能为空,userId=" + userId + ",storeId=" + storeId);
		}
		User user = userDao.findById(userId);
		if (user == null) {
			return rs.err("用户不存在,userId=" + userId);
		}
		BusinessStore store = businessStoreDao.findById(storeId);
		if (store == null) {
			return rs.err("店铺不存在,storeId=" + storeId);
		}
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		if (carts == null || carts.isEmpty()) {
			return rs.err("购物车不存在,userId=" + userId + ",storeId=" + storeId);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("order", order);
		map.put("user", user);
		map.put("carts", carts);
		return rs.succ(map);
	}

	/**
	 * 计算金额,并装进order
	 * 
	 * @param rs
	 * 		统一返回的结果集合
	 * @return
	 * 		表单Entity
	 */
	private Order calculateMoney(ResultInfoMapImpl<String, Object> rs) {
		Order order = rs.getObject("order", Order.class);
		User user = rs.getObject("user", User.class);
		List<Cart> carts = rs.getList("carts", Cart.class);
		Integer level = user.getLevel();
		BigDecimal totalMoney = new BigDecimal(0);//总金额
		BigDecimal actualMoney = new BigDecimal(0);//实收金额
		for (Cart cart : carts) {
			Integer num = cart.getNum();
			Product commodity = productDao.findById(cart.getProductId());
			//计算总金额
			BigDecimal price = commodity.getPrice();//原价
			BigDecimal tempTotalMoney = price.multiply(new BigDecimal(num));
			totalMoney.add(tempTotalMoney);
			//计算实收金额
			BigDecimal memberPrice = commodity.getMemberPrice();//会员价
			BigDecimal tempActualMoney = null;
			if (level == null) {//非会员
				tempActualMoney = price.multiply(new BigDecimal(num));
			} else {//会员
				tempActualMoney = memberPrice.multiply(new BigDecimal(num));
			}
			actualMoney.add(tempActualMoney);
		}
		order.setActualMoney(actualMoney);//实收金额
		order.setTotalMoney(totalMoney);//总金额
		return order;
	}

}
