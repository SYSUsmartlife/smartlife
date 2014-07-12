/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月11日 下午9:58:14 
 */
package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

public class SearchGroupParams extends BasicNetworkParams{

	private String groupName;

	public SearchGroupParams(String groupName) {
		super();
		this.groupName = groupName;
	}
	
	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_SEARCH_GROUP_NAME, groupName));
		return params;
	}

}
