package oracle.huwl.com.appdownloaddemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void download(View v){
        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        final File apkFile=new File(getExternalFilesDir(null),"update.apk");
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url=new URL("http://120.24.244.103:8080/AndroidWebServer/1.apk");
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    if(connection.getResponseCode()==200){
                        dialog.setMax(connection.getContentLength());
                        InputStream in=connection.getInputStream();
                        OutputStream out=new FileOutputStream(apkFile);
                        int len=-1;
                        byte[] buffer=new byte[1024];
                        while ((len=in.read(buffer))!=-1){
                            out.write(buffer , 0 ,len);
                            dialog.incrementProgressBy(len);
                        }
                        out.flush();
                        in.close();
                        out.close();
                    }

                    connection.disconnect();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            installApk(apkFile);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }
            }
        }.start();
    }
    private void installApk(File apkFile){
        Intent intent=new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setDataAndType(Uri.fromFile(apkFile),"application/vnd.android.package-archive");
        startActivity(intent);

    }
}
