package cn.dc.order.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.busi.dao.BusinessStoreRepository;
import cn.dc.busi.entity.BusinessStore;
import cn.dc.cart.dao.CartRepository;
import cn.dc.cart.entity.Cart;
import cn.dc.commodity.dao.CommodityRepository;
import cn.dc.commodity.entity.Commodity;
import cn.dc.common.redis.RedisUtil;
import cn.dc.common.utils.ParamUtils;
import cn.dc.order.dao.OrderRepository;
import cn.dc.order.entity.Order;
import cn.dc.order.entity.PayTypeEnum;
import cn.dc.user.dao.UserRepository;
import cn.dc.user.entity.User;

/**
 * 账单
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private CartRepository cartDao;
	@Autowired
	private CommodityRepository commodityDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	@Autowired
	private UserRepository userDao;
	@Autowired
	private RedisUtil redisUtil;
	//	@Autowired
	//	private OrderService orderService;

	//TODO
	/** 创建订单 **/
	@RequestMapping("createOrder")
	public String createOrder(HttpServletRequest request) {
		//收集参数
		String payType = ParamUtils.getStr(request, "payType");
		String storeId = ParamUtils.getStr(request, "storeId");
		String sessionId = ParamUtils.getStr(request, "sessionId");
		String people = ParamUtils.getStr(request, "people");
		String address = ParamUtils.getStr(request, "address");
		Integer deskNum = ParamUtils.getInt(request, "deskNum");
		String remark = ParamUtils.getStr(request, "remark");
		String userId = redisUtil.getUserId(sessionId);

		//验证订单参数是否有误
		if (userId == null || storeId == null) {
			return null;//异常
		}
		User user = userDao.findById(userId);
		if (user == null) {
			return null;//异常
		}
		BusinessStore store = businessStoreDao.findById(storeId);
		if (store == null) {
			return null;//异常
		}
		Order order = new Order(storeId, userId);
		if ("WXZF".equals(payType)) {
			order.setPayType(PayTypeEnum.WXZF);
		} else if ("DDZF".equals(payType)) {
			order.setPayType(PayTypeEnum.DDZF);
		} else if ("DDZF".equals(payType)) {
			order.setPayType(PayTypeEnum.JFZF);
		} else {
			return null;//异常
		}
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		if (carts == null || carts.isEmpty()) {
			return null;//异常
		}

		Integer level = user.getLevel();
		BigDecimal totalMoney = new BigDecimal(0);//总金额
		BigDecimal actualMoney = new BigDecimal(0);//实收金额
		for (Cart cart : carts) {
			Integer num = cart.getNum();
			Commodity commodity = commodityDao.findById(cart.getCommodityId());
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

		order.setPeople(people);//收货电话
		order.setAddress(address);//送货地址
		order.setDeskNum(deskNum);//台号
		order.setRemark(remark);//备注
		order.setActualMoney(actualMoney);//实收金额
		order.setTotalMoney(totalMoney);//总金额
		orderDao.save(order);

		return null;
	}

	//	@RequestMapping("getOrderlist")
	//	public String getOrderlist(HttpServletRequest request, String storeId) {
	//		List<Order> bills = orderService.getShopOrderList(storeId, "", "", 0, 0);
	//		String json = JSON.toJSONString(bills, SerializerFeature.DisableCircularReferenceDetect);
	//		return json;
	//	}
	//
	//	@RequestMapping("detail")
	//	public String detail(HttpServletRequest request, String orderId) {
	//
	//		JSONObject orderDetai = orderService.getShopOrderDetail(orderId);
	//
	//		String json = JSON.toJSONString(orderDetai, SerializerFeature.DisableCircularReferenceDetect);
	//		return json;
	//	}
	//
	//	//		/**
	//	//		 * @Description 更新订单动态，例如商家受理订单，发货，
	//	//		 * @param request
	//	//		 * @param orderId
	//	//		 * @return
	//	//		 * @author chico
	//	//		 * @time 2017年11月2日 下午8:48:53
	//	//		 */
	//	//		@RequestMapping("updateOrder")
	//	//		public String updateOrder(HttpServletRequest request, String orderId) {
	//	//			
	//	//			JSONObject orderDetai = orderService.getShopOrderDetail(orderId);
	//	//			
	//	//			String json = JSON.toJSONString(orderDetai, SerializerFeature.DisableCircularReferenceDetect);
	//	//			return json;
	//	//		}
	//
	//	/**
	//	 * @Description 用户下单保存
	//	 * @param request
	//	 * @param userId
	//	 * @return
	//	 * @author chico
	//	 * @time 2017年11月2日 下午8:56:57
	//	 */
	//	@RequestMapping("save")
	//	public String save(HttpServletRequest request, int userId, String phone, String address, String storeId) {
	//		List<ShoppingCart> carts = shoppingCartDao.findByUserId(userId);
	//		if (carts != null && !carts.isEmpty()) {
	//			BigDecimal zj = getZj(carts);
	//			Order order = orderService.createOrder(phone, address, zj, storeId);
	//
	//			for (ShoppingCart cart : carts) {
	//				OrderRelationship orderRelationship = new OrderRelationship();
	//				orderRelationship.setOrderId(order.getId());
	//				orderRelationship.setMoney(cart.getMoney());
	//				orderRelationship.setPriceType(cart.getCommodity().getPriceType());
	//				orderRelationship.setName(cart.getCommodity().getName());
	//				orderRelationship.setNum(cart.getNum());
	//				orderRelationshipService.savrOrderRelationship(orderRelationship);
	//			}
	//			delShoppingCarts(carts);
	//		}
	//		return "1";
	//	}
	//
	//	/** 获取总价格 **/
	//	private BigDecimal getZj(List<ShoppingCart> carts) {
	//		BigDecimal zj = new BigDecimal(0);
	//		for (ShoppingCart shoppingCart : carts) {
	//			zj = zj.add(shoppingCart.getMoney());
	//		}
	//		return zj;
	//	}
	//
	//	private void delShoppingCarts(List<ShoppingCart> carts) {
	//		for (ShoppingCart cart : carts) {
	//			shoppingCartDao.delete(cart);
	//		}
	//	}

}
