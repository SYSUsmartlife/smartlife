/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:06:54 
 */
package com.smartlife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.smartlife.activity.R;
import com.smartlife.view.GroupHeaderTab;
import com.smartlife.view.GroupHeaderTab.OnChangeTabListener;

/**
 * 用于呈现小组相关信息的Fragment
 */
public class GroupFragment extends Fragment implements OnChangeTabListener {

	private GroupHeaderTab mGroupHeaderTab;
	private ListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_group, null);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		mGroupHeaderTab = (GroupHeaderTab)rootView.findViewById(R.id.tab_group_header);
		mListView = (ListView)rootView.findViewById(R.id.mainListView);
		
		mGroupHeaderTab.setOnChangeTabListener(this);
	}

	@Override
	public void onChange(int pos) {
		Toast.makeText(getActivity(), "点击了:" + pos, Toast.LENGTH_SHORT).show();
	}

}
