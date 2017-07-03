package oracle.huwl.com.helloandroidstudio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestBaseAdater extends Activity {
    private ListView lv_base_adapter;
    private List<ShopInfo> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_base_adater);
        lv_base_adapter= (ListView) findViewById(R.id.lv_base_adapter);
        data=new ArrayList<>();
        data.add(new ShopInfo(R.drawable.icon1,"name1","desc1"));
        data.add(new ShopInfo(R.drawable.icon1,"name11","desc11"));
        data.add(new ShopInfo(R.drawable.icon1,"name111","desc111"));
        data.add(new ShopInfo(R.drawable.icon1,"name1111","desc1111"));
        data.add(new ShopInfo(R.drawable.icon1,"name11111","desc11111"));
        data.add(new ShopInfo(R.drawable.icon2,"name2","desc2"));
        data.add(new ShopInfo(R.drawable.icon3,"name3","desc3"));
        data.add(new ShopInfo(R.drawable.icon4,"name4","desc4"));
        data.add(new ShopInfo(R.drawable.icon5,"name5","desc5"));
        data.add(new ShopInfo(R.drawable.icon6,"name6","desc6"));
        data.add(new ShopInfo(R.drawable.icon7,"name7","desc7"));
        data.add(new ShopInfo(R.drawable.icon8,"name8","desc8"));
        MyBaseAdapter adapter=new MyBaseAdapter();
        lv_base_adapter.setAdapter(adapter);

    }
    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Log.e("test","getView:"+view);
            if(view==null){
                view=View.inflate(TestBaseAdater.this,R.layout.item_siimple_adapter,null);
            }
            ShopInfo shopInfo=data.get(i);
            TextView tv_name=view.findViewById(R.id.tv_name);
            TextView tv_desc=view.findViewById(R.id.tv_desc);
            ImageView iv_icon=view.findViewById(R.id.iv_icon);
            iv_icon.setImageResource(shopInfo.getIcon());
            tv_name.setText(shopInfo.getName());
            tv_desc.setText(shopInfo.getDesc());
            return view;
        }
    }
}
