/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月9日 下午10:30:37 
 */
package com.smartlife.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * 登陆用的参数类
 */
public class LoginParams extends BasicNetworkParams{

	private String userEmail;
	private String userPassword;
	
	
	public LoginParams(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_LOGIN_USEREMAIL, userEmail));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_LOGIN_USERPASSWORD, userPassword));
		return params;
	}

}
