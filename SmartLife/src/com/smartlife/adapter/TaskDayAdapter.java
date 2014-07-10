/**
 * 创建时间：2014-7-9 下午8:11:40
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartlife.activity.R;
import com.smartlife.model.Task;

public class TaskDayAdapter extends TaskBaseAdapter<Task> {

	private String[] isRemind = { "是", "否" };
	private String[] frequence = { "不重复", "每天", "每周" };
	private String[] isGroup = { "个人", "小组" };

	private int getIndex(boolean values) {
		if (values)
			return 0;
		else
			return 1;
	}

	/**
	 * @param context
	 * @param mDataList
	 */
	public TaskDayAdapter(Context context, List<Task> mDataList) {
		super(context, mDataList);
		this.resId = R.layout.list_item_task_day;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(resId, parent, false);
			holder = new ViewHolder();
			holder.mTitleTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_task_title);
			holder.mContentTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_task_content);
			holder.mStartTimeTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_task_start_time);
			holder.mEndTimeTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_task_end_time);
			holder.mIsRemindTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_is_reminded);
			holder.mIsGroupTv = (TextView) convertView
					.findViewById(R.id.list_item_tv_is_group);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		Task task = getItem(position);

		holder.mTitleTv.setText(task.getTaskTitle());
		holder.mContentTv.setText(task.getTaskContent());
		holder.mStartTimeTv.setText(task.getTaskStartTime());
		holder.mEndTimeTv.setText(task.getTaskEndTime());

		holder.mIsRemindTv.setText(isRemind[getIndex(task.isRemind())]);
		holder.mIsGroupTv.setText(isGroup[getIndex(task.isGroupTask())]);
		holder.mFrequenceTv.setText(frequence[task.getFrequence().ordinal()]);
		return convertView;
	}

	static class ViewHolder {
		TextView mTitleTv;
		TextView mContentTv;
		TextView mStartTimeTv;
		TextView mEndTimeTv;
		TextView mIsRemindTv;
		TextView mFrequenceTv;
		TextView mIsGroupTv;
	}

}
