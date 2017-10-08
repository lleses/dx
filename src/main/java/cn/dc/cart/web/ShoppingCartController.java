package cn.dc.cart.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.cart.domain.ShoppingCart;
import cn.dc.cart.domain.ShoppingCartRepository;
import cn.dc.commodity.domain.Commodity;
import cn.dc.user.domain.UserRepository;

/**
 * 购物车
 */
@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository shoppingCartDao;
	@Autowired
	private UserRepository userDao;

	@RequestMapping("index")
	public String index(HttpServletRequest request, int userId) {
		List<ShoppingCart> list = shoppingCartDao.findByUserId(userId);
		String json = JSON.toJSONString(list);
		return json;
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, int userId, int commodityId, long price) {
		ShoppingCart cart = shoppingCartDao.findByUserIdAndCommodityId(userId, commodityId);
		if (cart == null) {
			cart = new ShoppingCart();
			cart.setNum(0);
			cart.setCommodity(new Commodity(commodityId));
			cart.setUser(userDao.findById(userId));
		}

		int num = cart.getNum();
		num++;
		cart.setNum(num);
		cart.setMoney(new BigDecimal(num * price));
		shoppingCartDao.save(cart);
		return "1";
	}

	@RequestMapping("less")
	public String less(HttpServletRequest request, int userId, int commodityId, long price) {
		ShoppingCart cart = shoppingCartDao.findByUserIdAndCommodityId(userId, commodityId);
		int num = cart.getNum();
		if (num > 1) {
			num--;
			cart.setNum(num);
			cart.setMoney(new BigDecimal(num * price));
			shoppingCartDao.save(cart);
		} else {
			shoppingCartDao.delete(cart);
		}
		return "1";
	}

}
