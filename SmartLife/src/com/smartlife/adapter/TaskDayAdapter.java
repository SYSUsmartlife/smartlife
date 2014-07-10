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

import com.smartlife.activity.R;
import com.smartlife.model.Task;

public class TaskDayAdapter extends TaskBaseAdapter<Task> {

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
		if (convertView == null) {
			convertView = inflater.inflate(resId, parent, false);
		}

		return convertView;
	}

}
