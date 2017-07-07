package oracle.huwl.com.storage;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IFActivity extends Activity {
    private ImageView  iv_if;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if);
        iv_if=findViewById(R.id.iv_if);
    }
    public void save(View v) throws Exception {
        AssetManager manager=getAssets();
        InputStream open=manager.open("default.jpg");
        ToastUtil.showDefaultToast(this,open==null?true+"":false+"");
        OutputStream outputStream=openFileOutput("default.jpg", Context.MODE_PRIVATE);
        byte[] byteArr=new byte[1024];
        int len=0;
        while ((len=open.read(byteArr))!=-1){
            outputStream.write(byteArr,0,len);
        }
        open.close();
        outputStream.flush();
        outputStream.close();
        ToastUtil.showDefaultToast(this,"图片传输完成");
    }
    public void read(View v){
        String filesPath=getFilesDir().getAbsolutePath();
        String imagePath=filesPath+"/default.jpg";
        Bitmap bitmap=BitmapFactory.decodeFile(imagePath);
        iv_if.setImageBitmap(bitmap);

    }
}
