
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
import java.util.Date;
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
        
        try {
            
            //tomar valores de la vista
            int idTicketControl=ticket;
            int idPeliculaControl=22;
            int idButacaControl=55;
            int fechaControl=2020;
            int horaControl=22;
            String estadoControl="MODIFICADO";
            String metodoPagoControl="VISA";
            Double precioControl=44.99;
            //tomar valores de la vista
            
            PreparedStatement pst = conexion.prepareStatement("update ticket set id_butaca='"+idButacaControl+"',"
                    + "fecha_ticket='"+fechaControl+"', hora_ticket='"+horaControl+"', monto='"+precioControl+"', estado='"
                    +estadoControl+"', 	metodo_de_pago='"+metodoPagoControl+"' where id_ticket='"+idTicketControl+"'");
            pst.executeUpdate();
       
        } catch (Exception e) {
            System.out.println("Error al querer modificar");
        }
    }
    
    void liberarButaca(Sala sala){
        try {
            
        } catch (Exception e) {
            System.out.println("Error al liberar butaca");
        }
        
    }
    List <FuncionVerPelicula> obtenerPeliculaHorario(int idPelicula,int idSala){
        List<FuncionVerPelicula> horarios = new ArrayList<FuncionVerPelicula>();
        
        try {
            PreparedStatement pst = conexion.prepareStatement("select funcionverpelicula from ticket "
                    + "where id_pelicula='"+idPelicula+"' and"
                    + " id_sala='"+idSala+"'");
            
            ResultSet rs = pst.executeQuery();
                 
            FuncionVerPelicula horas;
            
            while(rs.next()){
                horas=new FuncionVerPelicula();
                
                horas.setHorario_desde(rs.getTime("horario_desde"));
                
                horarios.add(horas);
            }
            pst.close();
            
        } catch (Exception e) {
             System.out.println("Error al mostrar");
        }
        
        return horarios;
    }
    
    List<Sala> obtenerSalaPelicula(int idSala,int Pelicula){
        return null;  
    }
    
    List <Ticket> ObtenerClienteFecha(int id_cliente,String fecha){
      List<Ticket> listadeclinetes = new ArrayList<Ticket>();

        try {
            String sql = "SELECT * FROM ticket, WHERE id_cliente="+id_cliente+",fecha_ticket="+fecha+";";

            PreparedStatement pst = conexion.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

           
            Ticket ticket;

            while (rs.next()) {
               
                ticket=new Ticket();
                ticket.getCliente().setId_cliente(rs.getInt(id_cliente));//ya lo encontramos
                ticket.setFecha(rs.getDate(fecha));

                listadeclinetes.add(ticket);
            }
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de clientes");
        }
        
        
        return null;  
    }
                                
    void cantidadTicketPorFecha(String fecha){
       Ticket ticketporfechas = null;
        try {
            String sql = "SELECT * FROM ticket WHERE fecha_ticket=?;";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1,fecha);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ticketporfechas = new Ticket();
                ticketporfechas.setId_ticket(rs.getInt("id_verPelicula"));
                
            }
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion ver Pelicula" + ex.getMessage());
        }

    }
    
    void cantidadTicketPorPelicula(int id_pelicula){
        Ticket ticketporpelicula = null;
        try {
            String sql = "SELECT * FROM ticket WHERE id_pelicula=?;";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1,id_pelicula);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ticketporpelicula = new Ticket();
                ticketporpelicula.setId_ticket(rs.getInt("id_verPelicula"));
                
            }
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion ver Pelicula" + ex.getMessage());
        }
    }
}
