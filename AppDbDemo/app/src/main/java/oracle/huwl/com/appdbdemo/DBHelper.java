package oracle.huwl.com.appdbdemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aierxuan on 2017/7/9.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context,int version) {
        super(context, "oracle.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("tag","onCreate running……");
        String sql="create table person( _id integer primary key autoincrement, name varchar, age int )";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL("insert into person(name,age) values ('tom1',11)");
        sqLiteDatabase.execSQL("insert into person(name,age) values ('tom2',22)");
        sqLiteDatabase.execSQL("insert into person(name,age) values ('tom3',33)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("tag","onUpgrade running……");
    }
}
