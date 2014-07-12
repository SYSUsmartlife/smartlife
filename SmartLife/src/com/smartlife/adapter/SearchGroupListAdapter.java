/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月11日 下午11:53:44 
 */
package com.smartlife.adapter;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.activity.R;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.JoinGroupParams;
import com.smartlife.util.UIHelperUtil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchGroupListAdapter extends BaseAdapter implements OnClickListener{

	private Context mContext;
	private List<Map<String, Object>> mData;
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			Log.i("SmartLife-SearchGroupListAdapter", obj.toString());
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_JOIN_GROUP_SUCCESS:
					UIHelperUtil.makeToast(mContext, "已申请加入该群组！");
					break;
				case NetworkConfig.CODE_JOIN_GROUP_FAIL:
					UIHelperUtil.makeToast(mContext, "申请加入该群组失败！");
					break;
				case NetworkConfig.CODE_JOIN_GROUP_EXIST:
					UIHelperUtil.makeToast(mContext, "您已在该群组中！");
					break;
				default:
					UIHelperUtil.makeToast(mContext, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(mContext, obj.toString());
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(mContext, errorMsg);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(mContext, errorMsg);
		}
	};

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
		int groupId = (int)mData.get(position).get(NetworkConfig.KEY_RETURN_GROUP_ID);
		viewHolder.mGroupName.setText(groupName);
		viewHolder.joinButton.setTag(groupId);
		viewHolder.joinButton.setOnClickListener(this);
		return convertView;
	}

	@Override
	public void onClick(View v) {
		int userId = UserConfig.getInstance(mContext).getUserId();
		int groupId = (int) v.getTag();
		JoinGroupParams params = new JoinGroupParams(userId, groupId);
		NetworkClient.getInstance().request(NetworkConfig.URL_JOIN_GROUP, params, mNetworkHandler);
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