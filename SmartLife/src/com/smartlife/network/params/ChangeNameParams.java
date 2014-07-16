package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class ChangeNameParams extends BasicNetworkParams {
	private int userId;
	private String userName;
	
	public ChangeNameParams(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CHANGE_NAME_USER_ID, Integer.toString(userId)));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CHANGE_NAME_NEW_NAME, userName));
		return params;
	}
}
