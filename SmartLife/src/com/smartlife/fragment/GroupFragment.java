/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:06:54 
 */
package com.smartlife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartlife.activity.R;

/**
 * 用于呈现小组相关信息的Fragment
 */
public class GroupFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_group, null);

		return rootView;
	}

}
