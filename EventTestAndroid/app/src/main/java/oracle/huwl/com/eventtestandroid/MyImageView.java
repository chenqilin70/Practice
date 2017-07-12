package oracle.huwl.com.eventtestandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by aierxuan on 2017/7/12.
 */

public class MyImageView extends AppCompatImageView {

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("test","MyImageView……");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("test","MyImageView……dispatchTouchEvent："+event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("test","MyImageView……onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }
}
