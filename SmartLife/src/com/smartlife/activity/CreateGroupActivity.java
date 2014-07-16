/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月8日 下午11:08:07 
 */
package com.smartlife.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.CreateGroupParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CreateGroupActivity extends Activity implements OnClickListener {

	private EditText groupNameEditText;
	private EditText groupDescriptionEditText;
	private Button createGroupButton;
	private NetworkHandler mNetworkHandler = new NetworkHandler() {
		
		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_CREATE_GROUP_SUCCESS:
					UIHelperUtil.makeToast(CreateGroupActivity.this, "创建群组成功！");
					break;
				case NetworkConfig.CODE_CREATE_GROUP_FAIL:
					UIHelperUtil.makeToast(CreateGroupActivity.this, "创建群组失败！");
					break;
				default:
					UIHelperUtil.makeToast(CreateGroupActivity.this, "returnCode:" + returnCode);
					break;
				}
				createGroupButton.setEnabled(true);
			} catch (JSONException e) {
				UIHelperUtil.makeToast(CreateGroupActivity.this, obj.toString());
				e.printStackTrace();
			}
		}
		
		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(CreateGroupActivity.this, errorMsg);
			createGroupButton.setEnabled(true);
		}
		
		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(CreateGroupActivity.this, errorMsg);
			createGroupButton.setEnabled(true);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_create_group);
		initView();
	}

	private void initView() {
		groupNameEditText = (EditText)findViewById(R.id.input_group_name);
		groupDescriptionEditText = (EditText)findViewById(R.id.input_group_description);
		createGroupButton = (Button)findViewById(R.id.btn_create_group);
		createGroupButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_create_group:
			createGroup();
			break;
		default:
			break;
		}
	}

	private void createGroup() {
		String groupName = groupNameEditText.getText().toString();
		String groupDescription = groupDescriptionEditText.getText().toString();
		if (StringUtil.isEmpty(groupName)) {
			UIHelperUtil.makeToast(CreateGroupActivity.this, "群组名称不允许为空！");
		} else {
			CreateGroupParams params = new CreateGroupParams(UserConfig.getInstance(this).getUserId(), groupName, groupDescription);
			createGroupButton.setEnabled(false);
			NetworkClient.getInstance().request(NetworkConfig.URL_CREATE_GROUP, params, mNetworkHandler);
		}
	}

}
