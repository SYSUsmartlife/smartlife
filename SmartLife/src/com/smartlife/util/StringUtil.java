package com.smartlife.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理的统一工具类
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空，是空（null或者由空格组成或者长度为0）的话返回true，否则返回false
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string == null || string.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否是邮箱格式
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmail(String string) {
		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否只包含大小写字母，数字和下划线
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isValidUserNameOrPassword(String string) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_]+)$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
}
