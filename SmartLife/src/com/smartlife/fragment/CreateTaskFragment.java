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

import com.smartlife.activity.R;

public class CreateTaskFragment extends Fragment {

	EditText mTaskTitle;
	EditText mTaskContent;
	TextView mStartDateTv;
	TextView mEndDateTv;
	TextView mStartTimeTv;
	TextView mEndTimeTv;
	Switch mIsRemindSwitch;
	TextView mFrequenceTv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task_content, null);

		return rootView;
	}

}
