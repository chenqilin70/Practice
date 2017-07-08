package oracle.huwl.com.testnetwork;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParamBean;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private EditText et_result,et_nw_url;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_result= findViewById(R.id.et_result);
        et_nw_url= findViewById(R.id.et_nw_url);
        queue= Volley.newRequestQueue(this);
    }
    public void testHttpUrlConnectionGet(View v){
        final ProgressDialog dialog=ProgressDialog.show(this,"正在网络请求数据","Loading……");
        new Thread(){
            @Override
            public void run() {
                try{
                    String path=et_nw_url.getText().toString()+"?name=Tom1&age=11";
                    URL url=new URL(path);
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(6000);
                    connection.connect();
                    int responseCode=connection.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream=connection.getInputStream();
                        byte[] resultByte=new byte[0];
                        byte[] buffer=new byte[1024];
                        int len=-1;
                        while((len=inputStream.read(buffer))!=-1){
                            int oldLen=resultByte.length;
                            resultByte=Arrays.copyOf(resultByte,oldLen+len);
                            System.arraycopy(buffer,0,resultByte,oldLen,len);
                        }
                        final String result=new String(resultByte);
                        inputStream.close();
                        connection.disconnect();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_result.setText(result );
                                dialog.dismiss();
                            }
                        });

                    }

                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }.start();
    }
    public void testHttpUrlConnectionPost(View v)throws  Exception{
        final ProgressDialog dialog=ProgressDialog.show(this,null,"loading……");
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url=new URL(et_nw_url.getText().toString());
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("POST");
                    connection.setReadTimeout(5000);
                    connection.connect();
                    OutputStream out=connection.getOutputStream();
                    out.write("name=kylin&age=20".getBytes());
                    out.flush();
                    out.close();
                    int code=connection.getResponseCode();
                    if(code==200){
                        InputStream in= connection.getInputStream();
                        byte[] resultByte=new byte[0];
                        byte[] buffer=new byte[1024];
                        int len=-1;
                        while((len=in.read(buffer))!=-1){
                            int oldLen=resultByte.length;
                            resultByte=Arrays.copyOf(resultByte,oldLen+len);
                            System.arraycopy(buffer,0,resultByte,oldLen,len);
                        }
                        final String result=new String(resultByte);
                        in.close();
                        connection.disconnect();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_result.setText(result );
                                dialog.dismiss();
                            }
                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }.start();
    }
    public void testHttpClientGet(View v){
        final ProgressDialog dialog=ProgressDialog.show(this,"正在网络请求数据","Loading……");
        new Thread(){
            @Override
            public void run() {
                try{
                    String path=et_nw_url.getText().toString()+"?name=tom2&age=50";
                    HttpClient client=new DefaultHttpClient();
                    HttpParams params=client.getParams();
                    HttpConnectionParams.setConnectionTimeout(params,5000);
                    HttpConnectionParams.setSoTimeout(params,5000);
                    HttpGet request=new HttpGet(path);
                    HttpResponse response=client.execute(request);
                    int code=response.getStatusLine().getStatusCode();
                    if(code==200){
                        final String result=EntityUtils.toString(response.getEntity());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_result.setText(result);
                                dialog.dismiss();
                            }
                        });
                    }
                    client.getConnectionManager().shutdown();

                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }.start();
    }
    public void testHttpClientPost(View v){
        final ProgressDialog dialog=ProgressDialog.show(this,"正在网络请求数据","Loading……");
        new Thread(){
            @Override
            public void run() {
                try{
                    String path=et_nw_url.getText().toString();
                    HttpClient client=new DefaultHttpClient();
                    HttpParams params=client.getParams();
                    HttpConnectionParams.setConnectionTimeout(params,5000);
                    HttpConnectionParams.setSoTimeout(params,5000);
                    HttpPost request=new HttpPost(path);


                    List<BasicNameValuePair> parameters=new ArrayList<>();
                    parameters.add(new BasicNameValuePair("name","kylin2"));
                    parameters.add(new BasicNameValuePair("age","60"));
                    request.setEntity(new UrlEncodedFormEntity(parameters));
                    HttpResponse response=client.execute(request);
                    int code=response.getStatusLine().getStatusCode();
                    if(code==200){
                        final String result=EntityUtils.toString(response.getEntity());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_result.setText(result);
                                dialog.dismiss();
                            }
                        });
                    }
                    client.getConnectionManager().shutdown();

                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }.start();

    }
    public void testVolleyGet (View v){
        final ProgressDialog dialog=ProgressDialog.show(this,"正在网络请求数据","Loading……");
        String path=et_nw_url.getText().toString()+"?name=kylin3&age=30";
        StringRequest request=new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                et_result.setText(s);
                dialog.dismiss();
            }
        },null);
        queue.add(request);
    }
    public void testVolleyPost(View v){
        final ProgressDialog dialog=ProgressDialog.show(this,"正在网络请求数据","Loading……");
        String path=et_nw_url.getText().toString();
        StringRequest request=new StringRequest(Request.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                et_result.setText(s);
                dialog.dismiss();
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("name","kylin");
                map.put("age","5555");
                return map;
            }
        };
        queue.add(request);
    }
}
