/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月4日 下午11:56:45 
 */
package com.smartlife.activity;

import com.smartlife.activity.R;
import com.smartlife.adapter.HomeViewPagerAdapter;
import com.smartlife.constant.ColorConstant;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 应用程序主页
 */
public class HomeActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {

	
	/**
	 * 主页的滑动切换浏览控件
	 */
	private ViewPager homeViewPager;
	/**
	 * 滑动切换浏览控件的适配器
	 */
	private HomeViewPagerAdapter homeViewPagerAdapter;
	
	private RelativeLayout taskLayout;
	private ImageView taskImg;
	private TextView taskText;
	private RelativeLayout groupLayout;
	private ImageView groupImg;
	private TextView groupText;
	private RelativeLayout personLayout;
	private ImageView personImg;
	private TextView personText;

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

		taskLayout = (RelativeLayout)findViewById(R.id.layout_task);
		taskImg = (ImageView)findViewById(R.id.img_task);
		taskText = (TextView)findViewById(R.id.text_task);
		taskLayout.setOnClickListener(this);
		groupLayout = (RelativeLayout)findViewById(R.id.layout_group);
		groupImg = (ImageView)findViewById(R.id.img_group);
		groupText = (TextView)findViewById(R.id.text_group);
		groupLayout.setOnClickListener(this);
		personLayout = (RelativeLayout)findViewById(R.id.layout_person);
		personImg = (ImageView)findViewById(R.id.img_person);
		personText = (TextView)findViewById(R.id.text_person);
		personLayout.setOnClickListener(this);

		taskImg.setImageResource(R.drawable.btn_task_pressed);
		taskText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_SELECTED_COLOR);
		taskLayout.setBackgroundResource(R.drawable.bottom_tab_selected_style);
		
		homeViewPager = (ViewPager)findViewById(R.id.viewpager_home);
		homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
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
			taskImg.setImageResource(R.drawable.btn_task_pressed);
			taskText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_SELECTED_COLOR);
			taskLayout.setBackgroundResource(R.drawable.bottom_tab_selected_style);
			break;
		case HomeViewPagerAdapter.PAGE_GROUP:
			groupImg.setImageResource(R.drawable.btn_group_pressed);
			groupText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_SELECTED_COLOR);
			groupLayout.setBackgroundResource(R.drawable.bottom_tab_selected_style);
			break;
		case HomeViewPagerAdapter.PAGE_PERSON:
			personImg.setImageResource(R.drawable.btn_person_pressed);
			personText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_SELECTED_COLOR);
			personLayout.setBackgroundResource(R.drawable.bottom_tab_selected_style);
			break;

		default:
			break;
		}
	}

	/**
	 * 将底部Tab设置为默认样式
	 */
	private void resetToNormalView() {
		taskLayout.setBackgroundColor(Color.TRANSPARENT);
		taskImg.setImageResource(R.drawable.btn_task_normal);
		taskText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_NORMAL_COLOR);
		groupLayout.setBackgroundColor(Color.TRANSPARENT);
		groupImg.setImageResource(R.drawable.btn_group_normal);
		groupText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_NORMAL_COLOR);
		personLayout.setBackgroundColor(Color.TRANSPARENT);
		personImg.setImageResource(R.drawable.btn_person_normal);
		personText.setTextColor(ColorConstant.BOTTOM_TAB_TEXT_NORMAL_COLOR);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_task:
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_TASK);
			break;
		case R.id.layout_group:
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_GROUP);
			break;
		case R.id.layout_person:
			homeViewPager.setCurrentItem(HomeViewPagerAdapter.PAGE_PERSON);
			break;

		default:
			break;
		}
	}

}
