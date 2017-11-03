//package cn.dc.order.controller;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//
//import cn.dc.cart.domain.ShoppingCart;
//import cn.dc.cart.domain.ShoppingCartRepository;
//import cn.dc.order.dao.OrderRecordRepository;
//import cn.dc.order.dao.OrderRelationshipRepository;
//import cn.dc.order.dao.OrderRepository;
//import cn.dc.order.entity.Order;
//import cn.dc.order.entity.OrderRelationship;
//import cn.dc.order.entity.OrderStatusEnum;
//import cn.dc.order.entity.PayStatusEnum;
//import cn.dc.order.service.OrderRelationshipService;
//import cn.dc.order.service.OrderService;
//import cn.dc.user.domain.User;
//import cn.dc.user.domain.UserRepository;
//
///**
// * 账单
// */
//@RestController
//@RequestMapping("order")
//public class OrderController {
//
//	@Autowired
//	private OrderService orderService;
//
//		
//	//	@Autowired
//	//	private OrderRepository orderDao;
//		@Autowired
//		private ShoppingCartRepository shoppingCartDao;
//		@Autowired
//		private UserRepository userDao;
//		@Autowired
//		private OrderRelationshipService orderRelationshipService;
//		
//	//
//	//	//TODO 准备删
//	//	@RequestMapping("list2")
//	//	public String list2(HttpServletRequest request) {
//	//		return "123";
//	//	}
//	//	
//	
//		@RequestMapping("getOrderlist")
//		public String getOrderlist(HttpServletRequest request, String storeId) {
//			List<Order> bills = orderService.getShopOrderList(storeId, "", "", 0, 0);
//			String json = JSON.toJSONString(bills, SerializerFeature.DisableCircularReferenceDetect);
//			return json;
//		}
//		
//		
//		@RequestMapping("detail")
//		public String detail(HttpServletRequest request, String orderId) {
//			
//			JSONObject orderDetai = orderService.getShopOrderDetail(orderId);
//			
//			String json = JSON.toJSONString(orderDetai, SerializerFeature.DisableCircularReferenceDetect);
//			return json;
//		}
//		
////		/**
////		 * @Description 更新订单动态，例如商家受理订单，发货，
////		 * @param request
////		 * @param orderId
////		 * @return
////		 * @author chico
////		 * @time 2017年11月2日 下午8:48:53
////		 */
////		@RequestMapping("updateOrder")
////		public String updateOrder(HttpServletRequest request, String orderId) {
////			
////			JSONObject orderDetai = orderService.getShopOrderDetail(orderId);
////			
////			String json = JSON.toJSONString(orderDetai, SerializerFeature.DisableCircularReferenceDetect);
////			return json;
////		}
//		
//		
//	
//		/**
//		 * @Description 用户下单保存
//		 * @param request
//		 * @param userId
//		 * @return
//		 * @author chico
//		 * @time 2017年11月2日 下午8:56:57
//		 */
//		@RequestMapping("save")
//		public String save(HttpServletRequest request,int userId, String phone,String address,String storeId) {
//			List<ShoppingCart> carts = shoppingCartDao.findByUserId(userId);
//			if (carts != null && !carts.isEmpty()) {
//				BigDecimal zj = getZj(carts);
//				Order order = orderService.createOrder(phone, address, zj, storeId);
//	
//				
//
//				for (ShoppingCart cart : carts) {
//					OrderRelationship orderRelationship= new OrderRelationship();
//					orderRelationship.setOrderId(order.getId());
//					orderRelationship.setMoney(cart.getMoney());
//					orderRelationship.setPriceType(cart.getCommodity().getPriceType());
//					orderRelationship.setName(cart.getCommodity().getName());
//					orderRelationship.setNum(cart.getNum());
//					orderRelationshipService.savrOrderRelationship(orderRelationship);
//				}
//				delShoppingCarts(carts);
//			}
//			return "1";
//		}
//	
//		/** 获取总价格 **/
//		private BigDecimal getZj(List<ShoppingCart> carts) {
//			BigDecimal zj = new BigDecimal(0);
//			for (ShoppingCart shoppingCart : carts) {
//				zj = zj.add(shoppingCart.getMoney());
//			}
//			return zj;
//		}
//	
//		private void delShoppingCarts(List<ShoppingCart> carts) {
//			for (ShoppingCart cart : carts) {
//				shoppingCartDao.delete(cart);
//			}
//		}
//
//}
