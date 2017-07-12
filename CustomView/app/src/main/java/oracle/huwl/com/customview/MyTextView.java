package oracle.huwl.com.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/12.
 */

public class MyTextView extends AppCompatTextView{
    public MyTextView(Context context) {
        super(context);
        Log.e("test","MyTextView(Context context)");
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.e("test","MyTextView(Context context, @Nullable AttributeSet attrs)");
    }

    @Override
    protected void onFinishInflate() {
        Log.e("test","onFinishInflate");
        super.onFinishInflate();
    }

    @Override
    protected void onAttachedToWindow() {
        Log.e("test","onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("test","onMeasure   height:"+this.getMeasuredHeight()+"width:"+this.getMeasuredWidth());
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        Log.e("test","layout is running");
        super.layout(l, t, r, b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.e("test","onLayout is running，changed = "+changed);
        super.onLayout(changed, left, top, right, bottom);
    }

}
