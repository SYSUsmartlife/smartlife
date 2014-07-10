/**
 * @author Zheng Xinwei
 * @version 2014-7-5 
 */
package com.smartlife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartlife.activity.R;
import com.smartlife.util.UIHelperUtil;

/**
 * 用于呈现用户活动相关信息的Fragment
 */
public class TaskFragment extends Fragment implements OnClickListener {

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
				.replace(R.id.task_content, new TaskDayFragment())
				.addToBackStack(null).commit();

		createTaskIv.setOnClickListener(this);
		toggleShowTv.setOnClickListener(this);
		return rootView;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.task_top_iv_add_task:
			getChildFragmentManager().beginTransaction()
					.add(R.id.task_content, new TaskCreateFragment(), null)
					.addToBackStack(null).commit();
			break;
		case R.id.task_top_tv_change_view:

			break;
		default:
			break;
		}
	}

	@Override
	public void onResume() {

		super.onResume();

		getView().setFocusableInTouchMode(true);
		getView().requestFocus();
		getView().setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				if (event.getAction() == KeyEvent.ACTION_UP
						&& keyCode == KeyEvent.KEYCODE_BACK) {
					// getFragmentManager().popBackStackImmediate();
					getChildFragmentManager().popBackStack(null,
							FragmentManager.POP_BACK_STACK_INCLUSIVE);
					UIHelperUtil.makeToast(getActivity(), "BACK");
					return true;

				}

				return false;
			}
		});
	}

}
