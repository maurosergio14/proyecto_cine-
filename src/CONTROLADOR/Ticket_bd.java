
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.FuncionVerPelicula;
import MODELO.Ticket;
import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public void generarTicket(Ticket ticket){
        
        try {
            PreparedStatement pst = conexion.prepareStatement("insert into ticket values(?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, "0");
            Cliente idCliente = ticket.getCliente();
            pst.setInt(2, idCliente.getId_cliente());
            Pelicula idPelicula = ticket.getPelicula();
            pst.setInt(3, idPelicula.getId());
            Butaca idButaca = ticket.getButaca();
            pst.setInt(4, idButaca.getId_butaca());
            pst.setInt(5, ticket.getFecha1());
            pst.setInt(6, ticket.getHora1());
            pst.setDouble(7, ticket.getMonto());
            pst.setInt(8, 21);
            pst.setString(9, ticket.getMetodoDePago());
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("ERROR"+e);
        }
        
    }
   public void borrarTicket(int ticket){
        try {
            
            int ID = ticket;
            PreparedStatement pst = conexion.prepareStatement("delete from ticket where id_ticket = ?");
            pst.setInt(1, ID);
            pst.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error al eliminar");
        }
    }
    
   public  void modificaTiket(int ticket){
     
    }
    
   public  void liberarButaca(Sala sala){
        
    }
   public List <Pelicula> obtenerPeliculaHorario(int idPelicula,int idSala){
        return null;
    }
    
  public  List<Sala> obtenerSalaPelicula(int idSala,int Pelicula){
        return null;  
    }
    
   public List <Ticket> ObtenerClienteFecha(int id_cliente,String fecha){
      List<Ticket> listadeclinetes = new ArrayList<Ticket>();

        try {
            String sql = "SELECT * FROM ticket, WHERE id_cliente="+id_cliente+",fecha_ticket="+fecha+";";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

           
            Ticket ticket;

            while (rs.next()) {
               
                ticket=new Ticket();
               // ticket.setCliente(rs.getInt(id_cliente));//no encuentro el error
                ticket.setFecha(rs.getDate(fecha));

                listadeclinetes.add(ticket);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de clientes");
        }
        
        
        return null;  
    }
                                
  public  void cantidadTicketPorFecha(String fecha){
       Ticket ticketporfechas = null;
        try {
            String sql = "SELECT * FROM ticket WHERE fecha_ticket=?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1,fecha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ticketporfechas = new Ticket();
                ticketporfechas.setId_ticket(rs.getInt("id_verPelicula"));
                
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion ver Pelicula" + ex.getMessage());
        }

    }
    
  public  void cantidadTicketPorPelicula(int id_pelicula){
        Ticket ticketporpelicula = null;
        try {
            String sql = "SELECT * FROM ticket WHERE id_pelicula=?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,id_pelicula);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ticketporpelicula = new Ticket();
                ticketporpelicula.setId_ticket(rs.getInt("id_verPelicula"));
                
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion ver Pelicula" + ex.getMessage());
        }
    }
}
