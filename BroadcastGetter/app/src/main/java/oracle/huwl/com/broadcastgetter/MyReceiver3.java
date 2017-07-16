package oracle.huwl.com.broadcastgetter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class MyReceiver3 extends BroadcastReceiver{
    public MyReceiver3() {
        Log.e("test","MyReceiver3()");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test","MyReceiver3-->onReceive()");
    }
}
