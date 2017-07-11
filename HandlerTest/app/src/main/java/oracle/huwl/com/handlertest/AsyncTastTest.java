package oracle.huwl.com.handlertest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTastTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_tast_test);
    }
    public void download(View v){
        new AsyncTask<Void,Integer,Void>(){
            private File apkFile;
            private ProgressDialog dialog;
            @Override
            protected void onPreExecute() {
                dialog=new ProgressDialog(AsyncTastTest.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.show();
                apkFile=new File(getExternalFilesDir(null),"update.apk");
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    URL url = new URL("http://120.24.244.103:8080/AndroidWebServer/1.apk");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    if (connection.getResponseCode() == 200) {
                        dialog.setMax(connection.getContentLength());
                        InputStream in = connection.getInputStream();
                        OutputStream out = new FileOutputStream(apkFile);
                        int len = -1;
                        byte[] buffer = new byte[1024];
                        while ((len = in.read(buffer)) != -1) {
                            out.write(buffer, 0, len);
                            //dialog.incrementProgressBy(len);
                            publishProgress(len);
                        }
                        out.flush();
                        in.close();
                        out.close();
                    }

                    connection.disconnect();
                }catch (Exception e){
                    e.printStackTrace();
                    dialog.dismiss();
                }finally {

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                dialog.dismiss();
                installApk(apkFile);
            }
            private void installApk(File apkFile){
                Intent intent=new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setDataAndType(Uri.fromFile(apkFile),"application/vnd.android.package-archive");
                startActivity(intent);

            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                dialog.incrementProgressBy(values[0]);
            }
        }.execute();
    }

}
