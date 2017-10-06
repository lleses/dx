package cn.dc.user.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.dc.cart.domain.ShoppingCart;
import cn.dc.cart.domain.ShoppingCartRepository;
import cn.dc.user.domain.User;
import cn.dc.user.domain.UserRepository;
import cn.dc.utils.HttpUtils;

/**
 * 用户
 */
@RestController
@RequestMapping("user")
public class UserController {
	private final String WX_URL = "https://api.weixin.qq.com/sns/jscode2session";
	private final String APP_ID = "wx727ec12ce412a3e8";
	private final String APP_SECRET = "570b5ba87c923b0d671c106198933ef1";

	@Autowired
	private UserRepository userDao;
	@Autowired
	private ShoppingCartRepository shoppingCartDao;

	@RequestMapping("check")
	public String check(HttpServletRequest request, String code, String name) {
		String url = WX_URL + "?appid=" + APP_ID + "&secret=" + APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
		String rs = HttpUtils.get(url);
		
		JSONObject ob = JSON.parseObject(rs);
		//String sessionKey = ob.getString("session_key");
		String openid = ob.getString("openid");

		User user = userDao.findByOpenid(openid);
		if (user == null) {
			user = new User();
			user.setOpenid(openid);
			user.setName(name);
			userDao.save(user);
		}

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("user" + user.getId(), user);
		}

		//购物车
		ShoppingCart shoppingCart = shoppingCartDao.findByUserId(user.getId());
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			shoppingCart.setMoney(new BigDecimal(0));
			shoppingCart.setUserId(user.getId());
			shoppingCartDao.save(shoppingCart);
		}

		//{"session_key":"7VwhBX8xP24aS\/nclRBZxw==","expires_in":7200,"openid":"o9mEP0QNRNMN-DtwmliSuZJRLxrk"}
		String rsJson = JSON.toJSONString(shoppingCart);
		return rsJson;
	}

}
