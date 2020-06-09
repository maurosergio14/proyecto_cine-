
package CONTROLADOR;

import MODELO.Sala;
import java.sql.Connection;
import java.util.List;

/**
 * @author grupo 4
 */
public class Sala_bd {
    Connection conex;

    public Sala_bd(Connection conex) {
        this.conex = conex;
    }
    
    void guardarSala(Sala sala){
        
    }
    
    void actualizarSala(Sala sala){
        
    }
    
    void borrarSala(int id_sala){
        
    }
    
    Sala buscarSala(int id_sala){
        return null;   
    }
    
    List<Sala>obtenerSala(){
        return null;
    }
    
}
