/**
 * @author Zheng Xinwei
 * @version 2014-7-5 
 */
package com.smartlife.fragment;

import com.smartlife.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 用于呈现用户活动的相关信息的Fragment
 */
public class TaskFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task, null);

		this.getChildFragmentManager().beginTransaction()
				.replace(R.id.task_content, new TaskDayFragment())
				.addToBackStack(null).commit();
		return rootView;

	}

}
