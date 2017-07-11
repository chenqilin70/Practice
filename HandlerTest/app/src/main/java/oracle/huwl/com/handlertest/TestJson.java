package oracle.huwl.com.handlertest;

import android.test.AndroidTestCase;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aierxuan on 2017/7/11.
 */

public class TestJson extends  AndroidTestCase{
    public void testJson() throws JSONException {
        String jsonStr="{\"name\":\"kylin\",\"age\":12}";
        JSONObject jsonObject=new JSONObject(jsonStr);
        System.out.println(jsonObject+"--");
        String name=jsonObject.getString("name");
        Integer age=jsonObject.getInt("age");
        System.out.print(name+","+age);

    }
}
