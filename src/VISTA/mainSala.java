/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import CONTROLADOR.*;
import MODELO.Cliente;
import MODELO.Sala;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Dani Barros
 */
public class mainSala {
     public static void main(String[] args){
            
        try{
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        Sala epic = new Sala("Sur");
        SalaBD Sbd1 = new SalaBD(cargar);
        
        //Sbd1.guardarSala(epic);
        //Sbd1.borrarSala(41);
        
        List<Sala> listaSalas = Sbd1.obtenerSalas();
        for(Sala it:listaSalas){
        System.out.println(it.toString());
        }
        
        Sala salaBuscada = Sbd1.buscarSala(53);
        salaBuscada.setUbicacion("NORTE");
        
        Sbd1.actualizarSala(salaBuscada);
        
        }catch(ClassNotFoundException e){
            System.out.println("Error al conectar en el MainCliente"+e);
            }
     }}
