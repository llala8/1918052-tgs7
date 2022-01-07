package com.example.anin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Menu> ListMenu = new ArrayList<Menu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMenu );
        mListView = (ListView) findViewById(R.id.list_barang);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMenu.clear();
        List<Menu> contacts = db.ReadMenu();
        for (Menu cn : contacts) {
            Menu judulModel = new Menu();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bungkus(cn.get_bungkus());
            judulModel.set_harga(cn.get_harga());
            ListMenu.add(judulModel);
            if ((ListMenu.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {

            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Menu obj_itemDetails = (Menu) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sbungkus = obj_itemDetails.get_bungkus();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ibungkus", Sbungkus);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);     }
    @Override
    protected void onResume() {
        super.onResume();
        ListMenu.clear();
        mListView.setAdapter(adapter_off);
        List<Menu> contacts = db.ReadMenu();
        for (Menu cn : contacts) {
            Menu judulModel = new Menu();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bungkus(cn.get_bungkus());
            judulModel.set_harga(cn.get_harga());
            ListMenu.add(judulModel);
            if ((ListMenu.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {

            }
        }
    }
}