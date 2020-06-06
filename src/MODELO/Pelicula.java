
package MODELO;

/**
 * @author grupo 4
 */
public class Pelicula {
   private int id_pelicula;
   private String titulo;
   private String genero;
   private String duracion;
   private String autor;
   private String idioma;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, String duracion, String autor, String idioma) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.autor = autor;
        this.idioma = idioma;
    }

    public int getId() {
        return id_pelicula;
    }

    public void setId(int id_pelicula) {
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id_pelicula + ", titulo=" + titulo + ", duracion=" + duracion + '}';
    }
    
    
   
}
