package com.smartlife.adapter;

import com.smartlife.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GroupManageAdapter extends BaseAdapter {

	private Context mContext;

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
	}

}
