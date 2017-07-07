package oracle.huwl.com.storage;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class OFActivity extends Activity {
    private EditText et_of_filename,et_of_filecontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of);
        et_of_filename=findViewById(R.id.et_of_filename);
        et_of_filecontent=findViewById(R.id.et_of_filecontent);
    }
    public void save(View v) throws Exception {
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            String filename=et_of_filename.getText().toString();
            String filecontent=et_of_filecontent.getText().toString();
            String filesDirPath=getExternalFilesDir(null).getAbsolutePath();
            String filePath=filesDirPath+"/"+filename;
            OutputStream outputStream=new FileOutputStream(filePath);
            outputStream.write(filecontent.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
            ToastUtil.showDefaultToast(this,"保存成功！");
        }else{
            ToastUtil.showDefaultToast(this,"sd卡没有挂载！");
        }
    }
    public void read(View v) throws Exception {
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            String filename=et_of_filename.getText().toString();
            String filesDirPath=getExternalFilesDir(null).getAbsolutePath();
            String filePath=filesDirPath+"/"+filename;
            InputStream inputStream=new FileInputStream(filePath);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String s=reader.readLine();
            et_of_filecontent.setText(s);
        }else{
            ToastUtil.showDefaultToast(this,"sd卡没有挂载！");
        }
    }
    public void save2(View v) throws Exception {
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            String filename=et_of_filename.getText().toString();
            String filecontent=et_of_filecontent.getText().toString();
            File filesDir=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/oracle");
            Log.e("test",Environment.getExternalStorageDirectory().getAbsolutePath());
            if(!filesDir.exists()){
                boolean flag=filesDir.mkdirs();
                Log.e("test","创建成功与否："+flag);
            }
            Log.e("test",filesDir.exists()+"");
            String filePath=filesDir.getAbsolutePath()+"/"+filename;
            OutputStream outputStream=new FileOutputStream(filePath);
            outputStream.write(filecontent.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
            ToastUtil.showDefaultToast(this,"保存成功！");
        }else{
            ToastUtil.showDefaultToast(this,"sd卡没有挂载！");
        }


    }
    public void read2(View v) throws Exception {
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            String filename=et_of_filename.getText().toString();
            String filesDirPath=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/oracle").getAbsolutePath();
            String filePath=filesDirPath+"/"+filename;
            InputStream inputStream=new FileInputStream(filePath);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String s=reader.readLine();
            et_of_filecontent.setText(s);
        }else{
            ToastUtil.showDefaultToast(this,"sd卡没有挂载！");
        }
    }
}
