
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
        Cliente cliente1=new Cliente("luis", "cris",1331);
        Cliente_bd cbd1=new Cliente_bd(cargar);
        //cbd1.guardarCliente(cliente1);
        //cbd1.borrarCliente(1331);
        //System.out.println(cbd1.buscarCliente(123));
       
       
    }
}
