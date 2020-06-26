/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author Dani Barros
 */
public class Butaca {
    
    private int id_butaca;
    private VerPelicula verPelicula;
    private int fila;
    private int columna;
    private boolean estado;

    public Butaca(){}
    
    public Butaca(VerPelicula pelicula, int fila, int columna, boolean estado) {
        this.verPelicula = pelicula;
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
    }

    public int getId_butaca() {
        return id_butaca;
    }

    public void setId_butaca(int id_butaca) {
        this.id_butaca = id_butaca;
    }

    public VerPelicula getPelicula() {
        return verPelicula;
    }

    public void setPelicula(VerPelicula pelicula){
        this.verPelicula = pelicula;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Butaca{" + "id_butaca=" + id_butaca + ", pelicula=" + verPelicula + ", fila=" + fila + ", columna=" + columna + ", estado=" + estado + '}';
    }
    
    
}
