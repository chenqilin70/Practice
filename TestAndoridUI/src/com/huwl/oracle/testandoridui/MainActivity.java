package com.huwl.oracle.testandoridui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openMyAlertDialog(View v){
    	View dialog=View.inflate(this, R.layout.dialog, null);
    	new AlertDialog.Builder(this)
    		.setView(dialog)	
    		.show();
    }
}
