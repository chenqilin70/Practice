package com.huwl.oracle.app01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_main_download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_size);
//        setContentView(R.layout.activity_main);
//        btn_main_download = (Button) findViewById(R.id.btn_main_download);
//        btn_main_download.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Toast
//					.makeText(MainActivity.this
//							, "开始下载"
//							, Toast.LENGTH_LONG)
//					.show();
//				btn_main_download.setText("下载中");
//			}
//		});
    }
}
