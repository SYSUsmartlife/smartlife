/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月11日 下午11:53:44 
 */
package com.smartlife.adapter;

import java.util.List;
import java.util.Map;

import com.smartlife.activity.R;
import com.smartlife.network.NetworkConfig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchGroupListAdapter extends BaseAdapter{

	private Context mContext;
	private List<Map<String, Object>> mData;

	public SearchGroupListAdapter(Context context, List<Map<String, Object>> data) {
		mContext = context;
		mData = data;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_search_group, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		String groupName = (String) mData.get(position).get(NetworkConfig.KEY_RETURN_GROUP_NAME);
		viewHolder.mGroupName.setText(groupName);
		viewHolder.joinButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		return convertView;
	}
	
	static class ViewHolder {
		ImageView mGroupIcon;
		TextView mGroupName;
		Button joinButton;
		
		public ViewHolder(View v) {
			mGroupIcon = (ImageView)v.findViewById(R.id.ic_group);
			mGroupName = (TextView)v.findViewById(R.id.text_group_name);
			joinButton = (Button)v.findViewById(R.id.btn_join);
		}
	}

}
