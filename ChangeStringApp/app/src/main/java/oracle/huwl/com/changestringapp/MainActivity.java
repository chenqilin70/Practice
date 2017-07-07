package oracle.huwl.com.changestringapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private SharedPreferences preferences;
    private String[] items;
    private ListView lv_fruit;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_fruit=findViewById(R.id.lv_fruit);

        preferences=this.getSharedPreferences("oracle", Context.MODE_PRIVATE);
        items=preferences.getString("items","").split(",");
        if(items==null || items.length==0){
            items="苹果,香蕉,梨子,西瓜,橘子".split(",");
            preferences.edit().putString("items","苹果,香蕉,梨子,西瓜,橘子").commit();
        }
        adapter=new ItemAdapter();
        lv_fruit.setAdapter(adapter);
        lv_fruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int position=i;
                final View dialog=View.inflate(MainActivity.this,R.layout.change_str_dialog,null);
                new AlertDialog.Builder(MainActivity.this)
                        .setView(dialog)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText et_newname=dialog.findViewById(R.id.et_newname);
                                String newName=et_newname.getText().toString();
                                Log.e("test","-->"+position);
                                items[position]=newName;
                                adapter.notifyDataSetChanged();
                                preferences.edit().putString("items",getItemString()).commit();
                            }
                        })
                        .setNeutralButton("取消",null)
                        .show();
            }
        });
    }
    public String getItemString(){
        StringBuffer sb=new StringBuffer("");
        for(String s:items){
            sb.append(s+",");
        }
        return sb.substring(0,sb.lastIndexOf(","));
    }
    class ItemAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return items[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            String s=items[i];
            if(view==null){
                view=View.inflate(MainActivity.this,R.layout.item_fruit,null);
            }
            TextView tv_fruit=view.findViewById(R.id.tv_fruit);
            tv_fruit.setText(s);
            return view;
        }
    }
}
