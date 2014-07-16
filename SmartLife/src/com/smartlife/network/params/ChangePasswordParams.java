package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class ChangePasswordParams extends BasicNetworkParams{
	private int userId;
	private String prePassword;
	private String newPassword;
	
	public ChangePasswordParams(int userId, String prePassword, String newPassword) {
		super();
		this.userId = userId;
		this.prePassword = prePassword;
		this.newPassword = newPassword;
	}
	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.CHAGNE_PASSWORD_USER_ID, Integer.toString(userId)));
		params.add(new BasicNameValuePair(NetworkConfig.CHANGE_PASSWORD_PREPASSWORD, prePassword));
		params.add(new BasicNameValuePair(NetworkConfig.CHANGE_PASSWORD_NEWPASSWORD, newPassword));
		return params;
	}
}
