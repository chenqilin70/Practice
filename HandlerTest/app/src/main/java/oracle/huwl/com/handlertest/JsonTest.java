package oracle.huwl.com.handlertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_test);
        try {
            testListToJsonStr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void testListToJsonStr(){
        List<Person> list=new ArrayList<>();
        Person p1=new Person("aaaa",111);
        Person p2=new Person("bbbb",121);
        Person p3=new Person("cccc",131);
        Person p4=new Person("dddd",141);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        String s=new Gson().toJson(list,new TypeToken<List<Person>>(){}.getType());
        Log.e("test",s);
    }
    public void testObjectToJsonStr(){
        Person p=new Person("kkkk",111);
        String s=new Gson().toJson(p);
        Log.e("test",s);
    }
    public void testGsonList(){
        List<Person> list = null;
        String jsonStr="[{\"name\":\"kylin1\",\"age\":12},{\"name\":\"kylin2\",\"age\":13},{\"name\":\"kylin3\",\"age\":14}]";
        list=new Gson().fromJson(jsonStr,new TypeToken<List<Person>>(){}.getType());
        Log.e("test",list.toString());
    }
    public void testOriginList() throws JSONException {
        String jsonStr="[{\"name\":\"kylin1\",\"age\":12},{\"name\":\"kylin2\",\"age\":13},{\"name\":\"kylin3\",\"age\":14}]";
        JSONArray jsonArray=new JSONArray(jsonStr);
        for(int i=0;i<jsonArray.length();i++){
            JSONObject o= (JSONObject) jsonArray.get(i);
            Log.e("test",new Person(o.getString("name"),o.getInt("age")).toString());
        }
    }
    public void testGson(){
        String jsonStr="{\"name\":\"kylin\",\"age\":12}";
        Person p=new Gson().fromJson(jsonStr,Person.class);
        Log.e("test",p.toString());
    }
    public void originJson(){
        try{
            String jsonStr="{\"name\":\"kylin\",\"age\":12}";
            JSONObject jsonObject=new JSONObject(jsonStr);
            String name=jsonObject.getString("name");
            Integer age=jsonObject.getInt("age");
            Log.e("test",name+","+age);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
