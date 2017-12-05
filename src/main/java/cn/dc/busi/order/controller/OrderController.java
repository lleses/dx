package cn.dc.busi.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.busi.order.service.OrderService;
import cn.dc.comm.dto.ResultInfo;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.comm.utils.ParamUtils;
import cn.dc.db.module.order.entity.Order;
import cn.dc.db.module.order.entity.PayTypeEnum;

/**
 * 订单
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private OrderService orderService;

	/** 创建订单 **/
	@RequestMapping("create")
	public String create(HttpServletRequest request) {
		//获取参数集，然后把参数集装进order对象
		Order order = handleParamsByCreate(request);
		//业务处理
		ResultInfo rs = orderService.createOrder(order);
		String json = rs.toJson();
		return json;
	}

	/**
	 * 处理[create方法]的参数集
	 * 
	 * @param request
	 * @return
	 * 			订单Entity
	 */
	private Order handleParamsByCreate(HttpServletRequest request) {
		//收集参数
//		String sessionId = ParamUtils.getStr(request, "sessionId");
//		String userId = redisUtil.getUserId(sessionId);
		
		//TODO
		String userId = ParamUtils.getStr(request, "userId");
		
		PayTypeEnum payType = ParamUtils.paramEnum(request, PayTypeEnum.class, "payType");
		String storeId = ParamUtils.getStr(request, "storeId");
		String people = ParamUtils.getStr(request, "people");
		String address = ParamUtils.getStr(request, "address");
		Integer deskNum = ParamUtils.getInt(request, "deskNum");
		String remark = ParamUtils.getStr(request, "remark");

		//把参数集装进order对象
		Order order = new Order(storeId, userId);
		order.setPeople(people);//收货电话
		order.setAddress(address);//送货地址
		order.setDeskNum(deskNum);//台号
		order.setRemark(remark);//备注
		order.setPayType(payType);
		return order;
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
