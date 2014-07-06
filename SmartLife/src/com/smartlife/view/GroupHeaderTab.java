/**
 * @author 吴湧霖
 * @version 创建时间：2014年7月6日 下午5:58:06 
 */
package com.smartlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartlife.activity.R;

/**
 * 群组Fragment的顶部Tab
 */
public class GroupHeaderTab extends LinearLayout implements OnClickListener{

	public final static int TAB_MYGROUP = 0;
	public final static int TAB_GROUPMSG = 1;
	public final static int TAB_GROUPMANAGER = 2;
	private TextView myGroupText;
	private TextView groupMsgText;
	private TextView groupManagerText;
	private OnChangeTabListener mOnChangeTabListener = null;

	public GroupHeaderTab(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.view_tab_header, this, true);
		
		initView();
	}

	private void initView() {
		myGroupText = (TextView)findViewById(R.id.text_my_group);
		myGroupText.setOnClickListener(this);
		groupMsgText = (TextView)findViewById(R.id.text_group_msg);
		groupMsgText.setOnClickListener(this);
		groupManagerText = (TextView)findViewById(R.id.text_group_manager);
		groupManagerText.setOnClickListener(this);
		setSelected(TAB_MYGROUP);
	}
	
	private void setOnChangeTabListener(OnChangeTabListener listener) {
		this.mOnChangeTabListener = listener;
	}
	
	/**
	 * 设置某一项Tab为选中状态，并回调mOnChangeTabListener的接口方法onChange
	 * @param pos 
	 * 		指定Tab项的索引
	 */
	public void setSelected(int pos) {
		resetToNormal();
		switch (pos) {
		case TAB_MYGROUP:
			myGroupText.setSelected(true);
			break;
		case TAB_GROUPMSG:
			groupMsgText.setSelected(true);
			break;
		case TAB_GROUPMANAGER:
			groupManagerText.setSelected(true);
			break;
		default:
			break;
		}
		if (mOnChangeTabListener != null) {
			mOnChangeTabListener.onChange(pos);
		}
	}

	/**
	 * 将所有Tab设置为默认样式，即全部无选中
	 */
	private void resetToNormal() {
		myGroupText.setSelected(false);
		groupMsgText.setSelected(false);
		groupManagerText.setSelected(false);
	}

	public interface OnChangeTabListener {
		public void onChange(int pos);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.text_my_group:
			if (!myGroupText.isSelected()) {
				setSelected(TAB_MYGROUP);
			}
			break;
		case R.id.text_group_msg:
			if (!groupMsgText.isSelected()) {
				setSelected(TAB_GROUPMSG);
			}
			break;
		case R.id.text_group_manager:
			if (!groupManagerText.isSelected()) {
				setSelected(TAB_GROUPMANAGER);
			}
			break;
		default:
			break;
		}
	}

}
