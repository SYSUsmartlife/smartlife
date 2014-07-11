/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月9日 上午12:12:17 
 */
package com.smartlife.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.adapter.SearchGroupListAdapter;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.params.SearchGroupParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchGroupActivity extends Activity implements OnClickListener{
	
	private EditText groupNameEditText;
	private Button searchGroupButton;
	private ListView groupList;
	private SearchGroupListAdapter mSearchGroupListAdapter;
	private List<Map<String, Object>> mGroupListData;
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			Log.i("SmartLife-SearchGroupActivity", obj.toString());
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_SEARCH_GROUP_SUCCESS:
					JSONArray groupArray = obj.getJSONArray(NetworkConfig.KEY_RETURN_GROUP_INFO);
					for (int i = 0; i < groupArray.length(); i++) {
						JSONObject group = groupArray.getJSONObject(i);
						int groupId = group.getInt(NetworkConfig.KEY_RETURN_GROUP_ID);
						String groupName = group.getString(NetworkConfig.KEY_RETURN_GROUP_NAME);
						HashMap<String, Object> hashMap = new HashMap<String, Object>();
						hashMap.put(NetworkConfig.KEY_RETURN_GROUP_ID, groupId);
						hashMap.put(NetworkConfig.KEY_RETURN_GROUP_NAME, groupName);
						mGroupListData.add(hashMap);
					}
					mSearchGroupListAdapter.notifyDataSetChanged();
					break;
				case NetworkConfig.CODE_SEARCH_GROUP_FAIL:
					UIHelperUtil.makeToast(SearchGroupActivity.this, "搜索群组失败！");
					break;
				default:
					UIHelperUtil.makeToast(SearchGroupActivity.this, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(SearchGroupActivity.this, obj.toString());
				e.printStackTrace();
			}
			searchGroupButton.setEnabled(true);
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(SearchGroupActivity.this, errorMsg);
			searchGroupButton.setEnabled(true);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(SearchGroupActivity.this, errorMsg);
			searchGroupButton.setEnabled(true);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_group);
		initView();
	}

	private void initView() {
		groupNameEditText = (EditText)findViewById(R.id.input_group_name);
		searchGroupButton = (Button)findViewById(R.id.btn_search);
		groupList = (ListView) findViewById(R.id.list_group);
		searchGroupButton.setOnClickListener(this);
		mGroupListData = new ArrayList<Map<String,Object>>();
		mSearchGroupListAdapter = new SearchGroupListAdapter(this, mGroupListData);
		groupList.setAdapter(mSearchGroupListAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_search:
			searchGroup();
			break;

		default:
			break;
		}
	}

	private void searchGroup() {
		String groupName = groupNameEditText.getText().toString();
		if (StringUtil.isEmpty(groupName)) {
			UIHelperUtil.makeToast(this, "群组名称不允许为空！");
		} else {
			SearchGroupParams params = new SearchGroupParams(groupName);
			searchGroupButton.setEnabled(false);
			NetworkClient.getInstance().request(NetworkConfig.URL_SEARCH_GROUP, params, mNetworkHandler );
		}
	}
	
}
