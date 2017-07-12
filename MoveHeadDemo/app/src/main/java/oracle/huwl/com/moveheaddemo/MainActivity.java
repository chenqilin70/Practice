package oracle.huwl.com.moveheaddemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            private float oldX=0 ,oldY=0;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction()==0){
                    oldX=event.getRawX();
                    oldY=event.getRawY();
                }else if(event.getAction()==1){

                }else if(event.getAction()==2){
                    float newX=event.getRawX();
                    float newY=event.getRawY();
                    int dx=(int)(newX-oldX);
                    int dy=(int)(newY-oldY);
                    int top,left,bottom,right;
                    top=(imageView.getTop()+dy);
                    bottom=(imageView.getBottom()+dy);
                    left=(imageView.getLeft()+dx);
                    right=(imageView.getRight()+dx);
                    if(top<0){
                        bottom-=top;
                        top=0;
                    }
                    if(left<0){
                        right+=-left;
                        left=0;

                    }
                    if(bottom<0){
                        bottom=0;
                        top=imageView.getTop();
                    }

                    if(right<0){
                        right=0;
                        left=imageView.getLeft();
                    }
                    imageView.layout(left,top,right,bottom);
                    oldX=newX;
                    oldY=newY;
                }
                return true;
            }
        });
    }
}
