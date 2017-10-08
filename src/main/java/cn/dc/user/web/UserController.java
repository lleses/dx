package cn.dc.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.dc.user.domain.User;
import cn.dc.user.domain.UserRepository;
import cn.dc.utils.HttpUtils;

/**
 * 用户
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Value("${dc.wxUrl}")
	private String WX_URL;
	@Value("${dc.appId}")
	private String APP_ID;
	@Value("${dc.appSecret}")
	private String APP_SECRET;

	@Autowired
	private UserRepository userDao;

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
		return user.getId().toString();
	}

}
