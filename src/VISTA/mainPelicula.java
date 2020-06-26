/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.*;
import MODELO.Cliente;
import MODELO.Pelicula;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Dani Barros
 */
public class mainPelicula {
    
    public static void main(String[] args){
    
        try{
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        Pelicula Godzila = new Pelicula("Godzila", "Accion", "Ingles");
        PeliculaBD Pbd1 = new PeliculaBD(cargar);
        
        //Pbd1.guardarPelicula(Godzila);
        //Pbd1.borrarPelicula(35);
        
        
        List<Pelicula> listaPeliculas = Pbd1.obtenerPeliculas();
        for(Pelicula it:listaPeliculas){
        System.out.println(it.toString());
        }
                
       Pelicula peliculaBuscada = Pbd1.buscarPelicula(48);
       peliculaBuscada.setGenero("Fantasia");
        
        Pbd1.actualizarPelicula(peliculaBuscada);
        
        
    }catch(ClassNotFoundException e){
            System.out.println("Error al conectar en el MainCliente"+e);
    }
    }
    
}
