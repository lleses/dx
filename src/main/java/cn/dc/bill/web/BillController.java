package cn.dc.bill.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.dc.bill.domain.Bill;
import cn.dc.bill.domain.BillRepository;
import cn.dc.bill.domain.Order;
import cn.dc.bill.domain.OrderRepository;
import cn.dc.cart.domain.ShoppingCart;
import cn.dc.cart.domain.ShoppingCartRepository;
import cn.dc.user.domain.User;
import cn.dc.user.domain.UserRepository;

/**
 * 账单
 */
@RestController
@RequestMapping("bill")
public class BillController {

	@Autowired
	private BillRepository billDao;
	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private ShoppingCartRepository shoppingCartDao;
	@Autowired
	private UserRepository userDao;

	//TODO 准备删
	@RequestMapping("list2")
	public String list2(HttpServletRequest request) {
		return "123";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, int userId) {
		List<Bill> bills = billDao.findAll();
		String json = JSON.toJSONString(bills, SerializerFeature.DisableCircularReferenceDetect);
		return json;
	}

	@RequestMapping("detail")
	public String detail(HttpServletRequest request, int billId) {
		List<Order> orders = orderDao.findByBillId(billId);
		String json = JSON.toJSONString(orders, SerializerFeature.DisableCircularReferenceDetect);
		return json;
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, int userId) {
		List<ShoppingCart> carts = shoppingCartDao.findByUserId(userId);
		if (carts != null && !carts.isEmpty()) {
			BigDecimal zj = getZj(carts);
			User user = userDao.findById(userId);
			Bill bill = new Bill(user, zj);
			billDao.save(bill);

			for (ShoppingCart cart : carts) {
				Order order = new Order();
				order.setBillId(bill.getId());
				order.setMoney(cart.getMoney());
				order.setCommodity(cart.getCommodity());
				order.setNum(cart.getNum());
				order.setUser(user);
				orderDao.save(order);
			}
			delShoppingCarts(carts);
		}
		return "1";
	}

	/** 获取总价格 **/
	private BigDecimal getZj(List<ShoppingCart> carts) {
		BigDecimal zj = new BigDecimal(0);
		for (ShoppingCart shoppingCart : carts) {
			zj = zj.add(shoppingCart.getMoney());
		}
		return zj;
	}

	private void delShoppingCarts(List<ShoppingCart> carts) {
		for (ShoppingCart cart : carts) {
			shoppingCartDao.delete(cart);
		}
	}

}
