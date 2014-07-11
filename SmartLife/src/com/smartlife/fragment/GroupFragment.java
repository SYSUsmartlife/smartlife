/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:06:54 
 */
package com.smartlife.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.smartlife.activity.R;
import com.smartlife.adapter.GroupListAdapter;
import com.smartlife.adapter.GroupManageAdapter;
import com.smartlife.adapter.GroupMsgAdapter;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.GetGroupListParams;
import com.smartlife.util.UIHelperUtil;
import com.smartlife.view.GroupHeaderTab;
import com.smartlife.view.GroupHeaderTab.OnChangeTabListener;

/**
 * 用于呈现小组相关信息的Fragment
 */
public class GroupFragment extends Fragment implements OnChangeTabListener {

	/**
	 * 群组顶部Tab控件
	 */
	private GroupHeaderTab mGroupHeaderTab;
	/**
	 * Tab控件下方列表
	 */
	private ListView mListView;
	/**
	 * 我的群组Tab所对应的adapter
	 */
	private GroupListAdapter mGroupListAdapter;
	/**
	 * 群组消息所对应的adapter
	 */
	private GroupMsgAdapter mGroupMsgAdapter;
	/**
	 * 群组管理所对应的adapter
	 */
	private GroupManageAdapter mGroupManageAdapter;
	/**
	 * 我的群组所对应的数据
	 */
	private List<Map<String, Object>> mGroupListData;
	/**
	 * 群组消息所对应的数据
	 */
	private List<Map<String, Object>> mGroupMsgData;
	/**
	 * 请求群组列表后的处理器
	 */
	private NetworkHandler mGetGroupListHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			Log.i("getGroupList", obj.toString());
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_GET_GROUP_LIST_SUCCESS:
					JSONArray groupArray = obj.getJSONArray(NetworkConfig.KEY_RETURN_GROUP_INFO);
					for (int i = 0; i < groupArray.length(); i++) {
						JSONObject group = groupArray.getJSONObject(i);
						int groupId = group.getInt(NetworkConfig.KEY_RETURN_GROUP_ID);
						String groupName = group.getString(NetworkConfig.KEY_RETURN_GROUP_NAME);
						String groupDescription = group.getString(NetworkConfig.KEY_RETURN_GROUP_DESCRIPTION);
						HashMap<String, Object> hashMap = new HashMap<String, Object>();
						hashMap.put(NetworkConfig.KEY_RETURN_GROUP_ID, groupId);
						hashMap.put(NetworkConfig.KEY_RETURN_GROUP_NAME, groupName);
						hashMap.put(NetworkConfig.KEY_RETURN_GROUP_DESCRIPTION, groupDescription);
						mGroupListData.add(hashMap);
					}
					mGroupListAdapter.notifyDataSetChanged();
					break;
				case NetworkConfig.CODE_GET_GROUP_LIST_FAIL:
					UIHelperUtil.makeToast(getActivity(), "请求群组列表失败！");
					break;
				default:
					UIHelperUtil.makeToast(getActivity(), "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(getActivity(), obj.toString());
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(getActivity(), errorMsg);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(getActivity(), errorMsg);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_group, null);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		initData();
		mGroupHeaderTab = (GroupHeaderTab)rootView.findViewById(R.id.tab_group_header);
		mGroupHeaderTab.setOnChangeTabListener(this);
		mListView = (ListView)rootView.findViewById(R.id.list_main);
		mListView.setAdapter(mGroupListAdapter);
		requestToGetGroupListData();
	}

	private void initData() {
		mGroupListData = new ArrayList<Map<String,Object>>();
		mGroupMsgData = new ArrayList<Map<String,Object>>();
		mGroupListAdapter = new GroupListAdapter(getActivity(), mGroupListData);
		mGroupMsgAdapter = new GroupMsgAdapter(getActivity(), mGroupMsgData);
		mGroupManageAdapter = new GroupManageAdapter(getActivity());
	}

	@Override
	public void onChange(int pos) {
		switch (pos) {
		case GroupHeaderTab.TAB_MYGROUP:
			mListView.setAdapter(mGroupListAdapter);
			requestToGetGroupListData();
			break;
		case GroupHeaderTab.TAB_GROUPMSG:
			mListView.setAdapter(mGroupMsgAdapter);
			break;
		case GroupHeaderTab.TAB_GROUPMANAGE:
			mListView.setAdapter(mGroupManageAdapter);
			break;
		default:
			break;
		}
	}

	private void requestToGetGroupListData() {
		mGroupListData.clear();
		GetGroupListParams params = new GetGroupListParams(UserConfig.getInstance(getActivity()).getUserId());
		NetworkClient.getInstance().request(NetworkConfig.URL_GET_GROUP_LIST, params, mGetGroupListHandler );
	}

}
