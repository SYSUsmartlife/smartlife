/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月10日 上午12:07:14 
 */
package com.smartlife.network;

import java.util.List;

import org.apache.http.NameValuePair;

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
		// TODO Auto-generated method stub
		return null;
	}

}
