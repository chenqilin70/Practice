package oracle.huwl.com.handlertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void testHandler(View v){
        startActivity(new Intent(this,HandlerActivity.class));
    }
    public void handlerDemo(View v){
        startActivity(new Intent(this,HandlerDemo.class));
    }
    public void asyncTask(View v){
        startActivity(new Intent(this,AsyncTastTest.class));
    }
    public void testJson(View v){
        startActivity(new Intent(this,JsonTest.class));
    }
}
