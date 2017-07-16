package oracle.huwl.com.blacklistintercept;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/15.
 */

public class SmsReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras=intent.getExtras();
        Object[] pdus= (Object[]) extras.get("pdus");
        SmsMessage smsMessage=SmsMessage.createFromPdu((byte[]) pdus[0]);
       String num= smsMessage.getOriginatingAddress();
        String content=smsMessage.getMessageBody();
        Log.e("test",num+content);
        if("110".equals(num)){
            abortBroadcast();
            Log.e("test","拦截到一个短信！");
        }
    }
}
