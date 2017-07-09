package oracle.huwl.com.appdbdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void createDB(View v){
        DBHelper dbHelper=new DBHelper(this,1);
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Toast.makeText(this,"创建数据库",Toast.LENGTH_SHORT).show();
    }
    public void updateDB(View v){
        DBHelper dbHelper=new DBHelper(this,2);
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Toast.makeText(this,"更新数据库",Toast.LENGTH_SHORT).show();
    }
    public void insert(View v){
        DBHelper dbHelper=new DBHelper(this,2);
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name","kylin");
        values.put("age",12);
        long id=database.insert("person",null,values);
        Toast.makeText(this,"插入数据,id为："+id,Toast.LENGTH_SHORT).show();
        database.close();
    }
    public void update(View v){
        DBHelper helper=new DBHelper(this,2);
        SQLiteDatabase database=helper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("age",50);
        int count=database.update("person",values,"_id=?",new String[]{"4"});
        Toast.makeText(this,"更新数据,数量为："+count,Toast.LENGTH_SHORT).show();
        database.close();

    }
    public void delete(View v){
        DBHelper helper=new DBHelper(this,2);
        SQLiteDatabase database=helper.getReadableDatabase();
        int count=database.delete("person","_id=?",new String[]{"4"});
        Toast.makeText(this,"删除数据,数量为："+count,Toast.LENGTH_SHORT).show();
        database.close();

    }
    public void query(View v){
        DBHelper helper=new DBHelper(this,2);
        SQLiteDatabase database=helper.getReadableDatabase();

        Cursor cursor=database.query("person",null,null,null,null,null,null);
        String result="";
        while(cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex("name"));
            result+=name;
        }

        Toast.makeText(this,"查询数据,结果为："+result,Toast.LENGTH_SHORT).show();
        cursor.close();
        database.close();
    }
    public void testTransaction(View v){
        SQLiteDatabase database=null;
        try{
            DBHelper helper=new DBHelper(this,2);
            database=helper.getReadableDatabase();
            database.beginTransaction();

            ContentValues values=new ContentValues();
            values.put("age",55);
            int count=database.update("person",values,"_id=?",new String[]{"1"});
            Toast.makeText(this,"更新数据,数量为："+count,Toast.LENGTH_SHORT).show();
            boolean flag=false;
            if(flag){
                throw  new RuntimeException("出异常了……");
            }
            count=database.update("person",values,"_id=?",new String[]{"2"});
            Toast.makeText(this,"更新数据,数量为："+count,Toast.LENGTH_SHORT).show();
            database.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            database.endTransaction();
            database.close();
        }
    }
}
