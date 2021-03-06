package com.huwl.oracle.callhelperapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnLongClickListener {
	private EditText ed_main_num;
	private EditText ed_main_sms;
	private Button btn_main_call; 
	private Button btn_main_send;
	private OnClickListener onClickListener=new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(v==btn_main_call){
				Toast.makeText(MainActivity.this, "点击了Call", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:"+ed_main_num.getText().toString()));				
				startActivity(intent);
			}else if(v == btn_main_send){
				Toast.makeText(MainActivity.this, "点击了Send", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("mmsto:"+ed_main_num.getText().toString()));
				intent.putExtra("sms_body", ed_main_sms.getText().toString());
				startActivity(intent);
			}
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_main_num=(EditText) findViewById(R.id.ed_main_num);
        ed_main_sms=(EditText) findViewById(R.id.ed_main_sms);
        btn_main_call=(Button) findViewById(R.id.btn_main_call);
        btn_main_send=(Button) findViewById(R.id.btn_main_send);
        btn_main_call.setOnClickListener(onClickListener);
        btn_main_send.setOnClickListener(onClickListener);
        btn_main_call.setOnLongClickListener(this);
        btn_main_send.setOnLongClickListener(this);
    }
	@Override
	public boolean onLongClick(View v) {
		if(v==btn_main_call){
			Toast.makeText(MainActivity.this, "长按了Call", Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(Intent.ACTION_CALL);
			Log.e("test",ed_main_num.getText().toString());
			intent.setData(Uri.parse("tel:"+ed_main_num.getText().toString()));
			startActivity(intent);
		}else if(v == btn_main_send){
			Toast.makeText(MainActivity.this, "长按了Send", Toast.LENGTH_SHORT).show();
			SmsManager smsManager=SmsManager.getDefault();
			smsManager.sendTextMessage(ed_main_num.getText().toString(), null, ed_main_sms.getText().toString(),null,null);
			Intent intent=new Intent(Intent.ACTION_SENDTO);
			intent.setData(Uri.parse("mmsto:"+ed_main_num.getText().toString()));
			startActivity(intent);
		}
		return true;//返回true表示事件已经被消费了
	}
}
