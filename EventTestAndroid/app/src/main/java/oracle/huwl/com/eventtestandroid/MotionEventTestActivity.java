package oracle.huwl.com.eventtestandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MotionEventTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event_test);
        MyImageView iv_head=findViewById(R.id.iv_head);
        iv_head.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("test","MyImageView……setOnTouchListener:"+motionEvent.getAction());
                return true;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("test","MotionEventTestActivity……dispatchTouchEvent:"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test","MotionEventTestActivity……onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }
}
