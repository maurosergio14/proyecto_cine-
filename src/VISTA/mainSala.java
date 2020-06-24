package VISTA;

import CONTROLADOR.Sala_bd;
import MODELO.Conexion;
import MODELO.Sala;
import java.sql.Connection;

/**
 * @author Sergio
 */
public class mainSala {

    public static void main(String[] args) throws ClassNotFoundException {

        // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
         //CREAR UNA SALA
        Sala sala1 = new Sala("ubicacion");
        
         //CONTROLADOR Sala_bd PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Sala_bd sala_bd=new Sala_bd(cargar);
        
        sala_bd.guardarSala(sala1);

    }
}
