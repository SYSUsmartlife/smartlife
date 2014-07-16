package com.smartlife.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.fragment.PersonFragment;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.ChangeNameParams;
import com.smartlife.network.params.ChangePasswordParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends Activity implements OnClickListener{
	private int userId;
	
	private EditText prePasswordEditText;
	
	private EditText newPasswordEditText;
	
	private Button person_okButton;
	
	/**
	 * 修改密码
	 * 网络请求完成后的处理器
	 */
	private NetworkHandler mChangePasswordHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_CHANGE_PASSWORD_SUCCESS:
					UIHelperUtil.makeToast(ChangePasswordActivity.this, "修改成功！");
					
					Intent intent = new Intent(ChangePasswordActivity.this, HomeActivity.class);
					startActivity(intent);
					ChangePasswordActivity.this.finish();
					break;
				case NetworkConfig.CODE_CHANGE_PASSWORD_FAIL:
					UIHelperUtil.makeToast(ChangePasswordActivity.this, "修改失败！");
					break;
				default:
					UIHelperUtil.makeToast(ChangePasswordActivity.this, "returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(ChangePasswordActivity.this, obj.toString());
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(ChangePasswordActivity.this, errorMsg);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(ChangePasswordActivity.this, errorMsg);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_change_password);
		
		initView();
	}

	/**
	 * 初始化各控件
	 */
	private void initView() {
		userId = UserConfig.getInstance(this).getUserId();
		
		//初始化各个按钮
		prePasswordEditText = (EditText)findViewById(R.id.person_pre_password_text);
		newPasswordEditText = (EditText)findViewById(R.id.person_new_password_text);
		person_okButton = (Button)findViewById(R.id.btn_ok);
		person_okButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_ok:
			change();
			break;
		default:
			break;
		}
	}
	
	public void change()
	{
		String prePassword = prePasswordEditText.getText().toString();
		String newPassword = newPasswordEditText.getText().toString();
		if (StringUtil.isEmpty(prePassword)) {
			UIHelperUtil.makeToast(this, "旧密码不允许为空！请重新输入！");	
		}
		else if(StringUtil.isEmpty(newPassword)) {
			UIHelperUtil.makeToast(this, "新密码不允许为空！请重新输入！");	
		}
		else {
			ChangePasswordParams params = new ChangePasswordParams(userId, prePassword, newPassword);
			NetworkClient.getInstance().request(NetworkConfig.URL_CHANGE_PASSWORD, params, mChangePasswordHandler );
		}
	}
}
