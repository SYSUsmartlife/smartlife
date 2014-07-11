package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

/**
 * 注册用的参数类
 */
public class RegisterParams extends BasicNetworkParams {
	
	private String userEmail;
	private String userPassword;
	private String userName;

	public RegisterParams(String userEmail, String userPassword, String userName) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REGISTER_USEREMAIL, userEmail));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REGISTER_USERPASSWORD, userPassword));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REGISTER_USERNAME, userName));
		return params;
	}

}
