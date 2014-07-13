/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月12日 下午11:12:20 
 */
package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class GetJoinRequestParams extends BasicNetworkParams {
	
	private int groupId;

	public GetJoinRequestParams(int groupId) {
		super();
		this.groupId = groupId;
	}

	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_GET_JOIN_REQUEST_GROUP_ID, Integer.toString(groupId)));
		return params;
	}

}