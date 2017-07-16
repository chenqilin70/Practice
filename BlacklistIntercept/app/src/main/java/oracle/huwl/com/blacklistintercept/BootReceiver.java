package oracle.huwl.com.blacklistintercept;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class BootReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context,BlacklistService.class));
    }
}
