package com.huwl.oracle.componenttestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.Toast;
/**
 * 
 * @author KylinChen
 *
 */
public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		Button button=(Button) findViewById(R.id.menu_button);
		
		button.setOnCreateContextMenuListener(this);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, 1, 0, "添加");
		menu.add(0, 4, 0, "删除");
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		menu.add(1, 1, 2,"添加");
//		menu.add(1,2,1,"删除");
//		menu.add(2,3, Menu.NONE,"修改");
//		menu.add(2,4,Menu.NONE,"查询");
//		return super.onCreateOptionsMenu(menu);
//	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.option_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();;
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();;
		return super.onContextItemSelected(item);
	}
}
