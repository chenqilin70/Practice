package oracle.huwl.com.testandroidservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileDescriptor;

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
        return new Binder();
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

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("test","onUnbind-->");
        return super.onUnbind(intent);
    }
}
