package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class ReplyRequestParams extends BasicNetworkParams {

	private int groupId;
	private int userId;
	private boolean reply;

	public ReplyRequestParams(int groupId, int userId, boolean reply) {
		super();
		this.groupId = groupId;
		this.userId = userId;
		this.reply = reply;
	}

	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REPLY_REQUEST_GROUP_ID, Integer.toString(groupId)));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REPLY_REQUEST_USER_ID, Integer.toString(userId)));
		params.add(new BasicNameValuePair(NetworkConfig.KEY_REPLY_REQUEST_REPLY, Boolean.toString(reply)));
		return params;
	}

}
