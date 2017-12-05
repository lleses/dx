//package cn.dc.order.service;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import cn.dc.cart.dao.CartRepository;
//import cn.dc.cart.entity.Cart;
//import cn.dc.commodity.dao.CommodityRepository;
//import cn.dc.commodity.entity.Commodity;
//import cn.dc.common.redis.RedisUtil;
//import cn.dc.common.utils.ParamUtils;
//import cn.dc.order.dao.OrderRepository;
//import cn.dc.order.entity.Order;
//
//@Service
//public class OrderService {
//
//	@Autowired
//	private OrderRepository orderDao;
//	@Autowired
//	private CartRepository cartDao;
//	@Autowired
//	private CommodityRepository commodityDao;
//	@Autowired
//	private RedisUtil redisUtil;
//
//	public String createOrder() {
//		//TODO
//		String userId = redisUtil.getUserId(sessionId);
//		if (userId == null) {
//			return null;//异常
//		}
//
//		BigDecimal actualMoney = new BigDecimal(0);
//		BigDecimal totalMoney = new BigDecimal(0);
//		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
//		if (carts == null || carts.isEmpty()) {
//			return null;//异常
//		}
//
//		for (Cart cart : carts) {
//			Commodity commodity = commodityDao.findById(cart.getCommodityId());
//			Integer num = cart.getNum();
//		}
//
//		Order order = new Order(storeId, userId);
//		order.setPayTypeStr(payType);
//		order.setActualMoney(actualMoney);//实收金额
//		order.setTotalMoney(totalMoney);//总金额
//		order.setPeople(people);//收货电话
//		order.setAddress(address);//送货地址
//		order.setDeskNum(deskNum);//台号
//		order.setRemark(remark);//备注
//		orderDao.save(order);
//		return null;
//	}
//}
