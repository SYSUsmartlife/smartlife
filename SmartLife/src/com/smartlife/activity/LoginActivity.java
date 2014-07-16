/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月6日 上午12:09:26 
 */
package com.smartlife.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.LoginParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

/**
 * 应用程序登录界面
 */
public class LoginActivity extends Activity implements OnClickListener{

	/**
	 * 邮箱输入框
	 */
	private EditText userEmailEditText;
	/**
	 * 密码输入框
	 */
	private EditText userPasswordEditText;
	/**
	 * 登录按钮
	 */
	private Button loginButton;
	/**
	 * 跳转到注册界面的链接
	 */
	private TextView registerLinkText;
	/**
	 * 网络请求完成后的处理器
	 */
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_LOGIN_SUCCESS:
					UIHelperUtil.makeToast(LoginActivity.this, "登陆成功！");
					int userId = obj.getInt(NetworkConfig.KEY_RETURN_USER_ID);
					UserConfig.getInstance(LoginActivity.this).setUserId(userId);
					Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//					intent.putExtra(NetworkConfig.KEY_RETURN_USER_ID, userId);
					startActivity(intent);
//					LoginActivity.this.finish();
					break;
				case NetworkConfig.CODE_LOGIN_EMAIL_UNEXIST:
					UIHelperUtil.makeToast(LoginActivity.this, "该用户不存在！");
					break;
				case NetworkConfig.CODE_LOGIN_PASSWORD_ERROR:
					UIHelperUtil.makeToast(LoginActivity.this, "登陆密码错误！");
					break;
				default:
					UIHelperUtil.makeToast(LoginActivity.this, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(LoginActivity.this, obj.toString());
				e.printStackTrace();
			}
			loginButton.setEnabled(true);
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(LoginActivity.this, errorMsg);
			loginButton.setEnabled(true);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(LoginActivity.this, errorMsg);
			loginButton.setEnabled(true);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		initView();
		
		if (UserConfig.getInstance(this).getUserId() != UserConfig.USER_ID_INVALID) {
			Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
			startActivity(intent);
			//LoginActivity.this.finish();
		}
	}

	/**
	 * 初始化各控件
	 */
	private void initView() {
		userEmailEditText = (EditText)findViewById(R.id.input_email);
		userPasswordEditText = (EditText)findViewById(R.id.input_password);
		loginButton = (Button)findViewById(R.id.btn_login);
		registerLinkText = (TextView)findViewById(R.id.text_reg_link);
		loginButton.setOnClickListener(this);
		registerLinkText.setOnClickListener(this);
		
		// TODO 测试期间代码，开发完成后记得删除
		userEmailEditText.setText("wyl@163.com");
		userPasswordEditText.setText("wyl");
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
		String userEmail = userEmailEditText.getText().toString();
		String userPassword = userPasswordEditText.getText().toString();
		if (StringUtil.isEmpty(userEmail)) {
			UIHelperUtil.makeToast(this, "邮箱不允许为空！请重新输入！");
		} else if (StringUtil.isEmpty(userPassword)) {
			UIHelperUtil.makeToast(this, "密码不允许为空！请重新输入！");
		} else {
			LoginParams params = new LoginParams(userEmail, userPassword);
			loginButton.setEnabled(false);
			NetworkClient.getInstance().request(NetworkConfig.URL_LOGIN, params, mNetworkHandler );
		}
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
