package com.huwl.oracle.componenttestapp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleComponentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_component);
		TextView tv_simple_message=(TextView) findViewById(R.id.tv_simple_message);
		tv_simple_message.setText("this is changed Text");
		ImageView imgView_simple=(ImageView) findViewById(R.id.imgView_simple);
		imgView_simple.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ImageView iv=(ImageView) v;
				iv.setBackgroundResource(android.R.drawable.alert_dark_frame);
				iv.setImageResource(android.R.drawable.ic_media_pause);
			}
		});
	}
}
