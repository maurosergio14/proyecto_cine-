
package VISTA;

import CONTROLADOR.Butaca_bd;
import CONTROLADOR.Cliente_bd;
import CONTROLADOR.FuncionVerPelicula_bd;
import CONTROLADOR.Pelicula_bd;
import CONTROLADOR.Sala_bd;
import CONTROLADOR.Ticket_bd;
import MODELO.Butaca;
import MODELO.Cliente;
import MODELO.Conexion;
import MODELO.FuncionVerPelicula;
import MODELO.Pelicula;
import MODELO.Sala;
import MODELO.Ticket;
import java.sql.Connection;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Sergio
 */
public class Main_Ticket {
    public static void main(String[] args) throws ClassNotFoundException {
        
          // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        //CREAR CLIENTE
         Cliente cliente1 = new Cliente("Cesar", "Noso", 256);
         Cliente_bd Cbd = new Cliente_bd(cargar);
         Cbd.guardarCliente(cliente1);
         //CREAR SALA
         Sala sala1 = new Sala("actualiza");
         Sala_bd Sbd = new Sala_bd(cargar);
         Sbd.guardarSala(sala1);
         //CREAR PELICULA
          Pelicula pelicula1 = new Pelicula("dead pool", "comica","nose", "Jaimito", "latino");
          Pelicula_bd pbd = new Pelicula_bd(cargar);
          pbd.guardarPelicula(pelicula1);
          //CREAR FUNCIONVERPELICULA
          
          FuncionVerPelicula fp1= new FuncionVerPelicula(pelicula1,sala1,Time.valueOf(LocalTime.parse("09:10:10")),Time.valueOf(LocalTime.parse("12:10:10")));
          FuncionVerPelicula_bd fvp = new FuncionVerPelicula_bd(cargar);
          fvp.guardarFuncion(fp1);
          
          //CREAR BUTACA
          Butaca butaca1=new Butaca(fp1,1,1,true);
          Butaca_bd Bbd = new Butaca_bd(cargar);
          Bbd.guardarButaca(butaca1);
        //CREAR TICKET
        
        Ticket ticket = new Ticket(cliente1, sala1, butaca1, pelicula1, "2021-12-23" ,"10:10:10" , 200.23 ,true, "metodoDePago");
        
        //CONTROLADOR TICKET PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Ticket_bd ticket1 = new Ticket_bd(cargar);
        
        
        //ticket1.generarTicket(ticket);
        ticket1.borrarTicket(3);
        ticket1.ObtenerClienteFecha(33, "2021-12-23");
        
    }
    
}
