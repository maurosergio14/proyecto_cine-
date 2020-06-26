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
public class Pelicula {
    
   private int id_pelicula;
   private String titulo;
   private String genero;
   private String idioma;

    public Pelicula(){}
   
    public Pelicula(String titulo, String genero, String idioma) {
        this.titulo = titulo;
        this.genero = genero;
        this.idioma = idioma;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", idioma=" + idioma + '}';
    }
   
   
}
