package oracle.huwl.com.testandroidservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    public void bindService(View v){

    }
    public void unbindService(View v){

    }
}
