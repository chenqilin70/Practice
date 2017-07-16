package oracle.huwl.com.blacklistintercept;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Method;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class BlacklistService extends Service{
    private TelephonyManager tm;
    private PhoneStateListener listener=new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.e("test","IDLE");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.e("test","RINGING"+incomingNumber+":"+("110".equals(incomingNumber)));
                    if("110".equals(incomingNumber)){
                        endCall();
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.e("test","OFFHOOK");
                    break;
            }
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void endCall(){
        try {
           Class c=Class.forName("android.os.ServiceManager");
           Method method= c.getMethod("getService",String.class);
           IBinder iBinder= (IBinder) method.invoke(null,Context.TELEPHONY_SERVICE);
            ITelephony iTelephony=ITelephony.Stub.asInterface(iBinder);
            iTelephony.endCall();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("test","onCreate");
        tm= (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("test","onDestroy");
        tm.listen(listener,PhoneStateListener.LISTEN_NONE);
    }
}
