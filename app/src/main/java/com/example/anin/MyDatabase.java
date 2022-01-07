package com.example.anin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_gudang";
    private static final String tb_menu = "tb_menu";
    private static final String tb_menu_id = "id";
    private static final String tb_menu_nama = "nama";
    private static final String tb_menu_bungkus = "bungkus";
    private static final String tb_menu_harga = "harga";
    private static final String CREATE_TABLE = "CREATE TABLE " +
            tb_menu + "("
            + tb_menu_id + " INTEGER PRIMARY KEY ,"
            + tb_menu_nama + " TEXT,"
            + tb_menu_bungkus + " TEXT,"
            + tb_menu_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);     }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {      }
    public void CreateMenu (Menu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_menu_id, mdNotif.get_id());
        values.put(tb_menu_nama, mdNotif.get_nama());
        values.put(tb_menu_bungkus, mdNotif.get_bungkus());
        values.put(tb_menu_harga, mdNotif.get_harga());
        db.insert(tb_menu, null, values);
        db.close();
    }
    public List<Menu> ReadMenu() {
        List<Menu> judulModelList = new ArrayList<Menu>();
        String selectQuery = "SELECT * FROM " + tb_menu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Menu mdKontak = new Menu();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_bungkus(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateMenu (Menu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_menu_nama, mdNotif.get_nama());
        values.put(tb_menu_bungkus, mdNotif.get_bungkus());
        values.put(tb_menu_harga, mdNotif.get_harga());
        return db.update(tb_menu, values, tb_menu_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteMenu (Menu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_menu, tb_menu_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}