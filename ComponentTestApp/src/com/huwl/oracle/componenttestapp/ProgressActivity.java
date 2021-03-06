package com.huwl.oracle.componenttestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class ProgressActivity extends Activity {
private SeekBar seekBar2;
private ProgressBar progressBar1;
private LinearLayout circleProgressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress);
		progressBar1=(ProgressBar) findViewById(R.id.progressBar1);
		circleProgressBar=(LinearLayout) findViewById(R.id.circleProgressBar);
		seekBar2=(SeekBar) findViewById(R.id.seekBar2);
		seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				Log.e("test",progress+"-->"+fromUser);
				progressBar1.setProgress(progress);
				if(progress==100){
					circleProgressBar.setVisibility(View.GONE);
				}else{
					circleProgressBar.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}
