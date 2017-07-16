package oracle.huwl.com.broadcastgetter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class MyReceiver4 extends BroadcastReceiver{
    public MyReceiver4() {
        Log.e("test","MyReceiver4()");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test","MyReceiver4-->onReceive()");
        if(isOrderedBroadcast()){
            abortBroadcast();
        }
    }
}
