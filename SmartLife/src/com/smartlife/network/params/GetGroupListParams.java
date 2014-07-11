/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月10日 下午10:38:46 
 */
package com.smartlife.network.params;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartlife.network.NetworkConfig;

/**
 * 获取小组列表时使用的参数类
 */
public class GetGroupListParams extends BasicNetworkParams{
	
	private int userId;
	

	public GetGroupListParams(int userId) {
		this.userId = userId;
	}


	@Override
	public List<NameValuePair> toNetworkParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(NetworkConfig.KEY_CREATE_GROUP_USER_ID, Integer.toString(userId)));
		return params;
	}

}
