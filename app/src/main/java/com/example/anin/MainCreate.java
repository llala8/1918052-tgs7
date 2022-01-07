package com.example.anin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ebungkus, Eharga;
    private String Snama, Sbungkus, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ebungkus = (EditText) findViewById(R.id.create_bungkus);
        Eharga = (EditText) findViewById(R.id.create_harga);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sbungkus = String.valueOf(Ebungkus.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama ",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbungkus.equals("")){
                    Ebungkus.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi dibungkus atau tidak",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ebungkus.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMenu (new Menu(null, Snama, Sbungkus, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}