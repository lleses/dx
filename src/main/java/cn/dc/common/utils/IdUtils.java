package cn.dc.common.utils;

import java.util.Date;
import java.util.UUID;

/**
 * ID工具
 * 
 * @author David
 * @date   2017年11月13日
 */
public class IdUtils {

	/** 时间长度  **/
	private static int TIME_LENGTH = 14;
	/** 时间格式  **/
	private static String TIME_FORMAT = "20[0-9][0-9](([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|(3[0,1]))(([0-1][0-9])|([2][0-3]))[0-5][0-9][0-5][0-9]";

	/**
	 * 获取UUID
	 * 
	 * @return 36位UUID字符串
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 根据当前时间生成20位ID
	 * 
	 * @return yyyyMMddHHmmssSSS+ranNum(3)
	 */
	public static String id20() {
		return secId(20, new Date());
	}

	/**
	 * 根据当前时间生成32位ID
	 * 
	 * @return yyyyMMddHHmmssSSS+ranNum(15)
	 */
	public static String id32() {
		return secId(32, new Date());
	}

	/**
	 * ID 生成 - 按时间生成,yyyyMMddHHmmssSSS(17位)+(len-17)位随机数字
	 * 
	 * @param len
	 *            长度,超过17的填充随机数字
	 * @param date
	 *            指定时间
	 * @return 指定长度的数字字符串
	 */
	private static String secId(int len, Date date) {
		StringBuilder id = new StringBuilder();
		id.append(DateUtils.DF_FULL.format(null != date ? date : new Date()));
		int l = len - 17;
		if (l > 0) {
			id.append(StringUtils.ranNum(l));
			return id.toString();
		} else {
			return id.substring(0, len);
		}
	}

	/**
	 * 基于id32()/id20()生成的id获取时间
	 * 
	 * @param id
	 *            id
	 * @return 时间(yyyy-MM-dd HH:mm:ss)/null
	 */
	public static String idToTime(String id) {
		if (null != id && id.length() > TIME_LENGTH) {
			String s = id.substring(0, 14);
			if (s.matches(TIME_FORMAT)) {
				StringBuilder sb = new StringBuilder(s);
				sb.insert(12, ":");
				sb.insert(10, ":");
				sb.insert(8, " ");
				sb.insert(6, "-");
				sb.insert(4, "-");
				return sb.toString();
			}
		}
		return null;
	}

}
