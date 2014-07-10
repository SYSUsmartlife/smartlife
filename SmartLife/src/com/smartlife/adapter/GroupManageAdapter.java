package com.smartlife.adapter;

import com.smartlife.activity.CreateGroupActivity;
import com.smartlife.activity.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GroupManageAdapter extends BaseAdapter implements OnClickListener {

	private Context mContext;
	private TextView createGroupBar;
	private TextView searchGroupBar;

	public GroupManageAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rootView = LayoutInflater.from(mContext).inflate(R.layout.list_item_group_manage, null);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		// 阻断ListView的单项点击事件
		rootView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return true;
			}
		});
		
		createGroupBar = (TextView)rootView.findViewById(R.id.text_create_group);
		searchGroupBar = (TextView)rootView.findViewById(R.id.text_search_group);
		
		createGroupBar.setOnClickListener(this);
		searchGroupBar.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.text_create_group:
			ToCreateGroup();
			break;
		case R.id.text_search_group:
			ToSearchGroup();
			break;
		default:
			break;
		}
	}

	/**
	 * 跳转到创建群组页面
	 */
	private void ToCreateGroup() {
		Intent intent = new Intent(mContext, CreateGroupActivity.class);
		mContext.startActivity(intent);
	}

	/**
	 * 跳转到搜索群组页面
	 */
	private void ToSearchGroup() {
		// TODO Auto-generated method stub
		
	}

}
