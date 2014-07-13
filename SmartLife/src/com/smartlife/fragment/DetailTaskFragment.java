/**
 * 创建时间：2014-7-12 下午11:34:07
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.smartlife.activity.R;
import com.smartlife.model.Task;

public class DetailTaskFragment extends Fragment {
	protected static final String TAG = DetailTaskFragment.class
			.getSimpleName();
	TextView mTaskTitle;
	TextView mTaskContent;
	TextView mStartDateTv;
	TextView mEndDateTv;
	TextView mStartTimeTv;
	TextView mEndTimeTv;
	Switch mIsRemindSwitch;
	TextView mFrequenceTv;

	public static DetailTaskFragment newInstance(Task task) {
		DetailTaskFragment fragment = new DetailTaskFragment();
		Bundle args = new Bundle();
		args.putSerializable(Task.TAG, task);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_task_content, null);
		mTaskTitle = (TextView) rootView
				.findViewById(R.id.create_task_tv_task_title);
		mTaskContent = (TextView) rootView
				.findViewById(R.id.create_task_tv_task_content);
		mStartDateTv = (TextView) rootView
				.findViewById(R.id.create_task_tv_start_date);
		mEndDateTv = (TextView) rootView
				.findViewById(R.id.create_task_tv_end_date);
		mStartTimeTv = (TextView) rootView
				.findViewById(R.id.create_task_tv_start_time);
		mEndTimeTv = (TextView) rootView
				.findViewById(R.id.create_task_tv_end_time);
		mIsRemindSwitch = (Switch) rootView
				.findViewById(R.id.create_task_sw_is_remind);
		mFrequenceTv = (TextView) rootView
				.findViewById(R.id.create_task_frequence);
		Task task = (Task) getArguments().get(Task.TAG);

		mTaskTitle.setText(task.getTaskTitle());
		mTaskContent.setText(task.getTaskContent());
		mStartDateTv.setText(task.getTaskStartDate());
		mEndDateTv.setText(task.getTaskEndDate());
		mStartTimeTv.setText(task.getTaskEndTime());
		mEndTimeTv.setText(task.getTaskEndTime());
		mIsRemindSwitch.setChecked(task.isRemind());
		mFrequenceTv.setText(task.getFrequence().name());

		return rootView;
	}

}
