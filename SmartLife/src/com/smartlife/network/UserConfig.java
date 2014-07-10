package com.smartlife.network;

public class UserConfig {

	/**
	 * 用户Id,登录后设置
	 */
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 单例引用
	 */
	private static UserConfig mSingleInstance;
	
	private UserConfig() {
		userId = -1;
	}
	
	public static synchronized UserConfig getInstance() {
		if (mSingleInstance == null) {
			mSingleInstance = new UserConfig();
		}
		return mSingleInstance;
	}
}
