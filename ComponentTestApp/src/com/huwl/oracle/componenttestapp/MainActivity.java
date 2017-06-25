package com.huwl.oracle.componenttestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        findViewById(R.id.btn_test_dialog).setOnClickListener(this);
        findViewById(R.id.btn_test_menu).setOnClickListener(this);
        findViewById(R.id.btn_test_progress_bar).setOnClickListener(this);
        findViewById(R.id.btn_test_simple).setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_test_dialog:
			
			break;
		case R.id.btn_test_menu:
			startActivity(new Intent(this, MenuActivity.class));
			break;
		case R.id.btn_test_progress_bar:
			startActivity(new Intent(this, ProgressActivity.class));
			break;
		case R.id.btn_test_simple:
			startActivity(new Intent(this, SimpleComponentActivity.class));
			break;
		default:
			
			break;
		}
		
	}
}
