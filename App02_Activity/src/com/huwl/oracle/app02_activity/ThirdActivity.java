package com.huwl.oracle.app02_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ThirdActivity extends Activity {
	public ThirdActivity() {
		Log.e("test","ThirdActivity……");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	}
}
