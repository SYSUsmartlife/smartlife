/**
 * 创建时间：2014-7-14 下午8:39:44
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.fragment;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.smartlife.activity.R;
import com.smartlife.model.Task;
import com.smartlife.model.Task.Frequence;
import com.smartlife.util.UIHelperUtil;

public class CreateTaskFragment extends Fragment implements OnClickListener,
		OnDateSetListener, OnTimeSetListener, TextWatcher {

	EditText mTaskTitleEt;
	EditText mTaskContentEt;
	EditText mStartDateEt;
	EditText mEndDateEt;
	EditText mStartTimeEt;
	EditText mEndTimeEt;
	CheckBox mIsRemindCb;
	Spinner mFrequenceSp;
	ProgressBar mProgressBar;
	ImageView mBackIv;
	Button mConfirmBtn;
	TextView mTopTitleTv;

	private int currentClickItem = 0;

	private int currentYear;
	private int currentMonth;
	private int currentDay;
	private int currentHour;
	private int currentMinutes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initCurrentTimeAndDate();
	}

	/**
	 * 初始化日期的开始日期与时间
	 */
	private void initCurrentTimeAndDate() {
		Calendar calendar = Calendar.getInstance();
		currentYear = calendar.get(Calendar.YEAR);
		currentMonth = calendar.get(Calendar.MONTH);
		currentDay = calendar.get(Calendar.DAY_OF_MONTH);

		currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		currentMinutes = calendar.get(Calendar.MINUTE);
	}

	/**
	 * 格式化日期
	 */
	private String formalizeDate(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("-");
		if (month < 10)
			sb.append(0).append(month);
		else
			sb.append(currentMonth);
		sb.append("-");
		if (day < 10)
			sb.append(0).append(day);
		else
			sb.append(day);
		return sb.toString();
	}

	/**
	 * 格式化时间
	 * */
	private String formalizeTime(int hour, int minute) {
		StringBuilder sb = new StringBuilder();
		if (hour < 10)
			sb.append(0).append(hour);
		else
			sb.append(hour);
		sb.append(":");
		if (minute < 10)
			sb.append(0).append(minute);
		else
			sb.append(minute);
		return sb.toString();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_create_task, null);
		mTaskTitleEt = (EditText) rootView
				.findViewById(R.id.task_et_task_title);
		mTaskContentEt = (EditText) rootView
				.findViewById(R.id.task_et_task_content);
		mStartDateEt = (EditText) rootView
				.findViewById(R.id.task_et_start_date);
		mEndDateEt = (EditText) rootView.findViewById(R.id.task_et_end_date);
		mStartTimeEt = (EditText) rootView
				.findViewById(R.id.task_et_start_time);
		mEndTimeEt = (EditText) rootView.findViewById(R.id.task_et_end_time);
		mIsRemindCb = (CheckBox) rootView.findViewById(R.id.task_cb_is_remind);
		mFrequenceSp = (Spinner) rootView
				.findViewById(R.id.task_spinner_frequence);
		mBackIv = (ImageView) rootView.findViewById(R.id.task_iv_back);
		mProgressBar = (ProgressBar) rootView
				.findViewById(R.id.task_progress_bar);
		mTopTitleTv = (TextView) rootView.findViewById(R.id.task_tv_top_title);
		mConfirmBtn = (Button) rootView.findViewById(R.id.task_btn_confirm);

		mStartDateEt.setText(formalizeDate(currentYear, currentMonth,
				currentDay));
		mEndDateEt
				.setText(formalizeDate(currentYear, currentMonth, currentDay));
		mStartTimeEt.setText(formalizeTime(currentHour, currentMinutes));
		mEndTimeEt.setText(formalizeTime(currentHour, currentMinutes));

		mTaskTitleEt.addTextChangedListener(this);
		mBackIv.setOnClickListener(this);
		mStartDateEt.setOnClickListener(this);
		mEndDateEt.setOnClickListener(this);
		mStartTimeEt.setOnClickListener(this);
		mEndTimeEt.setOnClickListener(this);
		mConfirmBtn.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		currentClickItem = v.getId();
		switch (currentClickItem) {
		case R.id.task_et_start_date:
			new DatePickerDialog(getActivity(), this, currentYear,
					currentMonth, currentDay).show();
			break;
		case R.id.task_et_end_date:
			new DatePickerDialog(getActivity(), this, currentYear,
					currentMonth, currentDay).show();
			break;
		case R.id.task_et_start_time:
			new TimePickerDialog(getActivity(), this, currentHour,
					currentMinutes, true).show();
			break;
		case R.id.task_et_end_time:
			new TimePickerDialog(getActivity(), this, currentHour,
					currentMinutes, true).show();
			break;
		case R.id.task_iv_back:
			UIHelperUtil.makeToast(getActivity(), "退出创建吗");
			break;
		case R.id.task_btn_confirm:
			createTask();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 */
	private void createTask() {
		String taskTitle = mTaskTitleEt.getText().toString();
		String taskStartTime = mStartTimeEt.getText().toString();
		Task task = new Task.Builder(taskTitle, taskStartTime)
				.content(getEtContent(mTaskContentEt))
				.startDate(getEtContent(mStartDateEt))
				.endDate(getEtContent(mEndDateEt))
				.endTime(getEtContent(mEndTimeEt)).frequence(checkFrequence())
				.isRemind(mIsRemindCb.isChecked()).isGroupTask(false).build();
		mProgressBar.setVisibility(View.VISIBLE);
		mTopTitleTv.setText("正在创建中...");
	}

	private Frequence checkFrequence() {
		int position = mFrequenceSp.getSelectedItemPosition();
		return Frequence.values()[position];
	}

	private String getEtContent(EditText et) {
		return et.getText().toString();
	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		if (currentClickItem == R.id.task_et_start_time)
			mStartTimeEt.setText(formalizeTime(hourOfDay, minute));
		else
			mEndTimeEt.setText(formalizeTime(hourOfDay, minute));
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		if (currentClickItem == R.id.task_et_start_date)
			mStartDateEt.setText(formalizeDate(year, monthOfYear, dayOfMonth));
		else {
			mEndDateEt.setText(formalizeDate(year, monthOfYear, dayOfMonth));
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		if (!TextUtils.isEmpty(mTaskTitleEt.getText())) {
			mConfirmBtn.setEnabled(true);
		} else
			mConfirmBtn.setEnabled(false);
	}

	@Override
	public void afterTextChanged(Editable s) {

	}
}
