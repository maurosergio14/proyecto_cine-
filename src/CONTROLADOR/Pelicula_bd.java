
package CONTROLADOR;

import MODELO.Pelicula;
import java.sql.Connection;
import java.util.List;

/**
 * @author grupo 4
 */
public class Pelicula_bd {
    Connection conex;

    public Pelicula_bd(Connection conex) {
        this.conex = conex;
    }
    
    List<Pelicula>obtenerPelicula(){
        return null;  
    }
    
    void borrarPelicula(int id_pelicula){
        
    }
    
    void actualizarPelicula(Pelicula pelicula){
        
    }
    
    Pelicula buscarPelicula(int id_pelicula){
        return null; 
    }
    
    void guardarPelicula(Pelicula pelicula){
        
    }
    
}
