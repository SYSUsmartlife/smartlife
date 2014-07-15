/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:07:06
 */
package com.smartlife.fragment;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.activity.ChangePasswordActivity;
import com.smartlife.activity.CreateGroupActivity;
import com.smartlife.activity.HomeActivity;
import com.smartlife.activity.LoginActivity;
import com.smartlife.activity.R;
import com.smartlife.network.NetworkClient;
import com.smartlife.network.NetworkConfig;
import com.smartlife.network.NetworkHandler;
import com.smartlife.network.UserConfig;
import com.smartlife.network.params.ChangeNameParams;
import com.smartlife.network.params.GetUserParams;
import com.smartlife.network.params.LoginParams;
import com.smartlife.util.StringUtil;
import com.smartlife.util.UIHelperUtil;
import com.smartlife.view.GroupHeaderTab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 用于呈现用于相关信息的Fragment
 */
public class PersonFragment extends Fragment implements OnClickListener {
	/**
	 * 用户Id
	 */
	private int userId;
	/**
	 * 用户注册邮箱
	 */
	private TextView emailTextView;

	/**
	 * 用户名
	 */
	private EditText userNameEditText;

	/**
	 * 更改用户名按钮
	 */
	private Button editUserNameButton;

	/**
	 * 修改密码链接
	 */
	private TextView changePasswordTextView;

	/**
	 * 创建活动链接
	 */
	private TextView createActivityTextView;

	/**
	 * 关于软件链接
	 */
	private TextView aboutSoftwareTextView;

	/**
	 * 退出按钮
	 */
	private Button exitButton;

	/**
	 * 切换账号按钮
	 */
	private Button exchangeButton;

	/**
	 * 当前用户名
	 */
	private String curUserName;
	private String email;

	/**
	 * 获取用户基本信息 网络请求完成后的处理器
	 */
	private NetworkHandler mGetUserHandler = new NetworkHandler() {

		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_GET_USER_SUCCESS:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"获取信息成功！");

					email = obj.getString(NetworkConfig.KEY_RETURN_EMAIL);
					emailTextView.setText(email);

					curUserName = obj
							.getString(NetworkConfig.KEY_RETURN_USER_NAME);
					userNameEditText.setText(curUserName);

					break;
				case NetworkConfig.CODE_GET_USER_FAIL:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"获取信息失败！");
					break;
				default:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
						obj.toString());
				e.printStackTrace();
			}
		}

		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(PersonFragment.this.getActivity(), errorMsg);
		}

		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(PersonFragment.this.getActivity(), errorMsg);
		}
	};

	/**
	 * 更改用户名 网络请求完成后的处理器
	 */
	private NetworkHandler mChangeNameHandler = new NetworkHandler() {

		@Override
		public void handleResponseJson(JSONObject obj) {
			try {
				int returnCode = obj.getInt(NetworkConfig.KEY_RETURN_CODE);
				switch (returnCode) {
				case NetworkConfig.CODE_CHANGE_NAME_SUCCESS:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"修改成功！");
					curUserName = obj
							.getString(NetworkConfig.KEY_RETURN_USER_NAME);
					userNameEditText.setText(curUserName);
					break;
				case NetworkConfig.CODE_CHANGE_NAME_FAIL:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"修改失败！");
					break;
				default:
					UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
							"returnCode:" + returnCode);
					break;
				}
			} catch (JSONException e) {
				UIHelperUtil.makeToast(PersonFragment.this.getActivity(),
						obj.toString());
				e.printStackTrace();
			}
		}

		@Override
		public void handleResponseError(String errorMsg) {
			UIHelperUtil.makeToast(PersonFragment.this.getActivity(), errorMsg);
		}

		@Override
		public void handleNetworkError(String errorMsg) {
			UIHelperUtil.makeToast(PersonFragment.this.getActivity(), errorMsg);
		}
	};

	/**
	 * 更改密码 网络请求完成后的处理器
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_person, null);
		initView(view);
		return view;
	}

	/**
	 * 初始化各个控件
	 * 
	 * @param view
	 */
	private void initView(View view) {
		userId = UserConfig.getInstance(this.getActivity()).getUserId();

		emailTextView = (TextView) view
				.findViewById(R.id.ic_person_info_email_text);
		userNameEditText = (EditText) view
				.findViewById(R.id.ic_person_info_username_text);
		editUserNameButton = (Button) view.findViewById(R.id.btn_edit_username);
		changePasswordTextView = (TextView) view
				.findViewById(R.id.ic_person_change_password_text);
		createActivityTextView = (TextView) view
				.findViewById(R.id.ic_person_create_activity_text);
		aboutSoftwareTextView = (TextView) view
				.findViewById(R.id.ic_person_software);
		exitButton = (Button) view.findViewById(R.id.btn_exit);
		exchangeButton = (Button) view.findViewById(R.id.btn_exchange);

		editUserNameButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		exchangeButton.setOnClickListener(this);
		changePasswordTextView.setOnClickListener(this);
		createActivityTextView.setOnClickListener(this);
		aboutSoftwareTextView.setOnClickListener(this);
		editUserNameButton.setText("edit");
		userNameEditText.setEnabled(false);

	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			getUserInfo();
		}
	}

	public void getUserInfo() {
		GetUserParams params = new GetUserParams(userId);
		NetworkClient.getInstance().request(NetworkConfig.URL_GET_USER, params,
				mGetUserHandler);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_edit_username:
			if (editUserNameButton.getText() == "edit")
				editUserName();
			else
				updateUserName();
			break;
		case R.id.ic_person_change_password_text:
			changePassword();
			break;
		case R.id.ic_person_create_activity_text:
			createActivity();
			break;
		case R.id.ic_person_software:
			aboutSoftware();
			break;
		case R.id.btn_exit:
			getActivity().finish();
			break;
		case R.id.btn_exchange:
			exchange();
			break;
		default:
			break;
		}
	}

	private void editUserName() {
		curUserName = userNameEditText.getText().toString();

		userNameEditText.setEnabled(true);
		editUserNameButton.setText("ok");
	}

	private void updateUserName() {
		String userName = userNameEditText.getText().toString();
		if (StringUtil.isEmpty(userName)) {
			UIHelperUtil.makeToast(this.getActivity(), "用户名不允许为空！请重新输入！");

			userNameEditText.setText(curUserName);
			userNameEditText.setEnabled(false);
			editUserNameButton.setText("edit");
		} else {
			ChangeNameParams params = new ChangeNameParams(userId, userName);
			editUserNameButton.setText("edit");
			userNameEditText.setEnabled(false);
			NetworkClient.getInstance().request(NetworkConfig.URL_CHANGE_NAME,
					params, mChangeNameHandler);

		}
	}

	private void changePassword() {
		Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
		startActivity(intent);
		this.getActivity().finish();
	}

	private void createActivity() {
		Intent intent = new Intent(getActivity(), CreateGroupActivity.class);
		startActivity(intent);
		this.getActivity().finish();
	}

	private void aboutSoftware() {

	}

	private void exit() {
		getActivity().finish();
	}

	private void exchange() {
		UserConfig.getInstance(this.getActivity()).setUserId(-1);

		Intent intent = new Intent(getActivity(), LoginActivity.class);
		startActivity(intent);
		this.getActivity().finish();
	}
}
