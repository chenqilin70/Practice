package oracle.huwl.com.eventtestandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class KeyEventTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_event_test);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.e("test","dispatchKeyEvent:"+event.getAction()+" keyCode:"+event.getKeyCode());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("test","onKeyDown："+event.getAction()+" keyCode:"+event.getKeyCode());
        event.startTracking();
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.e("test","onKeyUp："+event.getAction()+" keyCode:"+event.getKeyCode());
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("test","onKeyLongPress："+event.getAction()+" keyCode:"+event.getKeyCode());
        return super.onKeyLongPress(keyCode, event);
    }
}
