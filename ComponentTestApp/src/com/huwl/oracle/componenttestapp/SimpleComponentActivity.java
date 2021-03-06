package com.huwl.oracle.componenttestapp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleComponentActivity extends Activity {
	private CheckBox cb1,cb2;
	private RadioGroup radioGroup1;
	
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
				iv.setBackgroundResource(android.R.drawable.alert_light_frame);
				iv.setImageResource(android.R.drawable.ic_media_pause);
			}
		});
		cb1=(CheckBox) findViewById(R.id.checkBox1);
		cb2=(CheckBox) findViewById(R.id.checkBox2);
		cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Log.e("test",(buttonView==cb1)+"");
				Toast.makeText(SimpleComponentActivity.this,""+isChecked, Toast.LENGTH_SHORT).show();
			}
		});
		radioGroup1=(RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Toast.makeText(SimpleComponentActivity.this
						,""+((RadioButton)findViewById(checkedId)).getText().toString()
						, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	public void submit(View v){
		StringBuffer result=new StringBuffer("");
		if(cb1.isChecked()){
			result.append(cb1.getText().toString());
		}
		if(cb1.isChecked() && cb2.isChecked()){
			result.append(",");
		}
		if(cb2.isChecked()){
			result.append(cb2.getText().toString());
		}
		if(!cb1.isChecked()&& !cb2.isChecked()){
			result.append("没有被选中的");
		}
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}
}
