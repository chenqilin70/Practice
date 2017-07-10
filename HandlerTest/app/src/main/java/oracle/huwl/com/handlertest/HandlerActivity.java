package oracle.huwl.com.handlertest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlerActivity extends Activity {
    private EditText et_th_result;
    private  ProgressBar progressBar1;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                et_th_result.setText(msg.obj.toString());
                progressBar1.setVisibility(View.INVISIBLE);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        et_th_result=findViewById(R.id.et_th_result);
        progressBar1=findViewById(R.id.progressBar1);
    }
    public void getSubmit(View v) throws IOException {
        progressBar1.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                HttpURLConnection connection=null;
                InputStream in=null;
                final OutputStream out=new ByteArrayOutputStream();;
                try{
                    connection=
                            (HttpURLConnection) new URL("http://120.24.244.103:8080/AndroidWebServer/index.jsp?name=kylin&age=18")
                                    .openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    int code=connection.getResponseCode();
                    if(code==200){
                        in=connection.getInputStream();
                        byte[] buffer=new byte[1024];
                        int len=-1;
                        while((len=in.read(buffer))!=-1){
                            out.write(buffer,0,len);
                        }
                        Log.e("test",out.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_th_result.setText(out.toString());
                                progressBar1.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                    if(in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            if(connection!=null){
                                try {
                                    out.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
            }
        }.start();
    }
    public void getSubmit2(View v){
        progressBar1.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                HttpURLConnection connection=null;
                InputStream in=null;
                final OutputStream out=new ByteArrayOutputStream();;
                try{
                    connection=
                            (HttpURLConnection) new URL("http://120.24.244.103:8080/AndroidWebServer/index.jsp?name=kylin&age=18")
                                    .openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    int code=connection.getResponseCode();
                    if(code==200){
                        in=connection.getInputStream();
                        byte[] buffer=new byte[1024];
                        int len=-1;
                        while((len=in.read(buffer))!=-1){
                            out.write(buffer,0,len);
                        }
                        Log.e("test",out.toString());
                        Message message=Message.obtain();
                        message.what=1;
                        message.obj=out.toString();
                        handler.sendMessage(message);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                    if(in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            if(connection!=null){
                                try {
                                    out.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
            }
        }.start();
    }
}
