package com.smartlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartlife.activity.R;

/**
 * 自定义组合控件。由一个包含 {@link ImageView} 和 {@link TextView} 的 {@link LinearLayout} 组成。<br>
 * 布局文件在 {@code R.layout.imageview_button_layout} 中定义。<br>
 * 在xml布局使用时能够定义的属性有LinearLayout相关的属性以及:<br>
 * {@code android:src}<br>
 * {@code android:text}
 * */
public class ImageViewButton extends LinearLayout {

	private LinearLayout layout;
	private ImageView mIconIv;
	private TextView mContentTv;

	private CharSequence content;

	public ImageViewButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		LayoutInflater.from(context).inflate(R.layout.view_ivbtn_layout, this,
				true);

		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.ImageViewButton, 0, 0);

		Drawable d = a.getDrawable(R.styleable.ImageViewButton_android_src);
		content = a.getString(R.styleable.ImageViewButton_android_text);

		a.recycle();

		mIconIv = (ImageView) findViewById(R.id.iv_icon_com);
		mContentTv = (TextView) findViewById(R.id.tv_content_com);
		layout = (LinearLayout) findViewById(R.id.ll_container);

		if (isInEditMode()) {
			if (d != null && mIconIv != null)
				mIconIv.setImageDrawable(d);
			if (mContentTv != null && content != null)
				mContentTv.setText(content);
		} else {
			mIconIv.setImageDrawable(d);
			mContentTv.setText(content);
		}
	}

	/**
	 * 在LinearLayout中直接拦截事件，不向下分发。ImageView将不会接收到点击事件
	 * */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}

	/**
	 * 设置ImageView的src属性
	 * 
	 * @param resId
	 *            图片资源的resId
	 * */
	public void setImageResource(int resId) {
		mIconIv.setImageResource(resId);
		invalidate();
	}

	/**
	 * 设置TextView的text内容
	 * 
	 * @param text
	 *            内容
	 * */
	public void setText(CharSequence text) {
		mContentTv.setText(text);
		invalidate();
	}

	/** 设置ImageViewButton的选中状态。会将事件分发到子控件 */
	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		layout.setSelected(selected);
		mIconIv.setSelected(selected);
		mContentTv.setSelected(selected);
	}
}
