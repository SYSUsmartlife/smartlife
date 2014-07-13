/**
 * 创建时间：2014-7-12 下午11:34:07
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.smartlife.activity.R;
import com.smartlife.model.Task;

public class DetailTaskFragment extends Fragment {
	protected static final String TAG = DetailTaskFragment.class
			.getSimpleName();
	@InjectView(R.id.create_task_tv_task_title)
	TextView mTaskTitle;
	@InjectView(R.id.create_task_tv_task_content)
	TextView mTaskContent;
	@InjectView(R.id.create_task_tv_start_date)
	TextView mStartDateTv;
	@InjectView(R.id.create_task_tv_end_date)
	TextView mEndDateTv;
	@InjectView(R.id.create_task_tv_start_time)
	TextView mStartTimeTv;
	@InjectView(R.id.create_task_tv_end_time)
	TextView mEndTimeTv;
	@InjectView(R.id.create_task_sw_is_remind)
	Switch mIsRemindSwitch;
	@InjectView(R.id.create_task_tv_frequence)
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
		// 设置监听返回事件
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();
		rootView.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					getFragmentManager().popBackStack();
					return true;
				} else {
					return false;
				}
			}
		});
		// 注入
		ButterKnife.inject(this, rootView);
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

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}
}
