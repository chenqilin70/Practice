package com.huwl.oracle.app02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private EditText et_main_message;
	private Button btn_main_start1;
	private Button btn_main_start2;
	public MainActivity() {
		Log.e("test","Main  Constractor……");
		
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.e("test","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_main_message=(EditText) findViewById(R.id.et_main_message);
        btn_main_start1=(Button) findViewById(R.id.btn_main_start1);
        btn_main_start2=(Button) findViewById(R.id.btn_main_start2);
        btn_main_start1.setOnClickListener(this);
        btn_main_start2.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v==btn_main_start1){
			Toast.makeText(this, "一般启动", Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(this, SecondActivity.class);
			intent.putExtra("message", et_main_message.getText().toString());
			startActivity(intent);
		}else if(v==btn_main_start2){
			Toast.makeText(this, "带回调启动", Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(this, SecondActivity.class);
			intent.putExtra("message", et_main_message.getText().toString());
			int requestCode=2;
			startActivityForResult(intent, requestCode);
		}
	}
	
	public void back3(View v){
		startActivity(new Intent(this,SmallActivity.class));
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==2 && resultCode==3){
			et_main_message.setText(data.getStringExtra("RESULT"));
		}
	}
	
	public void startSecond(View v)
	{
		startActivity(new Intent(this, SecondActivity.class));
	}
	public void startFirst(View v)
	{
		startActivity(new Intent(this, MainActivity.class));
	}
	
	
	
	
	
	
//	@Override
//	protected void onStart() {
//		Log.e("test","onStart");
//		super.onStart();
//	}
//	@Override
//	protected void onResume() {
//		Log.e("test","onResume");
//		super.onResume();
//	}
//	@Override
//	protected void onPause() {
//		Log.e("test","onPause");
//		super.onPause();
//	}
//	@Override
//	protected void onStop() {
//		Log.e("test","onStop");
//		super.onStop();
//	}
//	@Override
//	protected void onRestart() {
//		Log.e("test","onRestart");
//		super.onRestart();
//	}
//	@Override
//	protected void onDestroy() {
//		Log.e("test","onDestroy");
//		super.onDestroy();
//	}
}
