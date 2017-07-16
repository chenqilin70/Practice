package oracle.huwl.com.stopcommunication;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Method;

public class MainActivity extends Activity implements View.OnClickListener {
private Button stop_conm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stop_conm=findViewById(R.id.stop_conm);
        stop_conm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Class c= Class.forName("android.os.ServiceManager");
            Method method=c.getMethod("getService",String.class);
            IBinder iBinder= (IBinder) method.invoke(null, Context.TELEPHONY_SERVICE);
            ITelephony iTelephony=ITelephony.Stub.asInterface(iBinder);
            iTelephony.endCall();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
