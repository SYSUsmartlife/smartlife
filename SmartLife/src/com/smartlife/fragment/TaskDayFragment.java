/**
 * 创建时间：2014-7-9 上午12:34:41
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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.smartlife.activity.R;

public class TaskDayFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task_day, null);

		ArrayAdapter<String> adaper = new ArrayAdapter<>(getActivity(),
				R.layout.list_item_task_day, R.id.tv_list_item_content,
				new String[] { "TEST", "TEST", "TEST",
						"LONGLONGLONG LONGLONGLONG LONGLONGLONG",
						"LONGLONGLONG LONGLONGLONG LONGLONGLONG",
						"LONGLONGLONG LONGLONGLONG",
						"LONGLONGLONG LONGLONGLONG",
						"LONGLONGLONG LONGLONGLONG" });

		ListView lv = (ListView) rootView.findViewById(R.id.lv_person_day_task);
		lv.setAdapter(adaper);
		return rootView;
	}
}
