package oracle.huwl.com.providertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/16.
 */

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context) {
        super(context, "oracle.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("test","onCreate……");
        sqLiteDatabase.execSQL("create table person(_id integer primary key autoincrement,name varchar)");
        sqLiteDatabase.execSQL("insert into person(name) values('Tom')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
