package oracle.huwl.com.handlertest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerDemo extends Activity {
    private TextView tv_num;
    private Button pause,reduceBtn,increBtn;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int what=msg.what;
            int num=Integer.parseInt(tv_num.getText().toString());
            Log.e("test",num+"");
            if(what==1){
                reduceBtn.setEnabled(true);
                increBtn.setEnabled(false);
                removeMessages(2);
                if(num+1<=20){
                    pause.setEnabled(true);
                    tv_num.setText(""+(num+1));
                    sendEmptyMessageDelayed(1,1000);
                }else{
                    pause.setEnabled(false);
                }
            }else if (what==2){
                reduceBtn.setEnabled(false);
                increBtn.setEnabled(true);
                removeMessages(1);
                if(num-1>=0){
                    pause.setEnabled(true);
                    tv_num.setText(""+(num-1));
                    sendEmptyMessageDelayed(2,1000);
                }else{
                    pause.setEnabled(false);
                }
            }else if(what==3){
                removeMessages(1);
                removeMessages(2);
                reduceBtn.setEnabled(true);
                increBtn.setEnabled(true);
                pause.setEnabled(false);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);
        tv_num=findViewById(R.id.tv_num);
        pause=findViewById(R.id.pause);
        reduceBtn=findViewById(R.id.reduceBtn);
        increBtn=findViewById(R.id.increBtn);

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
