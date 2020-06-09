
package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.Ticket;
import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.util.List;

/**
 * @author grupo 4
 */
public class Ticket_bd {
   Connection conexion;

    public Ticket_bd(Conexion conexion) {
        this.conexion= (Connection) conexion;
        
    }
    
    void generarTicket(Ticket ticket){
        
    }
                        
    void borrarTicket(int ticket){
        
    }
    
    void modificaTiket(int ticket){
        
    }
    
    void liberarButaca(Sala sala){
        
    }
    List <Pelicula> obtenerPeliculaHorario(int idPelicula,int idSala){
        return null;
    }
    
    List<Sala> obtenerSalaPelicula(int idSala,int Pelicula){
        return null;  
    }
    
    List <Cliente> ObtenerClienteFecha(int dni,String fecha){
        return null;  
    }
                                
    void cantidadTicketPorFecha(int ticket,String fecha){
      
    }
    
    void cantidadTicketPorPelicula(int ticket,int id_pelicula){
        
    }
}
