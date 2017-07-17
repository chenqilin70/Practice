package oracle.huwl.com.resolvertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void insert(View v){
        Uri uri=Uri.parse("content://oracle.huwl.com.providertest.personprovider/person");
        ContentValues values=new ContentValues();
        values.put("name","jack");
        Uri newUri=getContentResolver().insert(uri,values);
        Toast.makeText(this,""+newUri.toString(),Toast.LENGTH_SHORT).show();
    }
    public void update(View v){
        Uri uri=Uri.parse("content://oracle.huwl.com.providertest.personprovider/person/2");
        ContentValues values=new ContentValues();
        values.put("name","jack222");
        int updateCount=getContentResolver().update(uri,values,null,null);
        Toast.makeText(this,updateCount+"",Toast.LENGTH_LONG).show();
    }
    public void delete(View v){
        Uri uri=Uri.parse("content://oracle.huwl.com.providertest.personprovider/person/2");
        int deleteCount=getContentResolver().delete(uri,null,null);
        Toast.makeText(this,deleteCount+"",Toast.LENGTH_LONG).show();
    }
    public void query(View v){
        Uri uri=Uri.parse("content://oracle.huwl.com.providertest.personprovider/person");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        String result="";
        while(cursor.moveToNext()){
            result+="id:"+cursor.getInt(0)+"\tname:"+cursor.getString(1)+"\n";
        }
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        cursor.close();
    }
}
