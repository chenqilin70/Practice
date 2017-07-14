package oracle.huwl.com.testandroidservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/14.
 */

public class MyRemoteService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("test","onBind");
        return new StudentService();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("test","onUnbind");
        return super.onUnbind(intent);
    }

    class StudentService extends IStudentService.Stub{

        @Override
        public Student getStudentById(int id) throws RemoteException {
            Log.e("test","Service getStudentById()");
            return new Student(id,"tiom",10000.00);
        }
    }


}
