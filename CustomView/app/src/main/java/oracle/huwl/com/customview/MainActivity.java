package oracle.huwl.com.customview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
    private MyTextView tv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=View.inflate(this,R.layout.activity_main,null);
        setContentView(v);
        tv_main=v.findViewById(R.id.tv_my);
        /*MyTextView textView=new MyTextView(this);
        textView.setText("kylin");
        setContentView(textView);*/
    }
    public void forceLayout(View v){
        tv_main.requestLayout();
        Log.e("test","force layout");

    }

}
