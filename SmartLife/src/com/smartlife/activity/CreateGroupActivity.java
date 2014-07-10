/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月8日 下午11:08:07 
 */
package com.smartlife.activity;

import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CreateGroupActivity extends Activity implements OnClickListener {

	private EditText groupNameEditText;
	private EditText groupDescriptionEditText;
	private Button createGroupButton;

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
			
		}
	}

}
