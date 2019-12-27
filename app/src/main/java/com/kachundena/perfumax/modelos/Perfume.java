package com.kachundena.perfumax.modelos;

import java.util.Date;


public class Perfume {
    private int perfume_id;
    private int area;
    private String nombre;
    private String marca;
    private int opiniones;
    private int lista_deseos;
    private int prioridad;
    private int familia;
    private String acordes;
    private String nota_predominante;
    private String notas_salida;
    private String notas_corazon;
    private String notas_fondo;
    private int estela;
    private int duracion;
    private int valoracion;
    private String clon;

    public Perfume() {
    }

    public int getPerfume_id() {
        return perfume_id;
    }

    public void setPerfume_id(int perfume_id) {
        this.perfume_id = perfume_id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(int opiniones) {
        this.opiniones = opiniones;
    }

    public int getLista_deseos() {
        return lista_deseos;
    }

    public void setLista_deseos(int lista_deseos) {
        this.lista_deseos = lista_deseos;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public String getAcordes() {
        return acordes;
    }

    public void setAcordes(String acordes) {
        this.acordes = acordes;
    }

    public String getNota_predominante() {
        return nota_predominante;
    }

    public void setNota_predominante(String nota_predominante) {
        this.nota_predominante = nota_predominante;
    }

    public String getNotas_salida() {
        return notas_salida;
    }

    public void setNotas_salida(String notas_salida) {
        this.notas_salida = notas_salida;
    }

    public String getNotas_corazon() {
        return notas_corazon;
    }

    public void setNotas_corazon(String notas_corazon) {
        this.notas_corazon = notas_corazon;
    }

    public String getNotas_fondo() {
        return notas_fondo;
    }

    public void setNotas_fondo(String notas_fondo) {
        this.notas_fondo = notas_fondo;
    }

    public int getEstela() {
        return estela;
    }

    public void setEstela(int estela) {
        this.estela = estela;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getClon() {
        return clon;
    }

    public void setClon(String clon) {
        this.clon = clon;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
