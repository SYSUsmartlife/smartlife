/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月6日 下午3:24:01 
 */
package com.smartlife.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.params.RegisterParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
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
	/**
	 * 注册邮箱输入框
	 */
	private EditText userEmailEditText;
	/**
	 * 密码输入框
	 */
	private EditText userPasswordEditText;
	/**
	 * 用户昵称输入框
	 */
	private EditText userNameEditText;
	/**
	 * 网络请求完成后的处理器
	 */
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_RESGISTER_SUCCESS:
					UIHelperUtil.makeToast(RegisterActivity.this, "注册成功！");
					break;
				case NetworkConfig.CODE_RESGISTER_EMAIL_EXIST:
					UIHelperUtil.makeToast(RegisterActivity.this, "邮箱已被注册！请重新输入！");
					break;
				case NetworkConfig.CODE_RESGISTER_NAME_INVALID:
					UIHelperUtil.makeToast(RegisterActivity.this, "用户昵称无效！请重新输入！");
					break;
				case NetworkConfig.CODE_RESGISTER_PASSWORD_INVALID:
					UIHelperUtil.makeToast(RegisterActivity.this, "密码无效！请重新输入！");
					break;
				case NetworkConfig.CODE_RESGISTER_EMAIL_INVALID:
					UIHelperUtil.makeToast(RegisterActivity.this, "注册邮箱无效！请重新输入！");
					break;
				default:
					UIHelperUtil.makeToast(RegisterActivity.this, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(RegisterActivity.this, obj.toString());
				e.printStackTrace();
			}
			registerButton.setEnabled(true);
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(RegisterActivity.this, errorMsg);
			registerButton.setEnabled(true);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(RegisterActivity.this, errorMsg);
			registerButton.setEnabled(true);
		}
	};

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
		userEmailEditText = (EditText)findViewById(R.id.input_email);
		userPasswordEditText = (EditText)findViewById(R.id.input_password);
		userNameEditText = (EditText)findViewById(R.id.input_name);
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
		String userEmail = userEmailEditText.getText().toString();
		String userPassword = userPasswordEditText.getText().toString();
		String userName = userNameEditText.getText().toString();
		if (StringUtil.isEmpty(userEmail)) {
			UIHelperUtil.makeToast(this, "注册邮箱不允许为空！请重新输入！");
		} else if (!StringUtil.isEmail(userEmail)) {
			UIHelperUtil.makeToast(this, "邮箱格式非法！请重新输入！");
		} else if (StringUtil.isEmpty(userPassword)) {
			UIHelperUtil.makeToast(this, "密码不允许为空！请重新输入！");
		} else if (!StringUtil.isValidUserNameOrPassword(userPassword)) {
			UIHelperUtil.makeToast(this, "密码只允许字母，数字和下划线！请重新输入！");
		} else if (StringUtil.isEmpty(userName)) {
			UIHelperUtil.makeToast(this, "用户昵称不允许为空！请重新输入！");
		} else if (!StringUtil.isValidUserNameOrPassword(userName)) {
			UIHelperUtil.makeToast(this, "用户昵称只允许字母，数字和下划线！请重新输入！");
		} else {
			RegisterParams params = new RegisterParams(userEmail, userPassword, userName);
			NetworkClient.getInstance().request(NetworkConfig.URL_REGISTER, params, mNetworkHandler );
			registerButton.setEnabled(false);
		}
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
