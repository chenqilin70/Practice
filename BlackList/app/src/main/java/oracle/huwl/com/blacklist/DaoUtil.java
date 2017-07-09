package oracle.huwl.com.blacklist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by aierxuan on 2017/7/9.
 */

public class DaoUtil {
    private DBHelper helper;
    public DaoUtil(DBHelper helper) {
        this.helper = helper;
    }
    public void option(){
        SQLiteDatabase database=helper.getReadableDatabase();
        System.out.println(database+"<--");
        try{
            callBack(database);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database!=null){
                database.close();
            }
        }
    }
    public void transactionOption(){
        SQLiteDatabase database=null;
        try{
            database=helper.getReadableDatabase();
            database.beginTransaction();
            callBack(database);
            database.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database!=null){
                database.endTransaction();
                database.close();
            }
        }
    }
    public void callBack(SQLiteDatabase database){

    }
}
