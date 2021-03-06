package com.huwl.oracle.app02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {
	private EditText et_second_message;
	public SecondActivity() {
		Log.e("test", "SecondActivity");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		et_second_message=(EditText) findViewById(R.id.et_second_message);
		et_second_message.setText(getIntent().getStringExtra("message"));
	}
	
	public void back1(View v){
		finish();
	}
	public void back2(View v){
		int resultCode=3;
		Intent data=new Intent();
		data.putExtra("RESULT", et_second_message.getText().toString());
		setResult(resultCode, data);
		finish();
	}
	public void startThird(View v){
		startActivity(new Intent(this, ThirdActivity.class));
	}
	public void startFirst(View v){
		startActivity(new Intent(this, MainActivity.class));
	}
}
