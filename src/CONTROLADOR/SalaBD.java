/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani Barros
 */
public class SalaBD {
    
    private Connection conex;

    public SalaBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en SalaBD");
        }
    }
    
    public void guardarSala(Sala sala) {
        try {

            String instrucciones = "INSERT INTO sala (ubucacion) VALUES (?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sala.getUbicacion());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                sala.setId_sala(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id de Sala luego de intentar insertarla");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar sala");
        }
    }
    
    public List<Sala> obtenerSalas(){
        List<Sala> salas = new ArrayList<Sala>();
        
        try {
            String instrucciones = "SELECT * FROM sala;";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Sala sala;
            
            while(resultSet.next()){
                sala = new Sala();
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getString("ubucacion"));
                
                salas.add(sala);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Salas");
        }
        return salas;
    }
    
    public void borrarSala(int id){
        try {
            
            String instrucciones = "DELETE FROM sala WHERE id_sala = ?;";
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer borrar una Sala");
        }
    }
    
    public void actualizarSala(Sala sala){
        try {
            
            String instrucciones = "UPDATE sala SET ubucacion = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setString(1, sala.getUbicacion());
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar la sala "+sala.getId_sala());
        }
    }
    
    public Sala buscarSala(int id){
        Sala sala=null;
        
        try {
            
            String instrucciones = "SELECT * FROM sala WHERE id_sala = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                sala = new Sala();
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getString("ubucacion"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer buscar una sala"+e.getMessage());
        }
        return sala;
    }
    
    public List<Sala> obtenerSalasXPelicula(int idPelicula){
        List<Sala> salas = new ArrayList<Sala>();
        
        try {
            String instrucciones = "SELECT * FROM sala, funcionverpelicula WHERE funcionverpelicula.id_pelicula = "+idPelicula;
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Sala sala;
            
            while(resultSet.next()){
                sala = new Sala();
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getString("ubucacion"));
                
                salas.add(sala);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Salas");
        }
        return salas;
    }
    
    
}
