package com.cmf.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String DB_Name = "enc";
    private static final int version  = 1;
    private static final String tabla = "CREATE TABLE ENCUEST (CODIGO TEXT PRIMARY KEY, PROGAMA TEXT, COMPUTADOR TEXT, INTERNET TEXT, SMARTPHONE TEXT)";

    public BaseDatos(Context context) {
        super(context, DB_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ tabla);
        db.execSQL(tabla);
    }



    public Cursor allEnc() {
        try {
            SQLiteDatabase bd = getReadableDatabase();
            Cursor cur = bd.rawQuery("SELECT CODIGO AS _id , PROGAMA, COMPUTADOR, INTERNET FROM ENCUEST", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public boolean buscarEnc(String cod){
        String[] args = new String[] {cod};
        SQLiteDatabase bd = getReadableDatabase();
        Cursor c = bd.query("ENCUEST", null, "CODIGO=?", args, null, null, null);
        if (c.getCount()>0) {
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;}
    }

    public boolean eliminar (String a){
        try{
            SQLiteDatabase bd = getWritableDatabase();
            String[] args = new String[] {a};
            bd.delete("ENCUEST", "CODIGO=?",args);
            bd.close();
            return true;
        }
        catch (Exception ex){
            System.out.println("Error al eliminar.");
            return false;
        }
    }


    public boolean actualizarEnc(String a, String b, String c, String d, String e){
        try{
            SQLiteDatabase bd = getWritableDatabase();
            ContentValues valores = new ContentValues();
            String[] args = new String[] {a};
            valores.put("PROGAMA", b);
            valores.put("COMPUTADOR", c);
            valores.put("INTERNET", d);
            valores.put("SMARTPHONE", e);
            bd.update("ENCUEST", valores,"CODIGO=?",args);
            bd.close();
            return true;
        }
        catch (Exception ex){
            System.out.println("Error al actualizar");
            return false;
        }

    }

    public void agregarEnc(Enc e){
        try {
            SQLiteDatabase bd = getWritableDatabase();
            if (bd != null) {
                bd.execSQL("INSERT INTO ENCUEST VALUES('"+ e.getCodigo()+"', '"+ e.getPrograma()+"', '"+ e.getComputador()+"', '"+ e.getInternet()+"', '"+ e.getSmartphone()+"')");
                bd.close();
            }
        }catch (Exception ex){
            System.out.println("Error al insertar");
        }
    }

}
