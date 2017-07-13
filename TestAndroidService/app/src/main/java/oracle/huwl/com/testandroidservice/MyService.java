package oracle.huwl.com.testandroidservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/13.
 */

public class MyService extends Service {
    public MyService() {
        Log.e("test","MyService()-->");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("test","onBind-->");
        return null;
    }

    @Override
    public void onCreate() {
        Log.e("test","onCreate-->");
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Log.e("test","onDestroy-->");
        super.onDestroy();
    }
}
