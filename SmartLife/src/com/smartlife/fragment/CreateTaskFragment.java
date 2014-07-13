/**
 * 创建时间：2014-7-10 下午10:35:06
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
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.smartlife.activity.R;

public class CreateTaskFragment extends Fragment {

	@InjectView(R.id.create_task_tv_task_title)
	EditText mTaskTitle;
	@InjectView(R.id.create_task_tv_task_content)
	EditText mTaskContent;
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task_content, null);
		ButterKnife.inject(this, rootView);

		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

}
