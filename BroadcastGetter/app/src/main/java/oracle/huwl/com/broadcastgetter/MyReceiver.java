package oracle.huwl.com.broadcastgetter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class MyReceiver extends BroadcastReceiver{
    public MyReceiver() {
        Log.e("test","MyReceiver()");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test","MyReceiver-->onReceive()-->ExtraValue:"+intent.getStringExtra("action"));
    }
}
