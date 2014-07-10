package com.smartlife.network;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 网络请求参数模型的基类，子类必须实现toParams函数
 */
public abstract class BasicNetworkParams {

	/**
	 * 将模型本身转成网络传输所用的NameValuePair的List
	 * @return
	 */
	public abstract List<NameValuePair> toNetworkParams();
	
}
