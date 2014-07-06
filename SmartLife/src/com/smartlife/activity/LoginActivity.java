/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月6日 上午12:09:26 
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

/**
 * 应用程序登录界面
 */
public class LoginActivity extends Activity implements OnClickListener{

	/**
	 * 登录按钮
	 */
	private Button loginButton;
	/**
	 * 跳转到注册界面的链接
	 */
	private TextView registerLinkText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		initView();
	}

	/**
	 * 初始化各控件
	 */
	private void initView() {
		loginButton = (Button)findViewById(R.id.btn_login);
		registerLinkText = (TextView)findViewById(R.id.text_reg_link);
		loginButton.setOnClickListener(this);
		registerLinkText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			login();
			break;
		case R.id.text_reg_link:
			toRegister();
			break;
		default:
			break;
		}
	}

	/**
	 * 登录操作
	 */
	private void login() {
		Intent intent = new Intent(this, HomeActivity.class);
		startActivity(intent);
	}

	/**
	 * 跳转到注册界面
	 */
	private void toRegister() {
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
		this.finish();
	}

}
