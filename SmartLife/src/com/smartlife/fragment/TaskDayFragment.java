/**
 * 创建时间：2014-7-9 上午12:34:41
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.smartlife.activity.R;
import com.smartlife.activity.TaskActivity;
import com.smartlife.adapter.TaskDayAdapter;
import com.smartlife.model.Task;
import com.smartlife.model.Task.Frequence;

public class TaskDayFragment extends Fragment implements OnItemClickListener {

	public static final String TAG = TaskDayFragment.class.getSimpleName();

	private List<Task> list = new ArrayList<Task>();
	TaskDayAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_task_day, null);

		initData();
		TaskDayAdapter taskDayAdapter = new TaskDayAdapter(getActivity(), list);
		ListView lv = (ListView) rootView.findViewById(R.id.lv_person_day_task);
		View haderView = LayoutInflater.from(getActivity()).inflate(
				R.layout.list_item_task_day_header, null);
		lv.addHeaderView(haderView, null, false);
		lv.setAdapter(taskDayAdapter);
		lv.setOnItemClickListener(this);
		return rootView;
	}

	// TODO 初始化数据
	private void initData() {
		Task task = new Task.Builder("活动名称", "11:00").endTime("22:00")
				.frequence(Frequence.EACH_DAY).isGroupTask(true)
				.content("TEST").build();
		for (int i = 0; i < 20; i++) {
			if (i % 2 != 0)
				list.add(task);
			else
				list.add(Task.newInstance());
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Task task = (Task) parent.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), TaskActivity.class);
		intent.putExtra(Task.TAG, task);
		startActivity(intent);
	}
}
