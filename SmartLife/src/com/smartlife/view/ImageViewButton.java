package com.smartlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartlife.activity.R;

/**
 * 自定义组合控件。由一个包含 {@link ImageView} 和 {@link TextView} 的 {@link LinearLayout} 组成。<br>
 * 布局文件在 {@code R.layout.imageview_button_layout} 中定义。<br>
 * 在布局文件中能够定义的属性有LinearLayout相关的属性以及:<br>
 * {@code android:src}<br>
 * {@code android:text}
 * */
public class ImageViewButton extends LinearLayout {

	private LinearLayout layout;
	private ImageView mIconIv;
	private TextView mContentTv;

	private CharSequence content;
	private boolean b;

	public ImageViewButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		LayoutInflater.from(context).inflate(R.layout.imageview_button_layout,
				this, true);

		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.ImageViewButton, 0, 0);

		Drawable d = a.getDrawable(R.styleable.ImageViewButton_android_src);
		content = a.getString(R.styleable.ImageViewButton_android_text);
		b = a.getBoolean(R.styleable.ImageViewButton_android_enabled, false);

		a.recycle();

		mIconIv = (ImageView) findViewById(R.id.iv_icon_com);
		mContentTv = (TextView) findViewById(R.id.tv_content_com);
		layout = (LinearLayout) findViewById(R.id.ll_container);

		mIconIv.setEnabled(false);
		// TODO TESTING ImageView这个恶心的东西始终接收了Click事件，正在阻止中
		mIconIv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("CLICK", "I'm ImageView haha");
			}
		});
		if (isInEditMode()) {
			if (d != null && mIconIv != null)
				mIconIv.setImageDrawable(d);
			if (mContentTv != null && content != null)
				mContentTv.setText(content);
			this.setSelected(b);
		} else {
			mIconIv.setImageDrawable(d);
			mContentTv.setText(content);
			this.setSelected(b);
		}
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
