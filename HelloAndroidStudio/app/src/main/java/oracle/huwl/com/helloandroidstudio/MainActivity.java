package oracle.huwl.com.helloandroidstudio;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private AlertDialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog(View v){
        myDialog=new AlertDialog.Builder(this)
                .setView(View.inflate(this,R.layout.my_dialog,null))
                .show();
    }
    public void cancel(View v){
        Toast.makeText(this,"你点击了取消",Toast.LENGTH_SHORT).show();
        myDialog.dismiss();


    }
    public void confirm(View v){
        EditText et_username= (EditText) myDialog.findViewById(R.id.et_username);
        EditText et_password= (EditText) myDialog.findViewById(R.id.et_password);
        Toast.makeText(this,"你的用户名为："+et_username.getText()+"你的密码为："+et_password.getText(),Toast.LENGTH_SHORT).show();
    }
    public void showProgressDialog1(View  v){
        final ProgressDialog dialog=ProgressDialog.show(this,"数据正在加载","正在加载中……");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"数据加载完成",Toast.LENGTH_SHORT).show();
                    }
                });

            }

        }.start();
    }
    public void showProgressDialog2(View  v) throws InterruptedException {
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        new Thread(){
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    pd.setProgress(i);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pd.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"数据加载成功",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();
        pd.show();
    }
    public void showDateDialog(View v){
        Calendar calendar=Calendar.getInstance();
        Log.e("test","DAY_OF_MONTH:"+calendar.get(Calendar.DAY_OF_MONTH));
        Log.e("test","DAY_OF_WEEK:"+calendar.get(Calendar.DAY_OF_WEEK));
        Log.e("test","DAY_OF_WEEK_IN_MONTH:"+calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        Log.e("test","DAY_OF_YEAR:"+calendar.get(Calendar.DAY_OF_YEAR));
        Log.e("test","HOUR:"+calendar.get(Calendar.HOUR));
        Log.e("test","HOUR_OF_DAY:"+calendar.get(Calendar.HOUR_OF_DAY));
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Log.e("test","onDateSet:"+i+","+i1+","+i2);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
        .show();
    }
    public void showTimeDialog(View v){
        Calendar calendar=Calendar.getInstance();
        new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Log.e("test","onTimeSet:"+i+","+i1);
            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
    }
    public void sendEmail(View v){
        startDefaultActivity(SendEmail.class);
    }
    public void testRelative(View v){
        startDefaultActivity(TestRelativeLayout.class);
    }
    public void testFrame(View v){
        startDefaultActivity(TestFrameLayout.class);
    }
    public void testListView(View v){
        startDefaultActivity(TestListView.class);
    }
    public void testSimpleAdapter(View v){
        startDefaultActivity(TestSimpleAdapter.class);
    }
    public void testBaseAdapter(View v){
        startDefaultActivity(TestBaseAdater.class);
    }
    public void startDefaultActivity(Class clazz){
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
    }

}
