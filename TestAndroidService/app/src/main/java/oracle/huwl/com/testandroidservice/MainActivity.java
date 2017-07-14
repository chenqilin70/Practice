package oracle.huwl.com.testandroidservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(connection!=null){
//            unbindService(connection);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View v){
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
        Toast.makeText(this,"service is running",Toast.LENGTH_SHORT).show();
    }
    public void stopService(View v){
        stopService(new Intent(this,MyService.class));
        Toast.makeText(this,"service is shutdown",Toast.LENGTH_SHORT).show();
    }
    private ServiceConnection connection;
    public void bindService(View v){
        if(connection==null){
            connection=new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Log.e("test","onServiceConnected-->");
                }
                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    Log.e("test","onServiceDisconnected-->");
                }
            };
            bindService(new Intent(this,MyService.class)
                    ,connection, Context.BIND_AUTO_CREATE);
        }else{
            Toast.makeText(this,"已经绑定",Toast.LENGTH_SHORT).show();
        }
    }
    public void unbindService(View v){
        if(connection==null){
            Toast.makeText(this,"还未绑定",Toast.LENGTH_SHORT).show();
        }else{
            unbindService(connection);
            connection=null;
        }

    }

}
