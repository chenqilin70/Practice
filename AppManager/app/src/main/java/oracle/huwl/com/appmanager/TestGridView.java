package oracle.huwl.com.appmanager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestGridView extends AppCompatActivity {
    private GridView gv_main;
    private List<AppInfo> appInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_grid_view);
        gv_main= (GridView) findViewById(R.id.gv_main);
        AppGridAdapter adapter =new AppGridAdapter();
        appInfos=getAllAppInfos();
        gv_main.setAdapter(adapter);
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
    class AppGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return appInfos.size();
        }

        @Override
        public Object getItem(int i) {
            return appInfos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            AppInfo info=appInfos.get(i);
            if(view == null){
                view=View.inflate(TestGridView.this,R.layout.item_gridview,null);
            }
            ImageView icon=view.findViewById(R.id.imageView2);
            icon.setImageDrawable(info.getIcon());
           TextView appNameTv= view.findViewById(R.id.textView2);
            appNameTv.setText(info.getAppName());
            return view;
        }
    }
}
