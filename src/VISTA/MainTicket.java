/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.Butaca_bd;
import CONTROLADOR.FuncionVerPelicula_bd;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author LuisPc-Master
 */
public class MainTicket {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {

        // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();

        //CREAR CLIENTE
        Cliente cliente1 = new Cliente("Cesar", "Noso", 222);
        //CREAR SALA
        Sala sala1 = new Sala("Oeste");

        Sala_bd salaData = new Sala_bd(cargar);

        // salaData.guardarSala(sala1);
        //CREAR PELICULA
        Pelicula pelicula1 = new Pelicula("dead pool", "comica", "latino");

        //CREAR PROYECCION
        

        

        FuncionVerPelicula proyeccion1 = new FuncionVerPelicula(pelicula1, sala1, Time.valueOf(LocalTime.MIN), Time.valueOf(LocalTime.MIN));

        //FuncionVerPelicula_bd proyeccionData = new FuncionVerPelicula_bd(cargar);
        //proyeccionData.guardarFuncion(proyeccion1);*/

        //CREAR BUTACA
        Butaca butaca1 = new Butaca(proyeccion1, 1, 1,"false");
        //Butaca_bd butacaData = new Butaca_bd(cargar);
        //butacaData.guardarButaca(butaca1);
        //CREAR TICKET
        Ticket ticket = new Ticket(cliente1,  proyeccion1 ,butaca1,LocalDate.of(2020,6,24) ,Time.valueOf(LocalTime.MIN), 2000.0,"False", "MercadoDePago");

        //CONTROLADOR TICKET PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Ticket_bd ticket_bd = new Ticket_bd(cargar);

        ticket_bd.generarTicket(ticket);
    }

}
