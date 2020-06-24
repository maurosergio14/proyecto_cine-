package VISTA;

import CONTROLADOR.Sala_bd;
import MODELO.Conexion;
import MODELO.Sala;
import java.sql.Connection;
import java.util.List;

/**
 * @author Sergio
 */
public class mainSala {

    public static void main(String[] args) throws ClassNotFoundException {

        // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();

        //CREAR UNA SALA
        Sala sala1 = new Sala("actualiza");
        

        //CONTROLADOR Sala_bd PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Sala_bd sala_bd = new Sala_bd(cargar);
        // sala_bd.guardarSala(sala1);
        
        
        //BORRAR UNA SALA DE BD MEDIANTE UN ID_DNI
        //sala_bd.borrarSala(1);
        
        
        //ACTUALIZAR CLIENTE
/**/     sala_bd.actualizarSala(sala1);

        //BUSCAR SALA  
        System.out.println(sala_bd.buscarSala(2));    
    
    
     //MOSTRAR LISTA DE CLIENTES
        List<Sala> lista = sala_bd.obtenerSala();
        for (Sala cliente : lista) {
            System.out.println(cliente.toString());
        }
    }
}
