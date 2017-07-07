package oracle.huwl.com.storage;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by aierxuan on 2017/7/6.
 */

public class ToastUtil {
    public static void showDefaultToast(Context c,String text){
        Toast.makeText(c,text,Toast.LENGTH_SHORT).show();
    }
}
