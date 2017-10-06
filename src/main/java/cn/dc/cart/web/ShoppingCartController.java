package cn.dc.cart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.cart.domain.ShoppingCart;
import cn.dc.cart.domain.ShoppingCartRepository;

/**
 * 购物车
 */
@RestController
@RequestMapping("ShoppingCart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository shoppingCartDao;

	@RequestMapping("addOrLess")
	public String addOrLess(HttpServletRequest request, ShoppingCart shoppingCart) {
		shoppingCartDao.save(shoppingCart);
		return "1";
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, ShoppingCart shoppingCart) {
		shoppingCartDao.delete(shoppingCart);
		return "1";
	}

}
