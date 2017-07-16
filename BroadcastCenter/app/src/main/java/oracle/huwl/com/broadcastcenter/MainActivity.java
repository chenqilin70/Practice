package oracle.huwl.com.broadcastcenter;

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
    public void sendNomalCast(View v){
        Intent intent=new Intent("oracle.huwl.com.broadcastgetter.MyReceiver.action");
        intent.putExtra("action","actionValue");
        sendBroadcast(intent);
        Toast.makeText(this,"发送一般广播",Toast.LENGTH_SHORT).show();
    }
    public void sendOrderCast(View v){
        Intent intent=new Intent("oracle.huwl.com.broadcastgetter.MyReceiver.action2");
        intent.putExtra("action","TATA");
        sendOrderedBroadcast(intent,null);
        Toast.makeText(this,"发送有序广播",Toast.LENGTH_SHORT).show();
    }
}
