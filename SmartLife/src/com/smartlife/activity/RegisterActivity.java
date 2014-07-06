/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月6日 下午3:24:01 
 */
package com.smartlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity implements OnClickListener{

	/**
	 * 注册按钮
	 */
	private Button registerButton;
	/**
	 * 跳转到登录界面的链接
	 */
	private TextView loginLinkText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		
		initView();
	}

	/**
	 * 初始化各控件
	 */
	private void initView() {
		registerButton = (Button)findViewById(R.id.btn_register);
		loginLinkText = (TextView)findViewById(R.id.text_login_link);
		registerButton.setOnClickListener(this);
		loginLinkText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register:
			register();
			break;
		case R.id.text_login_link:
			toLogin();
			break;
		default:
			break;
		}
	}

	/**
	 * 注册操作
	 */
	private void register() {
		
	}

	/**
	 * 跳转到登录界面
	 */
	private void toLogin() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		this.finish();
	}

}
