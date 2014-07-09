package com.smartlife.util;

import android.content.Context;
import android.widget.Toast;

/**
 * UI工具类,提供一些常用的UI操作类
 */
public class UIHelperUtil {

	public static void makeToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	
}
