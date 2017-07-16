package oracle.huwl.com.resolvertest;

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

    }
    public void update(View v){

    }
    public void delete(View v){

    }
    public void query(View v){
        Uri uri=Uri.parse("content://oracle.huwl.com.providertest.personprovider/person/1");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            Toast.makeText(this,id+","+name,Toast.LENGTH_LONG).show();
        }
    }
}
