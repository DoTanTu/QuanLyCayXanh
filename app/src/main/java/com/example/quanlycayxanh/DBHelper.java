package com.example.quanlycayxanh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "GreenTree_Management";
    public static final int DB_Version = 1;


    public DBHelper(Context context){
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql  = "CREATE TABLE Tree(" +
                "id text primary key," +
                "tenKhoaHoc text not null," +
                "tenThuongGoi text not null," +
                "datTa text not null," +
                "mauLa text not null" +
                ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Tree";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
