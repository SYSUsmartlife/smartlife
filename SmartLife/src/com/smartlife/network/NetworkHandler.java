package com.smartlife.network;

import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;

/**
 * 异步网络请求完成时的处理类，分以下3种情况：
 * 1. 网络请求正常，结果为正确的返回值（目前只接受json格式）
 * 2. 网络请求正常，结果为错误的返回值（比如格式错误）
 * 3. 网络请求错误
 */
public abstract class NetworkHandler extends Handler{

	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		switch (msg.what) {
		case NetworkConfig.CODE_RESPONSE_JSON:
			handleResponseJson((JSONObject) msg.obj);
			break;
		case NetworkConfig.CODE_RESPONSE_ERROR:
			handleResponseError((String) msg.obj);
			break;
		case NetworkConfig.CODE_NETWORK_ERROR:
			handleNetworkError((String) msg.obj);
			break;
		default:
			break;
		}
	}

	/**
	 * 网络请求正常，结果为正确的返回值（目前只接受json格式）
	 * @param obj
	 */
	public abstract void handleResponseJson(JSONObject obj);
	/**
	 * 网络请求正常，结果为错误的返回值（比如格式错误）
	 */
	public abstract void handleResponseError(String errorMsg);
	/**
	 * 网络请求错误
	 */
	public abstract void handleNetworkError(String errorMsg);
	
}
