/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月12日 上午10:35:17 
 */
package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class JoinGroupParams extends BasicNetworkParams{

	private int userId;
	private int groupId;
	
	public JoinGroupParams(int userId, int groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}

	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_JOIN_GROUP_USER_ID, Integer.toString(userId)));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_JOIN_GROUP_ID, Integer.toString(groupId)));
		return params;
	}

}
