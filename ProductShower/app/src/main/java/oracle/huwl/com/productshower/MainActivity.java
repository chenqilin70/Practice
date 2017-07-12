package oracle.huwl.com.productshower;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends Activity {
    private final int WHAT_SCCESS=1,WHAT_ERROR=2;
    private ListView lv_main;
    private LinearLayout line_main;
    private List<Product> data;
    private ProductAdapter adapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            line_main.setVisibility(View.GONE);
            switch (msg.what){
                case WHAT_SCCESS:
                    lv_main.setAdapter(adapter);
                    break;
                case WHAT_ERROR:
                    Toast.makeText(MainActivity.this,"网络出现问题！",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_main=findViewById(R.id.lv_main);
        line_main=findViewById(R.id.line_main);
        adapter=new ProductAdapter();
        line_main.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                String jsonStr=requestJson();
                data=new Gson().fromJson(jsonStr,new  TypeToken<List<Product>>(){}.getType());
                if(data.size()>0)
                    handler.sendEmptyMessage(WHAT_SCCESS);
                else
                    handler.sendEmptyMessage(WHAT_ERROR);
            }
        }.start();

    }
    private String requestJson()  {
        InputStream in=null;
        OutputStream out=null;
        String result="";
        HttpURLConnection connection=null;
        try {
            String path="http://120.24.244.103:8080/ProductShowerServer/ProductServlet";
            URL url=new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.connect();
            if(connection.getResponseCode()==200){
                in=connection.getInputStream();
                out=new ByteArrayOutputStream();
                int len=-1;
                byte[] buffer=new byte[1024];
                while((len=in.read(buffer))!=-1){
                    out.write(buffer,0,len);
                }
                result=out.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }
    class ProductAdapter extends BaseAdapter{
        private ImageLoader imageLoader;

        public ProductAdapter() {
            this.imageLoader = new ImageLoader(MainActivity.this);
        }

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
            if(view==null){
                view=View.inflate(MainActivity.this,R.layout.item_main,null);
            }
            Product p=data.get(i);
            TextView tv_name=view.findViewById(R.id.tv_pro_name);
            TextView tv_pro_price=view.findViewById(R.id.tv_pro_price);
            ImageView imageView=view.findViewById(R.id.iv_pic);
            tv_name.setText(p.getName());
            tv_pro_price.setText(p.getPrice()+"");
            String imagePath=p.getImg();
            imageLoader.loadImage(imagePath,imageView);
            return view;
        }
    }
}
