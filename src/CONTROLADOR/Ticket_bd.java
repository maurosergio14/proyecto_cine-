
package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.Ticket;
import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author grupo 4
 */
 public class Ticket_bd {
   private Connection conexion;
   
    public Ticket_bd(){
    }

    public Ticket_bd(Conexion conexion) {
               this.conexion= conexion.getConex();
           try {
               this.conexion= conexion.getConex();
        } catch (Exception ex) {
            System.out.println("Error al obtener la conexion" + ex.getMessage());
        }
    }
    
    void generarTicket(Ticket ticket) throws SQLException{
         String sql = "INSERT INTO ticket ('id_ticket', 'id_cliente', 'id_verPelicula', 'id_butaca', 'fecha_ticket', 'hora_ticket', 'monto', 'estado', 'metodo_de_pago') VALUE (?,?,?,?,?,?,?,?,?)";
         PreparedStatement PS = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
         PS.setInt(1, ticket.getId_ticket());
         PS.setInt(2, ticket.getCliente().getDni());
         PS.setInt(3, ticket.getPelicula().getId());
         PS.setInt(4, ticket.getButaca().getId_butaca());
         PS.setDate(5, ticket.getFecha());
         PS.setDate(6, ticket.getHora());
         PS.setDouble(7, ticket.getmonto());
         PS.setBoolean(8, ticket.estado());
         PS.setString(9, ticket.pago());
         
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
