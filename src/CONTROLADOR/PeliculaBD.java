/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani Barros
 */
public class PeliculaBD {
    
    private Connection conex;

    public PeliculaBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en PeliculaBD");
        }
    }
    
    public void guardarPelicula(Pelicula pelicula) {
        try {

            String instrucciones = "INSERT INTO pelicula (titulo, genero, idioma) VALUES (?, ?, ?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getIdioma());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                pelicula.setId_pelicula(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id de la Pelicula luego de intentar insertarla");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar sala");
        }
    }
    
    public List<Pelicula> obtenerPeliculas(){
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        
        try {
            String instrucciones = "SELECT * FROM pelicula;";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Pelicula pelicula;
            
            while(resultSet.next()){
                pelicula = new Pelicula();
                pelicula.setId_pelicula(resultSet.getInt("id_pelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setIdioma(resultSet.getString("idioma"));
                
                peliculas.add(pelicula);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Peliculas");
        }
        return peliculas;
    }
    
     public void borrarPelicula(int id){
        try {
            
            String instrucciones = "DELETE FROM pelicula WHERE id_pelicula = ?;";
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer borrar una Pelicula");
        }
    }
     
     public void actualizarPelicula(Pelicula pelicula){
        try {
            
            String instrucciones = "UPDATE pelicula SET titulo = ?, genero = ?, idioma = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getIdioma());
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar la Pelicula "+pelicula.getTitulo());
        }
    }
     
     public Pelicula buscarPelicula(int id){
        Pelicula pelicula=null;
        
        try {
            
            String instrucciones = "SELECT * FROM pelicula WHERE id_pelicula = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                pelicula = new Pelicula();
                pelicula.setId_pelicula(resultSet.getInt("id_pelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setIdioma(resultSet.getString("idioma"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer buscar una Pelicula"+e.getMessage());
        }
        return pelicula;
    }
     
     public List<Pelicula> obtenerPeliculasXSalaHorario(int idSala, Time horario){
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        
        try {
            String instrucciones = "SELECT * FROM pelicula, funcionverpelicula WHERE funcionverpelicula.id_sala = "+idSala+
                 " AND funcionverpelicula.horario_desde = '"+horario+"';";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Pelicula pelicula;
            
            while(resultSet.next()){
                pelicula = new Pelicula();
                pelicula.setId_pelicula(resultSet.getInt("id_pelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setIdioma(resultSet.getString("idioma"));
                
                peliculas.add(pelicula);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Peliculas"+e);
        }
        return peliculas;
    }
}
