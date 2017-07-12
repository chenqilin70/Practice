package oracle.huwl.com.productshower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aierxuan on 2017/7/11.
 */

public class ImageLoader {
    private Context conext;
    private Map<String , Bitmap> cacheMap=new HashMap<>();

    public ImageLoader(Context conext) {
        this.conext = conext;
    }

    public void loadImage(String imagePath, ImageView imageView) {
        Bitmap bitmap=getFromFirstCache(imagePath);
        if(bitmap!=null){
            imageView.setImageBitmap(bitmap);
            return;
        }else{
            bitmap=getFromSecondCache(imagePath);
            if(bitmap!=null){
                cacheMap.put(imagePath,bitmap);
                imageView.setImageBitmap(bitmap);
                return;
            }else{
                bitmap=getFromThirdCache(imagePath,imageView);
            }

        }
    }

    private Bitmap getFromThirdCache(final String imagePath, final ImageView imageView) {
        new AsyncTask<Void,Void,Bitmap>(){
            @Override
            protected void onPreExecute() {
                imageView.setImageResource(R.drawable.loadiing);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap=null;
                HttpURLConnection connection=null;
                InputStream in=null;
                try{
                    URL url=new URL(imagePath);
                    Log.e("test",imagePath);
                    connection= (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    if(connection.getResponseCode()==200){
                        in=connection.getInputStream();
                        bitmap=BitmapFactory.decodeStream(in);
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
                        }
                    }
                }
                if(bitmap!=null){
                    cacheMap.put(imagePath,bitmap);
                    String files=conext.getExternalFilesDir(null).getAbsolutePath();
                    String fileName=imagePath.substring(imagePath.lastIndexOf("/")+1);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(new File(files+"/"+fileName)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if(bitmap==null){
                    imageView.setImageResource(R.drawable.error);
                }else{
                    imageView.setImageBitmap(bitmap);
                }

            }
        }.execute();
        return null;
    }

    private Bitmap getFromSecondCache(String imagePath) {
        String files=conext.getExternalFilesDir(null).getAbsolutePath();
        String fileName=imagePath.substring(imagePath.lastIndexOf("/")+1);
        return BitmapFactory.decodeFile(files+"/"+fileName);
    }

    private Bitmap getFromFirstCache(String imagePath) {
        return cacheMap.get(imagePath);
    }
}
