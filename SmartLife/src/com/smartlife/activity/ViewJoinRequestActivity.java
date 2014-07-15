/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月12日 下午9:01:12 
 */
package com.smartlife.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.adapter.RequestListAdapter;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.params.GetJoinRequestParams;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

public class ViewJoinRequestActivity extends Activity{
	
	int groupId;
	private ListView mRequestList;
	private RequestListAdapter mAdapter;
	private List<Map<String, Object>> mRequestData;
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			Log.i("SmartLife-ViewJoinRequestActivity", obj.toString());
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(ViewJoinRequestActivity.this, errorMsg);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(ViewJoinRequestActivity.this, errorMsg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_view_join_request);
		initView();
		requestToGetRequestList();
	}

	private void initView() {
		groupId = getIntent().getIntExtra(NetworkConfig.KEY_RETURN_GROUP_ID, -1);
		mRequestList = (ListView)findViewById(R.id.list_request);
		mRequestData = new ArrayList<Map<String, Object>>();
		mAdapter = new RequestListAdapter(this, mRequestData);
		mRequestList.setAdapter(mAdapter);
	}

	private void requestToGetRequestList() {
		GetJoinRequestParams params = new GetJoinRequestParams(groupId);
		NetworkClient.getInstance().request(NetworkConfig.URL_GET_JOIN_REQUEST, params, mNetworkHandler );
	}
}
