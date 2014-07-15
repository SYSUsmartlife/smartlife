/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月14日 下午11:00:52 
 */
package com.smartlife.adapter;

import java.util.List;
import java.util.Map;

import com.smartlife.activity.R;
import com.smartlife.network.NetworkConfig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class RequestListAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<Map<String, Object>> mData; 

	public RequestListAdapter(Context mContext, List<Map<String, Object>> mData) {
		super();
		this.mContext = mContext;
		this.mData = mData;
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_request, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		String userName = (String) mData.get(position).get(NetworkConfig.KEY_RETURN_USER_NAME);
		viewHolder.userNameText.setText(userName);
		return convertView;
	}
	
	static class ViewHolder {
		TextView userNameText;
		Button agreeButton;
		Button refuseButton;
		
		public ViewHolder(View v) {
			userNameText = (TextView) v.findViewById(R.id.text_user_name);
			agreeButton = (Button) v.findViewById(R.id.btn_agree);
			refuseButton = (Button) v.findViewById(R.id.btn_refuse);
		}
	}

}
