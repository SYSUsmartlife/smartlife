package com.smartlife.network;

/**
 * 存储网络配置的常量，比如请求地址，请求码等
 */
public class NetworkConfig {

	public final static int CODE_RESPONSE_JSON = 0;
	public final static int CODE_RESPONSE_ERROR = 1;
	public final static int CODE_NETWORK_ERROR = 2;

	public final static String MSG_RESPONSE_ERROR = "返回格式错误！";
	public final static String MSG_NETWORK_ERROR = "网络错误！";
	public final static String MSG_ENCODING_ERROR = "编码错误！";
	
	public final static String SERVER = "http://114.215.169.24/";
	public final static String KEY_RETURN_CODE = "returnCode";
	
	// 用户注册使用
	public final static String URL_REGISTER = SERVER + "SmartLife/index.php/Api/register";
	public final static String KEY_REGISTER_USEREMAIL = "email";
	public final static String KEY_REGISTER_USERNAME = "userName";
	public final static String KEY_REGISTER_USERPASSWORD = "password";
	public final static int CODE_RESGISTER_SUCCESS = 0;
	public final static int CODE_RESGISTER_EMAIL_EXIST = 1;
	public final static int CODE_RESGISTER_NAME_INVALID = 2;
	public final static int CODE_RESGISTER_PASSWORD_INVALID = 3;
	public final static int CODE_RESGISTER_EMAIL_INVALID = 4;
	
}