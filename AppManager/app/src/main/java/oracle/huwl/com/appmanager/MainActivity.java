package oracle.huwl.com.appmanager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<AppInfo> allAppInfos;
    private ListView lv_main;
    private AppAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allAppInfos=getAllAppInfos();
        lv_main= (ListView) findViewById(R.id.lv_main);
        adapter=new AppAdapter();
        lv_main.setAdapter(adapter);

        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView nameTv=view.findViewById(R.id.textView);
                Toast.makeText(MainActivity.this,nameTv.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        lv_main.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                allAppInfos.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    public List<AppInfo> getAllAppInfos(){
        List<AppInfo> list=new ArrayList<>();
        PackageManager packageManager=getPackageManager();

        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos=packageManager.queryIntentActivities(intent,0);
        for(ResolveInfo info:resolveInfos){
            String packageName=info.activityInfo.packageName;
            Drawable icon=info.loadIcon(packageManager);
            String appName=info.loadLabel(packageManager).toString();
            AppInfo appInfo=new AppInfo(icon,appName,packageName);
            list.add(appInfo);
        }
        return list;
    }
    public void testMain(View v){
        Intent intent=new Intent(this,TestGridView.class);
        startActivity(intent);
    }
    class AppAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return allAppInfos.size();
        }
        @Override
        public Object getItem(int i) {
            return allAppInfos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            AppInfo info= (AppInfo) getItem(i);
            if(view == null){
                view=View.inflate(MainActivity.this,R.layout.item_main,null);
            }
            ImageView icon=view.findViewById(R.id.imageView);
            icon.setImageDrawable(info.getIcon());
            TextView tv=view.findViewById(R.id.textView);
            tv.setText(info.getAppName());
            return view;
        }
    }
}
