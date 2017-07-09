package oracle.huwl.com.blacklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aierxuan on 2017/7/9.
 */

public class PhoneNumDao {
    private static final String TABLE_NAME="phone_num";
    private DBHelper helper;
    public PhoneNumDao(Context context) {
        helper=new DBHelper(context);
    }

    public void add(final PhoneNum phoneNum){
        new DaoUtil(helper){
            @Override
            public void callBack(SQLiteDatabase database) {
                ContentValues values=new ContentValues();
                values.put("num",phoneNum.getNum());
                database.insert(TABLE_NAME,null,values);
            }
        }.option();
    }
    public void delete(final Integer id){
        new DaoUtil(helper){
            @Override
            public void callBack(SQLiteDatabase database) {
                database.delete(TABLE_NAME,"_id=?",new String[]{""+id});
            }
        }.option();
    }
    public void update(final PhoneNum phoneNum){
        new DaoUtil(helper){
            @Override
            public void callBack(SQLiteDatabase database) {
                ContentValues values=new ContentValues();
                values.put("num",phoneNum.getNum());
                database.update(TABLE_NAME,values,"_id=?",new String[]{""+phoneNum.get_id()});
            }
        }.option();
    }
    public List<PhoneNum> queryAll(){
        final List<PhoneNum> list=new ArrayList<>();
        new DaoUtil(helper){
            @Override
            public void callBack(SQLiteDatabase database) {
               Cursor cursor=database.query(TABLE_NAME,new String[]{"_id,num"},null,null,null,null,null);
                while(cursor.moveToNext()){
                    int id=cursor.getInt(0);
                    String num=cursor.getString(1);
                    list.add(new PhoneNum(id,num));
                }
                cursor.close();
            }
        }.option();
        return list;
    }
}
