/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月12日 下午3:33:46 
 */
package com.smartlife.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.adapter.GroupMemberAdapter;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.params.GetGroupMemberParams;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

public class GroupDetailActivity extends Activity implements OnClickListener{

	private int groupId;
	private String groupName;
	private String groupDescription;
	private TextView groupNameText;
	private TextView groupDescriptionText;
	private TextView viewRequestText;
	private TextView inviteText;
	private ListView groupMemberList;
	private GroupMemberAdapter groupMemberAdapter;
	private List<Map<String, Object>> groupMemberData;
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			Log.i("SmartLife-GroupDetailActivity", obj.toString());
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_GET_GROUP_MEMBER_SUCCESS:
					groupMemberData.clear();
					JSONArray memberArray = obj.getJSONArray(NetworkConfig.KEY_RETURN_MEMBER_INFO);
					for (int i = 0; i < memberArray.length(); i++) {
						JSONObject member = memberArray.getJSONObject(i);
						int identity = member.getInt(NetworkConfig.KEY_RETURN_MEMBER_IDENTITY);
						String memberName = member.getString(NetworkConfig.KEY_RETURN_MEMBER_NAME);
						HashMap<String, Object> hashMap = new HashMap<String, Object>();
						hashMap.put(NetworkConfig.KEY_RETURN_MEMBER_IDENTITY, identity);
						hashMap.put(NetworkConfig.KEY_RETURN_MEMBER_NAME, memberName);
						groupMemberData.add(hashMap);
					}
					groupMemberAdapter.notifyDataSetChanged();
					break;
				case NetworkConfig.CODE_GET_GROUP_MEMBER_FAIL:
					UIHelperUtil.makeToast(GroupDetailActivity.this, "获取群组成员失败！");
					break;
				default:
					UIHelperUtil.makeToast(GroupDetailActivity.this, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(GroupDetailActivity.this, obj.toString());
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(GroupDetailActivity.this, errorMsg);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(GroupDetailActivity.this, errorMsg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_group_detail);
		initView();
		requestToGetGroupMemberData();
	}

	private void initView() {
		groupId = getIntent().getIntExtra(NetworkConfig.KEY_RETURN_GROUP_ID, -1);
		groupName = getIntent().getStringExtra(NetworkConfig.KEY_RETURN_GROUP_NAME);
		groupDescription = getIntent().getStringExtra(NetworkConfig.KEY_RETURN_GROUP_DESCRIPTION);
		groupNameText = (TextView)findViewById(R.id.text_group_name);
		groupDescriptionText = (TextView)findViewById(R.id.text_group_description);
		viewRequestText = (TextView)findViewById(R.id.text_view_request);
		inviteText = (TextView)findViewById(R.id.text_invite);
		groupMemberList = (ListView)findViewById(R.id.list_group_member);
		viewRequestText.setOnClickListener(this);
		inviteText.setOnClickListener(this);
		groupMemberData = new ArrayList<Map<String, Object>>();
		groupMemberAdapter = new GroupMemberAdapter(this, groupMemberData);
		groupNameText.setText(groupName);
		groupDescriptionText.setText("群公告：" + groupDescription);
		groupMemberList.setAdapter(groupMemberAdapter);
	}

	private void requestToGetGroupMemberData() {
		GetGroupMemberParams params = new GetGroupMemberParams(groupId);
		NetworkClient.getInstance().request(NetworkConfig.URL_GET_GROUP_MEMBER, params, mNetworkHandler );
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.text_view_request:
			toViewRequest();
			break;
		case R.id.text_invite:
			toInvite();
			break;

		default:
			break;
		}
	}

	private void toViewRequest() {
		Intent intent = new Intent(this, ViewJoinRequestActivity.class);
		intent.putExtra(NetworkConfig.KEY_RETURN_GROUP_ID, groupId);
		startActivity(intent);
	}

	private void toInvite() {
		// TODO Auto-generated method stub
		
	}
}
