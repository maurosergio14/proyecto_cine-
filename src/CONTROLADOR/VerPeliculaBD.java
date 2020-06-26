/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Pelicula;
import MODELO.VerPelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dani Barros
 */
public class VerPeliculaBD {
    
    private Connection conex;

    public VerPeliculaBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en PeliculaBD");
        }
    }
    
    //-------------------------------------------------------------------------------------------------------------//
    
    public void guardarVerPelicula(VerPelicula verPelicula) {
        try {

            String instrucciones = "INSERT INTO funcionverpelicula (id_pelicula, id_sala, horario_desde, horario_hasta) "
                    + "VALUES (?, ?, ?, ?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, verPelicula.getPelicula());
            ps.setInt(2, verPelicula.getSala());
            ps.setTime(3, verPelicula.getHorario_desde());
            ps.setTime(4, verPelicula.getHorario_hasta());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                verPelicula.setId_verPelicula(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id de verPelicula luego de intentar nueva informacion");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar sala");
        }
    }
    
    public void borrarVerPelicula(int id_verPelicula) {

        try {
            String sql = "DELETE FORM funcionverpelicula WHERE id_funcionverPelicula =?;";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_verPelicula);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar la informacion de VerPelicula" + ex.getMessage());
        }

    }
    
    public void actualizarVerPelicula(VerPelicula verPelicula) {

        try {
            String sql = "UPDATE funcionverpelicula SET id_pelicula ,id_sala,horario_desde,horario_hasta VALUES(?,?,?,?);";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, verPelicula.getPelicula());
            ps.setInt(1, verPelicula.getSala());
            ps.setTime(3, verPelicula.getHorario_desde());
            ps.setTime(3, verPelicula.getHorario_hasta());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar proyeccion");
        }

    }
    
    //-------------------------------------------------------------------------------------------------------------//
}
