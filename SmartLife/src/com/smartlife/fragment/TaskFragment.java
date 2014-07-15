/**
 * @author Zheng Xinwei
 * @version 2014-7-5 
 */
package com.smartlife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartlife.activity.R;
import com.smartlife.activity.TaskActivity;

/**
 * 用于呈现用户活动相关信息的Fragment
 */
public class TaskFragment extends Fragment implements OnClickListener {

	protected static final String TAG = "TAG";
	private ImageView createTaskIv;
	private TextView toggleShowTv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task, null);

		createTaskIv = (ImageView) rootView
				.findViewById(R.id.task_top_iv_add_task);
		toggleShowTv = (TextView) rootView
				.findViewById(R.id.task_top_tv_change_view);
		getChildFragmentManager().beginTransaction()
				.replace(R.id.task_content, new TaskDayFragment()).commit();

		createTaskIv.setOnClickListener(this);
		toggleShowTv.setOnClickListener(this);
		return rootView;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.task_top_iv_add_task:
			startActivity(new Intent(getActivity(), TaskActivity.class));
			break;
		case R.id.task_top_tv_change_view:

			break;
		default:
			break;
		}
	}

}
