package com.smartlife.util;

/**
 * 字符串处理的统一工具类
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空，是空（null或者由空格组成或者长度为0）的话返回true，否则返回false
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
	
}
