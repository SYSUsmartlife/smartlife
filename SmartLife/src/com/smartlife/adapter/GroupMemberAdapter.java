/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月12日 下午5:43:23 
 */
package com.smartlife.adapter;

import java.util.List;
import java.util.Map;

import com.smartlife.activity.R;
import com.smartlife.network.NetworkConfig;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GroupMemberAdapter extends BaseAdapter{

	private Context mContext;
	private List<Map<String, Object>> mData;
	private Drawable drawableLeader;
	private Drawable drawableMember;

	public GroupMemberAdapter(Context context, List<Map<String, Object>> data) {
		mContext = context;
		mData = data;
		drawableLeader = mContext.getResources().getDrawable(R.drawable.ic_group_leader);
		drawableLeader.setBounds(0, 0, drawableLeader.getMinimumWidth(), drawableLeader.getMinimumHeight());
		drawableMember = mContext.getResources().getDrawable(R.drawable.ic_group_member);
		drawableMember.setBounds(0, 0, drawableMember.getMinimumWidth(), drawableMember.getMinimumHeight());
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Map<String, Object> getItem(int position) {
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_group_member, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Map<String, Object> map = getItem(position);
		int identity = (int) map.get(NetworkConfig.KEY_RETURN_MEMBER_IDENTITY);
		String memberName = (String) map.get(NetworkConfig.KEY_RETURN_MEMBER_NAME);
		viewHolder.memberNameText.setText(memberName);
		if (identity == NetworkConfig.CODE_IDENTITY_LEADER) {
			viewHolder.memberNameText.setCompoundDrawables(drawableLeader, null, null, null);
		} else if (identity == NetworkConfig.CODE_IDENTITY_MEMBER) {
			viewHolder.memberNameText.setCompoundDrawables(drawableMember, null, null, null);
		}
		return convertView;
	}
	
	static class ViewHolder {
		
		TextView memberNameText;
		
		public ViewHolder(View view) {
			memberNameText = (TextView)view.findViewById(R.id.text_member_name);
		}
	}

}
