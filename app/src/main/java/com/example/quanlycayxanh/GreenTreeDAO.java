package com.example.quanlycayxanh;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class GreenTreeDAO {
    private SQLiteDatabase db;

    public GreenTreeDAO() {
    }

    public GreenTreeDAO(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<GreenTree> get(String sql, String ...selectArgs){
        List<GreenTree> list  = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while(cursor.moveToNext()){
            GreenTree cp = new GreenTree();
            cp.setId(cursor.getString((cursor.getColumnIndex("id"))));
            cp.setTenKhoaHoc(cursor.getString((cursor.getColumnIndex("tenKhoaHoc"))));
            cp.setTenThuongGoi(cursor.getString((cursor.getColumnIndex("tenThuongGoi"))));
            cp.setDatTa(cursor.getString((cursor.getColumnIndex("datTa"))));
            cp.setMauLa(cursor.getString((cursor.getColumnIndex("mauLa"))));
            cp.setHinhAnh(cursor.getInt((cursor.getColumnIndex("datTa"))));
            list.add(cp);

        }
        return list;
    }

    public List<GreenTree> getAllComputer(){
        String sql = "select * from Tree";
        return get(sql);
    }

    public GreenTree getById(String id){
        String sql = "select * from Tree where id = ?";
        List<GreenTree> list = get(sql,id);
        return list.get(0);
    }

    public long insert(GreenTree cm){
        ContentValues values = new ContentValues();
        values.put("id",cm.getId());
        values.put("tenKhoaHoc",cm.getTenKhoaHoc());
        values.put("tenThuongGoi",cm.getTenThuongGoi());
        values.put("datTa",cm.getDatTa());
        values.put("mauLa",cm.getMauLa());

        return db.insert("Computer", null, values);
    }

    public long update(GreenTree cm){
        ContentValues values = new ContentValues();
        values.put("tenKhoaHoc",cm.getTenKhoaHoc());
        values.put("tenThuongGoi",cm.getTenThuongGoi());
        values.put("datTa",cm.getDatTa());
        values.put("mauLa",cm.getMauLa());

        return db.update("Tree", values, "id = ?",new String[]{cm.getId()});
    }

    public int delete(String id){
        return db.delete("Tree","id = ?",new String[]{id});
    }
}
