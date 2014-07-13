package com.smartlife.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

/**
 * UI工具类,提供一些常用的UI操作类
 */
public class UIHelperUtil {

	private static AlertDialog.Builder builder;
	private static Dialog dialog;

	public static void makeToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void createDialog(Context context, boolean cancelable,
			boolean withProgress, boolean withContent, String content) {
		builder = new AlertDialog.Builder(context);
		dialog = builder.setCancelable(cancelable)
				.setIcon(android.R.drawable.progress_horizontal).create();
		if (withContent)
			builder.setMessage(content);
		dialog.show();
	}

	/**
	 * 隐藏之前创建的Dialog，如果之前未创建则怎么都不做<br>
	 * 只能取消最后一次打开的Dialog
	 */
	public static void hidePreCreateDialog() {
		if (dialog == null)
			return;
		if (dialog.isShowing())
			dialog.dismiss();
	}

}
