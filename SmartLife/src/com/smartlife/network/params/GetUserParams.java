/**
 * 
 * @author huakaitingqian
 */
package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

/**
 * 通过userId获取用户信息
 * 
 */
public class GetUserParams extends BasicNetworkParams {
	private int userId;
	
	public GetUserParams(int userId) {
		super();
		this.userId = userId;
	}
	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CHANGE_NAME_USER_ID, Integer.toString(userId)));
		return params;
	}
}
