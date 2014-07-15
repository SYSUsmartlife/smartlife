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
	public final static String KEY_RETURN_USER_ID = "userID";
	public final static String KEY_RETURN_GROUP_INFO = "groupInfo";
	public final static String KEY_RETURN_GROUP_ID = "groupId";
	public final static String KEY_RETURN_GROUP_NAME = "groupName";
	public final static String KEY_RETURN_GROUP_DESCRIPTION = "groupAnnouncement";
	public final static String KEY_RETURN_MEMBER_INFO = "mateInfo";
	public final static String KEY_RETURN_MEMBER_IDENTITY = "identity";
	public final static String KEY_RETURN_MEMBER_NAME = "userName";

	// 用户注册使用
	public final static String URL_REGISTER = SERVER
			+ "SmartLife/index.php/Api/register";
	public final static String KEY_REGISTER_USEREMAIL = "email";
	public final static String KEY_REGISTER_USERNAME = "userName";
	public final static String KEY_REGISTER_USERPASSWORD = "password";
	public final static int CODE_RESGISTER_SUCCESS = 0;
	public final static int CODE_RESGISTER_EMAIL_EXIST = 1;
	public final static int CODE_RESGISTER_NAME_INVALID = 2;
	public final static int CODE_RESGISTER_PASSWORD_INVALID = 3;
	public final static int CODE_RESGISTER_EMAIL_INVALID = 4;

	// 用户登陆使用
	public final static String URL_LOGIN = SERVER + "";
	public final static String KEY_LOGIN_USEREMAIL = "email";
	public final static String KEY_LOGIN_USERPASSWORD = "password";
	public final static int CODE_LOGIN_SUCCESS = 0;
	public final static int CODE_LOGIN_EMAIL_UNEXIST = 1;
	public final static int CODE_LOGIN_PASSWORD_ERROR = 2;

	// 创建群组时使用
	public final static String URL_CREATE_GROUP = SERVER
			+ "SmartLife/index.php/Api/createGroup";
	public final static String KEY_CREATE_GROUP_NAME = "groupName";
	public final static String KEY_CREATE_GROUP_USER_ID = "userId";
	public final static String KEY_CREATE_GROUP_DESCRIPTION = "announcement";
	public final static int CODE_CREATE_GROUP_SUCCESS = 0;
	public final static int CODE_CREATE_GROUP_FAIL = 1;

	// 获取群组列表时使用
	public final static String URL_GET_GROUP_LIST = SERVER
			+ "SmartLife/index.php/Api/getGroupInfoByUserId";
	public final static String KEY_GET_GROUP_LIST_USER_ID = "userId";
	public final static int CODE_GET_GROUP_LIST_SUCCESS = 0;
	public final static int CODE_GET_GROUP_LIST_FAIL = 1;

	// 搜索群组时使用
	public final static String URL_SEARCH_GROUP = SERVER
			+ "SmartLife/index.php/Api/searchGroupByName";
	public final static String KEY_SEARCH_GROUP_NAME = "groupName";
	public final static int CODE_SEARCH_GROUP_SUCCESS = 0;
	public final static int CODE_SEARCH_GROUP_FAIL = 1;

	// 申请加入群组时使用
	public final static String URL_JOIN_GROUP = SERVER
			+ "SmartLife/index.php/Api/joinGroupRequest";
	public final static String KEY_JOIN_GROUP_USER_ID = "userId";
	public final static String KEY_JOIN_GROUP_ID = "groupId";
	public final static int CODE_JOIN_GROUP_SUCCESS = 0;
	public final static int CODE_JOIN_GROUP_FAIL = 1;
	public final static int CODE_JOIN_GROUP_EXIST = 2;

	// 获取群组成员时使用
	public final static String URL_GET_GROUP_MEMBER = SERVER
			+ "SmartLife/index.php/Api/getGroupMates";
	public final static String KEY_GET_GROUP_MEMBER_ID = "groupId";
	public final static int CODE_GET_GROUP_MEMBER_SUCCESS = 0;
	public final static int CODE_GET_GROUP_MEMBER_FAIL = 1;
	public final static int CODE_IDENTITY_LEADER = 1;
	public final static int CODE_IDENTITY_MEMBER = 2;

	// 获取申请列表时使用
	public final static String URL_GET_JOIN_REQUEST = SERVER
			+ "SmartLife/index.php/Api/getJoinRequest";
	public final static String KEY_GET_JOIN_REQUEST_GROUP_ID = "groupId";
	public final static int CODE_GET_JOIN_REQUEST_SUCCESS = 0;
	public final static int CODE_GET_JOIN_REQUEST_FAIL = 1;

}
