/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月4日 下午11:56:45 
 */
package com.smartlife.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.smartlife.adapter.HomeViewPagerAdapter;
import com.smartlife.view.ImageViewButton;

/**
 * 应用程序主页
 */
public class HomeActivity extends FragmentActivity implements
		OnPageChangeListener, OnClickListener {

	/**
	 * 主页的滑动切换浏览控件
	 */
	private ViewPager homeViewPager;
	/**
	 * 滑动切换浏览控件的适配器
	 */
	private HomeViewPagerAdapter homeViewPagerAdapter;

	private ImageViewButton taskIvbtn;
	private ImageViewButton groupIvbtn;
	private ImageViewButton personIvbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);

		initView();
	}

	/**
	 * 初始化各控件
	 */
	private void initView() {

		taskIvbtn = (ImageViewButton) findViewById(R.id.ivbtn_task);
		groupIvbtn = (ImageViewButton) findViewById(R.id.ivbtn_group);
		personIvbtn = (ImageViewButton) findViewById(R.id.ivbtn_person);

		taskIvbtn.setSelected(true);

		taskIvbtn.setOnClickListener(this);
		groupIvbtn.setOnClickListener(this);
		personIvbtn.setOnClickListener(this);

		homeViewPager = (ViewPager) findViewById(R.id.viewpager_home);
		homeViewPagerAdapter = new HomeViewPagerAdapter(
				getSupportFragmentManager());
		homeViewPager.setAdapter(homeViewPagerAdapter);
		homeViewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		resetToNormalView();
		switch (arg0) {
		case HomeViewPagerAdapter.PAGE_TASK:
			taskIvbtn.setSelected(true);
			break;
		case HomeViewPagerAdapter.PAGE_GROUP:
			groupIvbtn.setSelected(true);
			break;
		case HomeViewPagerAdapter.PAGE_PERSON:
			personIvbtn.setSelected(true);
			break;
		default:
			break;
		}
	}

	/**
	 * 将底部Tab设置为默认样式
	 */
	private void resetToNormalView() {
		taskIvbtn.setSelected(false);
		personIvbtn.setSelected(false);
		groupIvbtn.setSelected(false);
	}

	@Override
	public void onClick(View v) {
		resetToNormalView();
		switch (v.getId()) {
		case R.id.ivbtn_task:
			taskIvbtn.setSelected(true);
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_TASK);
			break;
		case R.id.ivbtn_group:
			groupIvbtn.setSelected(true);
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_GROUP);
			break;
		case R.id.ivbtn_person:
			personIvbtn.setSelected(true);
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_PERSON);
			break;

		default:
			break;
		}
	}

}
