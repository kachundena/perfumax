package com.kachundena.perfumax;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.kachundena.perfumax.modelos.Perfume;

public class AdaptadorPerfumes extends RecyclerView.Adapter<AdaptadorPerfumes.MyViewHolder> {

    private List<Perfume> listaDePerfumes;

    public void setListaDePerfumes(List<Perfume> listaDePerfumes) {

        this.listaDePerfumes = listaDePerfumes;
    }

    public AdaptadorPerfumes(List<Perfume> perfumes) {

        this.listaDePerfumes = perfumes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaTask = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_perfume, viewGroup, false);
        return new MyViewHolder(filaTask);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        // Obtener la tarea de nuestra lista gracias al índice i
        Perfume perfume = listaDePerfumes.get(i);

        // Obtener los datos de la lista
        int perfume_id = perfume.getPerfume_id();
        int area = perfume.getArea();
        String nombre = perfume.getNombre();
        String marca = perfume.getMarca();

        // Y poner a los TextView los datos con setText
        myViewHolder.nombre.setText(nombre);
        myViewHolder.marca.setText(marca);
    }

    @Override
    public int getItemCount() {
        return listaDePerfumes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, marca;

        MyViewHolder(View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.tvNombre);
            this.marca = itemView.findViewById(R.id.tvMarca);
        }
    }
}
