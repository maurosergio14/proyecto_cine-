
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.Ticket;
import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        
        try {
            
            PreparedStatement pst = conexion.prepareStatement("insert into ticket values(?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, "0");
            
            Cliente idCliente = ticket.getCliente();
            pst.setInt(2, idCliente.getId_cliente());
            
            Pelicula idPelicula = ticket.getPelicula();
            pst.setInt(3, idPelicula.getId());
            
            Butaca idButaca = ticket.getButaca();
            pst.setInt(4, idButaca.getId_butaca());
            
            //pst.setString(5, ticket.getFecha());
            //pst.setString(6, ticket.getHora());
            pst.setDouble(7, ticket.getMonto());
            pst.setInt(8, 21);
            pst.setString(9, ticket.getMetodoDePago());
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("ERROR"+e);
        }
    }
                        
    void borrarTicket(int ticket){
        try {
            
            int ID = ticket;
            PreparedStatement pst = conexion.prepareStatement("delete from ticket where id_ticket = ?");
            pst.setInt(1, ID);
            pst.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error al eliminar");
        }
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
