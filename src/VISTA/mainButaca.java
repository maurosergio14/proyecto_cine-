/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.*;
import MODELO.Butaca;
import MODELO.Cliente;
import MODELO.Pelicula;
import MODELO.Sala;
import MODELO.Ticket;
import MODELO.VerPelicula;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Dani Barros
 */
public class mainButaca {
    
     public static void main(String[] args){
        try{
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        Cliente Daniel = new Cliente("Daniel","Barros",200);
        ClienteBD Cbd1 = new ClienteBD(cargar);
        
        //Cbd1.guardarCliente(Daniel);
        
        Pelicula Rosa = new Pelicula("Rosa", "Amor", "Castellano");
        PeliculaBD Pbd2 = new PeliculaBD(cargar);
        
        //Pbd2.guardarPelicula(Rosa);
        
        Sala amorosa = new Sala("Este");
        SalaBD Sbd2 = new SalaBD(cargar);
        
        //Sbd2.guardarSala(amorosa);
        
        VerPelicula nuevaInfo = new VerPelicula(Rosa, amorosa, Time.valueOf(LocalTime.MIN), Time.valueOf(LocalTime.MIN));
        VerPeliculaBD VPbd1 = new VerPeliculaBD(cargar);
        
        //VPbd1.guardarVerPelicula(nuevaInfo);
        
        Butaca uno = new Butaca(nuevaInfo, 1, 1, true);
        ButacaBD Bbd1 = new ButacaBD(cargar);
        
        //Bbd1.guardarButaca(uno);
        
        //Butaca butacaBuscada = Bbd1.buscarButaca(52);
        //System.out.println(butacaBuscada);
        
        
        //Ticket primero = new Ticket(Daniel, amorosa, uno, Rosa, "26/06", "05:36", 400.00, true, "Visa");
        TicketBD Tbd1 = new TicketBD(cargar);
        
        /*Tbd1.guardarTicket(primero);
        List<Ticket> listaTicketsXpeli = Tbd1.obtenerTicketsXpeli(53);
        for(Ticket it:listaTicketsXpeli){
            System.out.println(it);
        }*/
        
        List<Ticket> listaTicketsXfecha = Tbd1.obtenerTicketsXFecha("26/06");
        for(Ticket it:listaTicketsXfecha){
            System.out.println(it.toString());
        }
        
        List<Cliente> listaClientesXfecha = Cbd1.obtenerClientesXfecha(47,"26/06");
        for(Cliente it:listaClientesXfecha){
            System.out.println(it.toString());
        }
        
         List<Sala> listaSalasXpeli = Sbd2.obtenerSalasXPelicula(53);
        for(Sala it:listaSalasXpeli){
            System.out.println(it.toString());
        }
        
        List<Pelicula> listaPelisXSalaHorario = Pbd2.obtenerPeliculasXSalaHorario(57,Time.valueOf(LocalTime.parse("00:00:00")));
        for(Pelicula it:listaPelisXSalaHorario){
            System.out.println(it.toString());
        }
        
        Bbd1.ocuparButaca(uno);
        
    }catch(ClassNotFoundException e){
            System.out.println("Error al conectar en el MainCliente"+e);
    }
    }
     
}
