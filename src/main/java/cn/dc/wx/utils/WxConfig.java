package cn.dc.wx.utils;

import org.springframework.beans.factory.annotation.Value;

public class WxConfig {

	@Value("${wx.appId}")
	public static String APP_ID;
	@Value("${wx.appSecret}")
	public static String APP_SECRET;
	@Value("${wx.sessionUrl}")
	public static String SESSION_URL;
	@Value("${wx.grantType}")
	public static String GRANT_TYPE;
}
