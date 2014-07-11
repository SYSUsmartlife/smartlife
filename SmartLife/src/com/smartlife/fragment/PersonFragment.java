/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月5日 下午4:07:06
 */
package com.smartlife.fragment;

import com.smartlife.activity.CreateGroupActivity;
import com.smartlife.activity.LoginActivity;
import com.smartlife.activity.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 用于呈现用于相关信息的Fragment
 */
public class PersonFragment extends Fragment implements OnClickListener{
	/**
	 * 用户注册邮箱
	 */
	private TextView emailTextView;
	
	/**
	 * 用户名
	 */
	private TextView usernameTextView;
	
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.fragment_person, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		emailTextView=(TextView) view.findViewById(R.id.ic_person_info_email_text);
		usernameTextView=(TextView)view.findViewById(R.id.ic_person_info_username_text);
		editUserNameButton=(Button)view.findViewById(R.id.person_edit_username);
		changePasswordTextView=(TextView)view.findViewById(R.id.ic_person_change_password_text);
		createActivityTextView=(TextView)view.findViewById(R.id.ic_person_create_activity_text);
		aboutSoftwareTextView=(TextView)view.findViewById(R.id.ic_person_software);
		exitButton=(Button)view.findViewById(R.id.btn_exit);
		exchangeButton=(Button)view.findViewById(R.id.btn_exchange);
		
		editUserNameButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		exchangeButton.setOnClickListener(this);
		changePasswordTextView.setOnClickListener(this);
		createActivityTextView.setOnClickListener(this);
		aboutSoftwareTextView.setOnClickListener(this);
		
		// 测试期间代码，开发完成后记得删除
		emailTextView.setText("wyl@163.com");
		usernameTextView.setText("wyl");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.person_edit_username:
			editUserName();
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
			exit();
			break;
		case R.id.btn_exchange:
			exchange();
			break;
		default:
			break;
		}
	}
	
private void editUserName(){
    	
    }
    
    private void changePassword(){
    	
    }
    
    private void createActivity(){
    	Intent intent = new Intent(getActivity(), CreateGroupActivity.class);
		startActivity(intent);
		this.getActivity().finish();
    }
    
    private void aboutSoftware(){
    	
    }
    
    private void exit(){
    	System.exit(0);
    }
    
    private void exchange(){
    	Intent intent = new Intent(getActivity(), LoginActivity.class);
		startActivity(intent);
		this.getActivity().finish();
    }
}
