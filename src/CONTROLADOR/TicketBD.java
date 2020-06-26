/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Pelicula;
import MODELO.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani Barros
 */
public class TicketBD {
    
    private Connection conex;

    public TicketBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en TicketBD");
        }
    }
    
    public void guardarTicket(Ticket ticket) {
        try {

            String instrucciones = "INSERT INTO ticket (id_cliente, id_sala, id_butaca, id_pelicula, "
                    + "fecha_ticket, hora_ticket, monto, estado, metodo_de_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ticket.getCliente());
            ps.setInt(2, ticket.getSala());
            ps.setInt(3, ticket.getButaca());
            ps.setInt(4, ticket.getVerPelicula());
            ps.setString(5, ticket.getFecha());
            ps.setString(6, ticket.getHora());
            ps.setDouble(7, ticket.getMonto());
            ps.setBoolean(8, ticket.getEstado());
            ps.setString(9, ticket.getMetodoDePago());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                ticket.setId_ticket(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id del ticket luego de intentar generarlo");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar ticket"+e);
        }
    }
    
    public void borrarTicket(int id){
        try {
            
            String instrucciones = "DELETE FROM ticket WHERE id_ticket = ?;";
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer borrar el ticket");
        }
    }
    
    public void modificarTicket(Ticket ticket){
        try {
            
            String instrucciones = "UPDATE ticket SET fecha_ticket=?, hora_ticket=?, monto=?, estado=?, metodo_de_pago=?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setString(1, ticket.getFecha());
            ps.setString(2, ticket.getHora());
            ps.setDouble(3, ticket.getMonto());
            ps.setBoolean(4, ticket.getEstado());
            ps.setString(5, ticket.getMetodoDePago());
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar la Pelicula "+ticket.getId_ticket());
        }
    }
    
    public List<Ticket> obtenerTicketsXpeli(int id){
        List<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            String instrucciones = "SELECT * FROM ticket where id_pelicula = "+id;
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Ticket ticket;
            
            while(resultSet.next()){
                ticket = new Ticket();
                ticket.setId_ticket(resultSet.getInt("id_ticket"));
                ticket.setCliente(resultSet.getInt("id_cliente"));
                ticket.setSala(resultSet.getInt("id_sala"));
                ticket.setButaca(resultSet.getInt("id_butaca"));
                ticket.setVerPelicula(resultSet.getInt("id_pelicula"));
                ticket.setFecha(resultSet.getString("fecha_ticket"));
                ticket.setHora(resultSet.getString("hora_ticket"));
                ticket.setMonto(resultSet.getDouble("monto"));
                ticket.setEstado(resultSet.getBoolean("estado"));
                ticket.setMetodoDePago(resultSet.getString("metodo_de_pago"));
                
                tickets.add(ticket);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Tickets");
        }
        return tickets;
    }
    
   
    public List<Ticket> obtenerTicketsXFecha(String fecha){
        List<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            String instrucciones = "SELECT * FROM ticket where fecha_ticket = '"+fecha+"'";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Ticket ticket;
            
            while(resultSet.next()){
                ticket = new Ticket();
                ticket.setId_ticket(resultSet.getInt("id_ticket"));
                ticket.setCliente(resultSet.getInt("id_cliente"));
                ticket.setSala(resultSet.getInt("id_sala"));
                ticket.setButaca(resultSet.getInt("id_butaca"));
                ticket.setVerPelicula(resultSet.getInt("id_pelicula"));
                ticket.setFecha(resultSet.getString("fecha_ticket"));
                ticket.setHora(resultSet.getString("hora_ticket"));
                ticket.setMonto(resultSet.getDouble("monto"));
                ticket.setEstado(resultSet.getBoolean("estado"));
                ticket.setMetodoDePago(resultSet.getString("metodo_de_pago"));
                
                tickets.add(ticket);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Tickets");
        }
        return tickets;
    }
}
