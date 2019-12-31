package com.kachundena.perfumax.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.kachundena.perfumax.AyudanteBaseDeDatos;
import com.kachundena.perfumax.modelos.Perfume;

public class PerfumesController {
    private AyudanteBaseDeDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "perfumes";

    public PerfumesController(Context contexto) {
        ayudanteBaseDeDatos = new AyudanteBaseDeDatos(contexto);
    }


    public int eliminarPerfume(Perfume perfume) {

        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        String[] argumentos = {String.valueOf(perfume.getPerfume_id())};
        return baseDeDatos.delete(NOMBRE_TABLA, "perfume_id = ?", argumentos);
    }

    public int eliminarAllPerfumes() {

        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        return baseDeDatos.delete(NOMBRE_TABLA, null, null);
    }

    public long nuevoPerfume(Perfume perfume) {
        // writable porque vamos a insertar
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("nombre", perfume.getNombre());
        valoresParaInsertar.put("marca", perfume.getMarca());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int guardarCambios(Perfume perfumeEditado) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("nombre", perfumeEditado.getNombre());
        valoresParaActualizar.put("marca", perfumeEditado.getMarca());
        // where id...
        String campoParaActualizar = "perfume_id = ?";
        //
        String[] argumentosParaActualizar = {String.valueOf(perfumeEditado.getPerfume_id())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);
    }

    public Perfume obtenerPerfume(int perfumeid) {
        Perfume perfume = null;
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT deno, detalle, perfume_id
        String[] columnasAConsultar = {"nombre", "marca", "perfume_id"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                "perfume_id=?",
                new String[] { String.valueOf(perfumeid) },
                null,
                null,
                null
        );

        if (cursor == null) {
            /*
                Salimos aquí porque hubo un error, regresar
                lista vacía
             */
            return perfume;

        }
        // Si no hay datos, igualmente regresamos la lista vacía
        if (!cursor.moveToFirst()) return perfume;

        // En caso de que sí haya, iteramos y vamos agregando los
        // datos a la lista de tasks
        do {
            // El 0 es el número de la columna, como seleccionamos
            // deno, detalle,task_id entonces el deno es 0, detalle 1 e task_id es 2
            String nombreObtenidoDeBD = cursor.getString(0);
            String marcaObtenidaDeBD = cursor.getString(1);
            //int perfumeid = cursor.getInt(2);
            Perfume perfumeObtenidaDeBD = new Perfume(perfumeid, nombreObtenidoDeBD, marcaObtenidaDeBD);
            perfume = perfumeObtenidaDeBD;
        } while (cursor.moveToNext());

        // Fin del ciclo. Cerramos cursor y regresamos la lista de tasks :)
        cursor.close();
        return perfume;
    }

    public ArrayList<Perfume> obtenerPerfumes() {
        ArrayList<Perfume> perfumes = new ArrayList<>();
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT deno, detalle, perfume_id
        String[] columnasAConsultar = {"perfume_id","area","nombre","marca",
            "opiniones","lista_deseos","prioridad","familia","acordes",
            "nota_predominante","notas_salida","notas_corazon","notas_fondo",
            "estela","duracion","valoracion","clon"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            /*
                Salimos aquí porque hubo un error, regresar
                lista vacía
             */
            return perfumes;

        }
        // Si no hay datos, igualmente regresamos la lista vacía
        if (!cursor.moveToFirst()) return perfumes;

        // En caso de que sí haya, iteramos y vamos agregando los
        // datos a la lista de tasks
        do {
            // El 0 es el número de la columna, como seleccionamos
            // deno, detalle,task_id entonces el deno es 0, detalle 1 e task_id es 2
            String nombreObtenidoDeBD = cursor.getString(2);
            String marcaObtenidaDeBD = cursor.getString(3);
            int perfumeid = cursor.getInt(0);
            Perfume perfumeObtenidaDeBD = new Perfume(perfumeid, nombreObtenidoDeBD, marcaObtenidaDeBD);
            perfumes.add(perfumeObtenidaDeBD);
        } while (cursor.moveToNext());

        // Fin del ciclo. Cerramos cursor y regresamos la lista de tasks :)
        cursor.close();
        return perfumes;
    }
}