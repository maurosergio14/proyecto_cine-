
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
import java.sql.Time;
import java.time.LocalDate;
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
    
   public void generarTicket(Ticket ticket){
        
        try {
            String sql = "INSERT INTO ticket (id_cliente, id_sala, id_butaca, id_pelicula, fecha_ticket, hora_ticket, monto, estado, metodo_de_pago)VALUES(?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                       
            
            pst.setInt(1,ticket.getCliente().getId_cliente());
            pst.setInt(2,ticket.getSala().getId_sala());
            pst.setInt(3,ticket.getButaca().getId_butaca());
            pst.setInt(4,ticket.getPelicula().getId());
            pst.setDate(5,java.sql.Date.valueOf(ticket.getFecha()));
            pst.setTime(6,Time.valueOf(ticket.getHora()));
            pst.setDouble(7, ticket.getMonto());
            pst.setInt(8, 21);
            pst.setString(9, ticket.getMetodoDePago());
                       
            ResultSet rs = pst.executeQuery();
            
            
        } catch (Exception rs) {
            System.out.println("ERROR al guardar ticket : " + rs);
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
    
   public void modificaTiket(int ticket){
        
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
    
   public void liberarButaca(Sala sala){
        try {
            
        } catch (Exception e) {
            System.out.println("Error al liberar butaca");
        }
        
    }
    List <FuncionVerPelicula> obtenerPeliculaHorario(int idPelicula,int idSala){
        List<FuncionVerPelicula> horarios = new ArrayList<FuncionVerPelicula>();
        
        try {
            PreparedStatement pst = conexion.prepareStatement("select funcionverpelicula from ticket where id_pelicula='"+idPelicula+"' and"
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
    
   public List<Sala> obtenerSalaPelicula(int idSala,int Pelicula){
        return null;  
    }
    
   public List <Ticket> ObtenerClienteFecha(int id_cliente,String fecha){
      List<Ticket> listadeclinetes = new ArrayList<Ticket>();

        try {
            String sql = "SELECT * FROM ticket, WHERE id_cliente='"+id_cliente+"',fecha_ticket='"+fecha+"';";

            PreparedStatement pst = conexion.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

           
            Ticket ticket;

            while (rs.next()) {
               
                ticket=new Ticket();
                ticket.getCliente().setId_cliente(rs.getInt("id_cliente"));//ya lo encontramos
                ticket.setFecha(rs.getString("fecha"));

                listadeclinetes.add(ticket);
            }
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de clientes");
        }
        
        
        return listadeclinetes;  
    }
                                
   public void cantidadTicketPorFecha(String fecha){
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
    
   public void cantidadTicketPorPelicula(int id_pelicula){
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
   List<Sala> obtenerSalaPelicula(Pelicula obPelicula){
        List<Sala> listaSalas = new ArrayList<Sala>();
        
        try {
            PreparedStatement pst = conexion.prepareStatement("select distinctrow id_sala from funcionverpelicula where"
                    + "id_pelicula='"+obPelicula.getId()+"'");
            ResultSet rs = pst.executeQuery();
            Sala salas;
            
            while(rs.next()){
                salas = new Sala();
                salas.setId_sala(rs.getInt("id_sala"));
                listaSalas.add(salas);
            }
            
        } catch (Exception e) {
        }
        return listaSalas;  
    }
}
