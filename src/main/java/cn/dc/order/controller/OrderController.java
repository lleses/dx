package cn.dc.order.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.order.dao.OrderRecordRepository;
import cn.dc.order.dao.OrderRelationshipRepository;
import cn.dc.order.dao.OrderRepository;
import cn.dc.order.entity.OrderStatusEnum;
import cn.dc.order.entity.PayStatusEnum;

/**
 * 账单
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private OrderRecordRepository orderRecordDao;
	@Autowired
	private OrderRelationshipRepository orderRelationshipDao;


	//	@Autowired
	//	private BillRepository billDao;
	//	@Autowired
	//	private OrderRepository orderDao;
	//	@Autowired
	//	private ShoppingCartRepository shoppingCartDao;
	//	@Autowired
	//	private UserRepository userDao;
	//
	//	//TODO 准备删
	//	@RequestMapping("list2")
	//	public String list2(HttpServletRequest request) {
	//		return "123";
	//	}
	//	
	//	@RequestMapping("list")
	//	public String list(HttpServletRequest request, int userId) {
	//		List<Bill> bills = billDao.findAll();
	//		String json = JSON.toJSONString(bills, SerializerFeature.DisableCircularReferenceDetect);
	//		return json;
	//	}
	//
	//	@RequestMapping("detail")
	//	public String detail(HttpServletRequest request, int billId) {
	//		List<Order> orders = orderDao.findByBillId(billId);
	//		String json = JSON.toJSONString(orders, SerializerFeature.DisableCircularReferenceDetect);
	//		return json;
	//	}
	//
	//	@RequestMapping("save")
	//	public String save(HttpServletRequest request, int userId) {
	//		List<ShoppingCart> carts = shoppingCartDao.findByUserId(userId);
	//		if (carts != null && !carts.isEmpty()) {
	//			BigDecimal zj = getZj(carts);
	//			User user = userDao.findById(userId);
	//			Bill bill = new Bill(user, zj);
	//			billDao.save(bill);
	//
	//			for (ShoppingCart cart : carts) {
	//				Order order = new Order();
	//				order.setBillId(bill.getId());
	//				order.setMoney(cart.getMoney());
	//				order.setCommodity(cart.getCommodity());
	//				order.setNum(cart.getNum());
	//				order.setUser(user);
	//				orderDao.save(order);
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
