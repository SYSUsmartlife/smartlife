/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:06:54 
 */
package com.smartlife.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
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
		//NetworkClient.getInstance().request(NetworkConfig.URL_GET_GROUP_LIST, params, handler);
	}

}
