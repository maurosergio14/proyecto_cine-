/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dani Barros
 */
public class ButacaBD {
    
    private Connection conex;

    public ButacaBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en PeliculaBD");
        }
    }
    
    public void guardarButaca(Butaca butaca) {
        try {

            String instrucciones = "INSERT INTO butaca (id_verPelicula, fila, columna, estado) VALUES (?, ?, ?, ?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, butaca.getPelicula().getId_verPelicula());
            ps.setInt(2, butaca.getFila());
            ps.setInt(3, butaca.getColumna());
            ps.setBoolean(4, butaca.getEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                butaca.setId_butaca(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id de la Butaca luego de intentar insertarla");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar Butaca");
        }
    }
    
    public void borrarButaca(int id){
        try { 
            String instrucciones = "DELETE FROM butaca WHERE id_butaca = ?;";
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer borrar un Cliente");
        }
    }
    
    public Butaca buscarButaca(int id){
        Butaca butaca = null;
        try {
            String sql = "SELECT * FROM butaca WHERE id_butaca=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                butaca = new Butaca();
                
                butaca.setId_butaca(resultSet.getInt("id_butaca"));
                butaca.setFila(resultSet.getInt("fila"));
                butaca.setColumna(resultSet.getInt("columna"));
                butaca.setEstado(resultSet.getBoolean("estado"));
            
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar el id de Butaca" + ex.getMessage());
        }

        return butaca;
    }
    
    public void liberarButaca(Butaca butaca){
       try {
            
            String instrucciones = "UPDATE butaca SET estado = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setBoolean(1, false);
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar el cliente ");
        }
    
}
    
    public void ocuparButaca(Butaca butaca){
       try {
            
            String instrucciones = "UPDATE butaca SET estado = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setBoolean(1, true);
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar el cliente ");
        }
    
}
}
