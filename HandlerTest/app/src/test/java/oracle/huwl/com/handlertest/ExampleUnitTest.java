package oracle.huwl.com.handlertest;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /*@Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }*/
    @Test
    public void testJson() throws JSONException {
        String jsonStr="{\"name\":\"kylin\",\"age\":12}";

        JSONObject jsonObject=new JSONObject(jsonStr);
        System.out.println(jsonObject.toString());
        String name=jsonObject.getString("name");
        Integer age=jsonObject.getInt("age");
        System.out.print(name+","+age);

    }
}