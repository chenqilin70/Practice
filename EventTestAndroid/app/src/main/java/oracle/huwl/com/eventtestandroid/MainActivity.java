package oracle.huwl.com.eventtestandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends Activity {
    private Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MotionEventTestActivity.class));
            }
        });
        findViewById(R.id.button2).setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity.this,KeyEventTestActivity.class));
                return true;
            }
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Date newDate=new Date();
            if(date==null || (newDate.getTime()-date.getTime())>1000){
                Toast.makeText(this,"再次点击回退将退出应用",Toast.LENGTH_SHORT).show();
                date=newDate;
            }else{
                finish();
            }
        }
        return true;
    }
}
