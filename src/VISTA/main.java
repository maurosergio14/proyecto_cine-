
package VISTA;

import CONTROLADOR.Cliente_bd;
import MODELO.Cliente;
import MODELO.Conexion;
import java.sql.Connection;

/**
 *
 * @author grupo 4
 */
public class main {
    public static void main(String[] args) throws ClassNotFoundException {
         Conexion cargar = null;
        try {
            cargar = new Conexion();
        } catch (ClassNotFoundException ex) {
            System.out.println("error al conectar");
        }
        Connection conex = cargar.getConex();
        Cliente cliente1=new Cliente(54488, "zxxxs", "fssse",1233);
        Cliente_bd cbd1=new Cliente_bd(cargar);
        cbd1.guardarCliente(cliente1);
        
       
    }
}
