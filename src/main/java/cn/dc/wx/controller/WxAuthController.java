//package cn.dc.wx.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidAlgorithmParameterException;
//import java.util.Arrays;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//
//import cn.dc.common.aes.Aes;
//import cn.dc.common.redis.RedisUtil;
//import cn.dc.user.dao.UserRepository;
//import cn.dc.user.entity.User;
//import cn.dc.wx.service.WxService;
//
///**
// * 用户
// * 
// * @author 余狄龙
// * @date   2017年11月13日
// */
//@RestController
//@RequestMapping("wxAuth")
//public class WxAuthController {
//
//	@Autowired
//	private WxService wxService;
//	@Autowired
//	private RedisUtil redisUtil;
//	@Autowired
//	private UserRepository userDao;
//
//	/**
//	 * 测试https服务器是否在运行
//	 */
//	@RequestMapping(value = "test", method = RequestMethod.GET)
//	public String test(HttpServletRequest request) {
//		return "test succ";
//	}
//
//	/**
//	 * 根据客户端传过来的code从微信服务器获取appid和session_key，
//	 * 然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
//	 * 
//	 * @param wxCode	
//	 * 			小程序登录时获取的code
//	 * @return
//	 */
//	@RequestMapping(value = "createSssion", method = RequestMethod.GET)
//	public String createSssion(HttpServletRequest request, String sessionId, String code, String appId) {
//		//检查是否需要请求微信,获取新的session信息
//		boolean isRequesetWx = checkIsNeedToRequestWx(sessionId);
//		if (isRequesetWx) {
//			JSONObject wxSession = wxService.getWxSession(code, appId);
//			String wxOpenId = wxSession.getString("openid");
//			String wxSessionKey = wxSession.getString("session_key");
//			Long expires = wxSession.getLong("expires_in");
//
//			if (wxOpenId == null) {
//				return null;
//			}
//			User user = userDao.findByOpenid(wxOpenId);
//			if (user == null) {
//				user = new User();
//				user.setOpenid(wxOpenId);
//				user.setAppId(appId);
//				userDao.save(user);
//			}
//			sessionId = wxService.create3rdSession(request, wxOpenId, wxSessionKey, expires, user.getId());
//		}
//		return sessionId;
//	}
//
//	/**
//	 * 检查是否需要请求微信,获取新的session信息
//	 * 
//	 * @param sessionId
//	 * @return true:请求微信接口 false:不需要请求
//	 */
//	private boolean checkIsNeedToRequestWx(String sessionId) {
//		//初始登陆，客户端并没有传sessionId过来，所以为null
//		if (sessionId == null || "".equals(sessionId)) {
//			return true;
//		}
//		String sessionVal = (String) redisUtil.get(sessionId);
//		//session已过期
//		if (sessionVal == null) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 验证用户信息完整性
//	 * @param rawData	微信用户基本信息
//	 * @param signature	数据签名
//	 * @param sessionId	会话ID
//	 * @return
//	 */
//	@RequestMapping(value = "checkUserInfo", method = RequestMethod.GET)
//	public Boolean checkUserInfo(HttpServletRequest request, String rawData, String signature, String sessionId) {
//		Object wxSessionObj = redisUtil.get(sessionId);
//		if (null == wxSessionObj) {
//			return false;
//		}
//		String wxSessionStr = (String) wxSessionObj;
//		String sessionKey = wxSessionStr.split("#")[0];
//		StringBuffer sb = new StringBuffer(rawData);
//		sb.append(sessionKey);
//
//		byte[] encryData = DigestUtils.sha1(sb.toString());
//		byte[] signatureData = signature.getBytes();
//		Boolean checkStatus = Arrays.equals(encryData, signatureData);
//		return checkStatus;
//	}
//
//	/**
//	 * 获取用户openId和unionId数据(如果没绑定微信开放平台，解密数据中不包含unionId)
//	 * @param encryptedData 加密数据
//	 * @param iv			加密算法的初始向量	
//	 * @param sessionId		会话ID
//	 * @return
//	 */
//	@RequestMapping(value = "decodeUserInfo", method = RequestMethod.GET)
//	public String decodeUserInfo(HttpServletRequest request, String encryptedData, String iv, String sessionId) {
//		Object wxSessionObj = redisUtil.get(sessionId);
//		if (null == wxSessionObj) {
//			return "-1";
//		}
//		String wxSessionStr = (String) wxSessionObj;
//		String sessionKey = wxSessionStr.split("#")[0];
//
//		try {
//			Aes aes = new Aes();
//			byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
//			if (null != resultByte && resultByte.length > 0) {
//				String userInfo = new String(resultByte, "UTF-8");
//				return userInfo;
//			}
//		} catch (InvalidAlgorithmParameterException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
