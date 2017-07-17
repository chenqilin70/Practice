package oracle.huwl.com.providertest;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class PersonProvider extends ContentProvider{
    private static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
    private DBHelper dbHelper;
    static {
        matcher.addURI("oracle.huwl.com.providertest.personprovider","/person",1);
        matcher.addURI("oracle.huwl.com.providertest.personprovider","/person/#",2);
    }
    public PersonProvider() {
        Log.e("test","PersonProvider()……");
    }

    @Override
    public boolean onCreate() {
        Log.e("test","PersonProvider()  onCreate……");
        dbHelper=new DBHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection
            , @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.e("test","PersonProvider()  query……");
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        int code=matcher.match(uri);
        Cursor cursor=null;
        if(code==1){
            cursor=database.query("person",projection,selection,selectionArgs,sortOrder,null,null);
        }else if (code==2){
            long id=ContentUris.parseId(uri);
            cursor=database.query("person",projection,"_id=?",new String[]{id+""},sortOrder,null,null);
        }else{
            throw new RuntimeException("查询的uri不合法");
        }
        return cursor;
    }



    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("test","PersonProvider()  insert……");
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        int code = matcher.match(uri);
        if(code==1){
            long id=database.insert("person",null,contentValues);
            uri=ContentUris.withAppendedId(uri,id);
            database.close();
            return uri;
        }else{
            database.close();
            throw new RuntimeException("插入的uri不合法");
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e("test","PersonProvider()  delete……");
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        int code = matcher.match(uri);
        if(code==1){
            int count=database.delete("person",selection,selectionArgs);
            database.close();
            return count;

        }else if(code==2){
            long id= ContentUris.parseId(uri);
            int count=database.delete("person","_id=?",new String[]{id+""});
            database.close();
            return count;
        }else{
            database.close();
            throw new RuntimeException("插入的uri不合法");
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e("test","PersonProvider()  update……");
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        int code = matcher.match(uri);
        if(code==1){
            int count=database.update("person",values,selection,selectionArgs);
            database.close();
            return count;

        }else if(code==2){
            long id= ContentUris.parseId(uri);
            int count=database.update("person",values,"_id=?",new String[]{id+""});
            database.close();
            return count;
        }else{
            database.close();
            throw new RuntimeException("更新的uri不合法");
        }
    }
}
