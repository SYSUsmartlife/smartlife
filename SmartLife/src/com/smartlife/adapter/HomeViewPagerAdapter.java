/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午3:40:35
 */
package com.smartlife.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smartlife.fragment.GroupFragment;
import com.smartlife.fragment.PersonFragment;
import com.smartlife.fragment.TaskFragment;

/**
 * 主页ViewPager的适配器
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter{
	
	public static final int NUM_PAGES = 3;
	public static final int PAGE_TASK = 0;
	public static final int PAGE_GROUP = 1;
	public static final int PAGE_PERSON = 2;

	public HomeViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case PAGE_TASK:
			return new TaskFragment();
		case PAGE_GROUP:
			return new GroupFragment();
		case PAGE_PERSON:
			return new PersonFragment();
		default:
			break;
		}
		return new TaskFragment();
	}

	@Override
	public int getCount() {
		return NUM_PAGES;
	}

}
