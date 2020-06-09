/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
            String sql = "INSERT INTO butaca (id_butaca)";
            
            PreparedStatement ps = conex.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.executeQuery();
            
            
            ps.setInt(1, butaca.getFila());
           

            
        }catch(SQLException ex){
            System.out.println("error al guardar butaca" + ex.getMessage());
        }
        
    }
    
    

}
