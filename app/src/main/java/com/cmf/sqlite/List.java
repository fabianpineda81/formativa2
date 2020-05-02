package com.cmf.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class List extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = (ListView) findViewById(R.id.list);
        final BaseDatos BaseDatos = new BaseDatos(getApplicationContext());

        Cursor encuestas = BaseDatos.allEnc();
        personalizado p = new personalizado(this,encuestas, 0);
        lista.setAdapter(p);
        p.notifyDataSetChanged();
    }
}
