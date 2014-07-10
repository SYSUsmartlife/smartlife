/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月10日 上午12:07:14 
 */
package com.smartlife.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * 创建小组请求用的参数类
 */
public class CreateGroupParams extends BasicNetworkParams{
	
	private int userId;
	private String groupName;
	private String groupDescription;

	public CreateGroupParams(int userId, String groupName,
			String groupDescription) {
		this.userId = userId;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
	}

	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CREATE_GROUP_USER_ID, Integer.toString(userId)));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CREATE_GROUP_NAME, groupName));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CREATE_GROUP_DESCRIPTION, groupDescription));
		return params;
	}

}
