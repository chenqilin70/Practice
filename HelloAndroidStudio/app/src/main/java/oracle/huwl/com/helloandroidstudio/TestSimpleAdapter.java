package oracle.huwl.com.helloandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestSimpleAdapter extends AppCompatActivity {
    private ListView lv_simple_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_simple_adapter);
        lv_simple_adapter= (ListView) findViewById(R.id.lv_simple_adapter);
        List<Map<String,Object>> data=new ArrayList<>();

        Map<String,Object> map=new HashMap<>();
        map.put("icon",R.drawable.icon1);
        map.put("name","util1");
        map.put("desc","desc1");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon2);
        map.put("name","util2");
        map.put("desc","desc2");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon3);
        map.put("name","util3");
        map.put("desc","desc3");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon4);
        map.put("name","util4");
        map.put("desc","desc4");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon5);
        map.put("name","util5");
        map.put("desc","desc5");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon6);
        map.put("name","util6");
        map.put("desc","desc6");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon7);
        map.put("name","util7");
        map.put("desc","desc7");
        data.add(map);

        map=new HashMap<>();
        map.put("icon",R.drawable.icon8);
        map.put("name","util8");
        map.put("desc","desc8");
        data.add(map);

        String[] from={"icon","name","desc"};
        int[] to={R.id.iv_icon,R.id.tv_name,R.id.tv_desc};
        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.item_siimple_adapter,from,to);
        lv_simple_adapter.setAdapter(adapter);
    }
}
