/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Conexion;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisPc-Master
 */
public class Butaca_bd {

    private Connection conex;

    public Butaca_bd() {
    }

    public Butaca_bd(Conexion conexion) {
        conex = conexion.getConex();
        try {

            conex = conexion.getConex();

        } catch (Exception ex) {
            System.out.println("Error al abrir al obtener la conexion" + ex.getMessage());
        }
    }
    
    public void guardarButaca(Butaca butaca){
        
        try{
            String sql = "INSERT INTO butaca(id_verPelicula, fila, columna, estado)VALUE(?, ?, ?, ?);";
            
            PreparedStatement ps = conex.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1,butaca.getVerPelicula().getId_verPelicula());
            ps.setInt(2, butaca.getFila());
            ps.setInt(3, butaca.getColumna());
            ps.setBoolean(4, butaca.isEstado() );
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                butaca.setId_butaca(rs.getInt(1));

            } else {
                System.out.println("No se pudo obtener el id luego de insertar una butaca");
            }
            ps.close();

            
        }catch(SQLException ex){
            System.out.println("error al guardar butaca" + ex.getMessage());
        }
        
    }
     public void actualizarButaca(Butaca butaca) {

        try {
            String sql = "UPDATE sala SET id_verPelicula=?  fila=? columna=? estado=? WHARE id_butaca=?;";

            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1,butaca.getVerPelicula().getId_verPelicula());
            ps.setInt(2, butaca.getFila());
            ps.setInt(3, butaca.getColumna());
            ps.setBoolean(4, butaca.isEstado() );
            
            ps.executeUpdate();
            
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar sala" + ex.getMessage());
        }

    }
     
     
      public void borrarButaca( int id) {
        try {
            String sql = "DELETE FROM butaca WHERE id_butaca=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
   
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar butaca " + ex.getMessage());
        }
     }
       public List<Butaca> obtenerButaca() {
        List<Butaca> butacas = new ArrayList<Butaca>();
        try {
            String sql = "SELECT * FROM butaca;";

            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            Butaca butaca;

            while (resultSet.next()) {
                butaca = new Butaca();

                butaca.setId_butaca(resultSet.getInt("id_butaca"));
                butaca.getVerPelicula().setId_verPelicula(resultSet.getInt("id_verPelicula"));
                butaca.setFila(resultSet.getInt("fila"));
                butaca.setColumna(resultSet.getInt("columna"));
                butaca.setEstado(resultSet.getBoolean("estado"));
            
                
                butacas.add(butaca);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las salas  " + ex.getMessage());
        }

        return butacas;
    }
        public Butaca buscarButaca(int id) {
        Butaca butaca = null;
        try {
            String sql = "SELECT * FROM butaca WHERE id_butaca=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                butaca = new Butaca();
                
                butaca.setId_butaca(resultSet.getInt("id_butaca"));
                butaca.getVerPelicula().setId_verPelicula(resultSet.getInt("id_verPelicula"));
                butaca.setFila(resultSet.getInt("fila"));
                butaca.setColumna(resultSet.getInt("columna"));
                butaca.setEstado(resultSet.getBoolean("estado"));
            
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar el id de sala" + ex.getMessage());
        }

        return butaca;
    }

    

}
