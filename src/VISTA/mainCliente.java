/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.*;
import MODELO.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Dani Barros
 */
public class mainCliente {
    
    public static void main(String[] args){
    
        try{
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        Cliente Daniel = new Cliente("Daniel","Barros",200);
        ClienteBD Cbd1 = new ClienteBD(cargar);
        
        //Cbd1.guardarCliente(Daniel);
        List<Cliente> listaClientes = Cbd1.obtenerClientes();
        for(Cliente it:listaClientes){
        System.out.println(it.toString());
        }
        
        //Cbd1.borrarCliente(43);*/
        
        Cliente clienteBuscado = Cbd1.buscarCliente(46);
        clienteBuscado.setApellido("Ocaño");
        
        Cbd1.actualizarCliente(clienteBuscado);
        
    }catch(ClassNotFoundException e){
            System.out.println("Error al conectar en el MainCliente"+e);
    }
    }
}
