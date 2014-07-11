package com.smartlife.network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserConfig {
	
	public static int USER_ID_INVALID = -1;
	
	private Context mContext;
	/**
	 * 用户Id,登录后设置
	 */
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		SharedPreferences sp = mContext.getSharedPreferences("smartlife_user", Activity.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt("userId", userId);
		editor.commit();
	}
	
	/**
	 * 单例引用
	 */
	private static volatile UserConfig mSingleInstance;
	
	private UserConfig(Context context) {
		mContext = context;
		SharedPreferences sp = mContext.getSharedPreferences("smartlife_user", Activity.MODE_PRIVATE);
		userId = sp.getInt("userId", USER_ID_INVALID);
	}
	
	public static UserConfig getInstance(Context context) {
		if (mSingleInstance == null) {
			synchronized (UserConfig.class) {
				if (mSingleInstance == null) {
					mSingleInstance = new UserConfig(context);
				}
			}
		}
		return mSingleInstance;
	}
}
