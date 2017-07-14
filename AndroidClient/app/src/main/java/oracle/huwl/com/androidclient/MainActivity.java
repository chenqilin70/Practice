package oracle.huwl.com.androidclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import oracle.huwl.com.testandroidservice.IStudentService;
import oracle.huwl.com.testandroidservice.Student;

public class MainActivity extends Activity {
    private EditText et_id;
    private IStudentService iStudentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id=findViewById(R.id.et_id);
    }
    private ServiceConnection conn=null;
    public void bindRemoteService(View v){
        if(conn==null){
            conn=new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Log.e("test","onServiceConnected");
                    iStudentService=IStudentService.Stub.asInterface(iBinder);
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {

                }
            };
            bindService(new Intent("oracle.huwl.com.testandroidservice.MyRemoteService")
                    ,conn, Context.BIND_AUTO_CREATE);
            Toast.makeText(this,"绑定服务成功！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"已经绑定服务！",Toast.LENGTH_SHORT).show();
        }

    }
    public void callRemoteFun(View v){
        if(iStudentService!=null){
            int id=Integer.parseInt(et_id.getText().toString());
            try {
                Student stu=iStudentService.getStudentById(id);
                Toast.makeText(this,"结果："+stu.getId()+stu.getName()+stu.getPrice(),Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
    public void unbindRemoteService(View v){
        if(conn!=null){
            unbindService(conn);
            conn=null;
            iStudentService=null;
            Toast.makeText(this,"解绑服务！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"未绑定服务！",Toast.LENGTH_SHORT).show();
        }

    }
}
