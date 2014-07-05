/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:07:06
 */
package com.smartlife.fragment;

import com.smartlife.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 用于呈现用于相关信息的Fragment
 */
public class PersonFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_person, null);
	}

}
