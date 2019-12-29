package com.kachundena.perfumax;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudanteBaseDeDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "perfumax",
            NOMBRE_TABLA_PERFUMES = "perfumes";
    private static final int VERSION_BASE_DE_DATOS = 1;

    public AyudanteBaseDeDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String szSQL = "CREATE TABLE IF NOT EXISTS %s(" +
                "perfume_id integer primary key autoincrement, " +
                "area integer, " +
                "nombre text, " +
                "marca text, " +
                "opiniones integer, " +
                "lista_deseos integer, " +
                "prioridad integer, " +
                "familia integer, " +
                "acordes text, " +
                "nota_predominante text, " +
                "notas_salida text, " +
                "notas_corazon text, " +
                "notas_fondo text, " +
                "estela integer, " +
                "duracion integer, " +
                "valoracion integer, " +
                "clon text " +
                ");";

        db.execSQL(String.format(szSQL, NOMBRE_TABLA_PERFUMES));

        // MST_OPINIONES
        szSQL = "CREATE TABLE IF NOT EXISTS mst_opiniones " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));
        //szSQL = "INSERT INTO mst_opiniones (codigo, deno) VALUES(1, 'Duradera');";

        // MST_LISTADESEO
        szSQL = "CREATE TABLE IF NOT EXISTS mst_listadeseo " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));

        // MST_FAMILIA
        szSQL = "CREATE TABLE IF NOT EXISTS mst_familia " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));

        // MST_ESTELA
        szSQL = "CREATE TABLE IF NOT EXISTS mst_estela " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));

        // MST_DURACION
        szSQL = "CREATE TABLE IF NOT EXISTS mst_duracion " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));

        // MST_VALORACION
        szSQL = "CREATE TABLE IF NOT EXISTS mst_valoracion " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));

        // MST_AREA
        szSQL = "CREATE TABLE IF NOT EXISTS mst_area " +
                "(codigo integer primary key, deno text);";
        db.execSQL(String.format(szSQL));



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
