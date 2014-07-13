package com.smartlife.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class CreateTaskActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_task);

//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.container, new CreateTaskFragment()).commit();
	}
}
