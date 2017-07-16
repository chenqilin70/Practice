package oracle.huwl.com.broadcastgetter;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Integer i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private MyReceiver2 myReceiver2;
    public void registerReceiver(View v){
        if(myReceiver2==null){
            myReceiver2=new MyReceiver2();
            IntentFilter filter=new IntentFilter("oracle.huwl.com.broadcastgetter.MyReceiver.action");
            registerReceiver(myReceiver2,filter);
            Toast.makeText(this,"注册广播接收器",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"已经注册了广播接收器",Toast.LENGTH_SHORT).show();
        }

    }
    public void relieveReceiver(View v){
        if(myReceiver2!=null){
            unregisterReceiver(myReceiver2);
            myReceiver2=null;
        }else{
            Toast.makeText(this,"还未注册广播接收器",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if(myReceiver2!=null){
            unregisterReceiver(myReceiver2);
            myReceiver2=null;
        }
        super.onDestroy();
    }
}
