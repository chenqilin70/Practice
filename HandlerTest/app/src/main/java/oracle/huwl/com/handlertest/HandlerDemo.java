package oracle.huwl.com.handlertest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HandlerDemo extends Activity {
    private TextView tv_num;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int what=msg.what;
            int num=Integer.parseInt(tv_num.getText().toString());
            Log.e("test",num+"");
            if(what==1){
                tv_num.setText(""+(num+1));
            }else if (what==2){
                tv_num.setText(""+(num-1));
            }else if(what==3){

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);
        tv_num=findViewById(R.id.tv_num);
    }
    public void clickBtn(View v){
        int id=v.getId();
        if(id==R.id.increBtn){
            handler.sendEmptyMessage(1);
        }else if(id==R.id.reduceBtn){
            handler.sendEmptyMessage(2);
        }else if(id==R.id.pause){
            handler.sendEmptyMessage(3);
        }
    }
}
