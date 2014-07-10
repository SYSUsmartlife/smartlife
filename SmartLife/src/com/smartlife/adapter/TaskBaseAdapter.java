/**
 * 创建时间：2014-7-9 下午9:05:51
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.smartlife.model.Task;

/**
 * TaskFragment中用到的adapter的 抽象类。<br>
 * 继承BaseAdapter，并实现了getItem等方法。
 * */
public abstract class TaskBaseAdapter<T extends Task> extends BaseAdapter {

	protected List<T> mTaskList;
	protected Context mContext;
	protected LayoutInflater inflater;
	protected int resId;

	public TaskBaseAdapter(Context context, List<T> mDataList) {
		this.mTaskList = mDataList;
		this.mContext = context;
		inflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mTaskList.size();
	}

	@Override
	public T getItem(int position) {
		return mTaskList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
