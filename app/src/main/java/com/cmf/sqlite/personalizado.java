package com.cmf.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class personalizado extends android.widget.CursorAdapter {
    public personalizado(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.dato_est, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView codigo = (TextView) view.findViewById(R.id.TXTcodigo);
        TextView programa = (TextView) view.findViewById(R.id.TXTprograma);
        TextView computador = (TextView) view.findViewById(R.id.TXTinternet);
        // Extract properties from cursor
        String cod = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String programaa = cursor.getString(cursor.getColumnIndexOrThrow("PROGAMA"));
        String computador1 = cursor.getString(cursor.getColumnIndexOrThrow("COMPUTADOR"));
        // Populate fields with extracted properties
        codigo.setText("No. " + cod);
        programa.setText("Ing. " + programaa);
        computador.setText("Tiene computador: " + computador1);

    }
}
