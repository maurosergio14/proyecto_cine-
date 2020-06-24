
package VISTA;

import CONTROLADOR.Sala_bd;
import CONTROLADOR.Ticket_bd;
import MODELO.Butaca;
import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.Pelicula;
import MODELO.Sala;
import MODELO.Ticket;
import java.sql.Connection;

/**
 * @author Sergio
 */
public class Main_Ticket {
    public static void main(String[] args) throws ClassNotFoundException {
        
          // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        //CREAR CLIENTE
         Cliente cliente1 = new Cliente("Cesar", "Noso", 222);
         //CREAR SALA
         Sala sala1 = new Sala("actualiza");
         //CREAR PELICULA
          Pelicula pelicula1 = new Pelicula("dead pool", "comica", "latino");
          //CREAR BUTACA
          Butaca butaca1=new Butaca(sala1, 0, "columna");
        
          
        //CREAR TICKET
        Ticket ticket=new Ticket(cliente1, sala1, pelicula1, 2, 22,butaca1, 0, "metodoDePago");
        
        //CONTROLADOR TICKET PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Ticket_bd ticket_bd = new Ticket_bd(cargar);
        
        ticket_bd.generarTicket(ticket);
        
        
        
    }
    
}
