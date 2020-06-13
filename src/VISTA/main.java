package VISTA;

import CONTROLADOR.Cliente_bd;
import MODELO.Cliente;
import MODELO.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author grupo 4
 */
public class main {

    public static void main(String[] args) throws ClassNotFoundException {


        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();
        
        //prueba de creacion de la clase cliente y cliente_bd
        Cliente cliente1=new Cliente("agos", "ella",104);
        Cliente_bd cbd1=new Cliente_bd(cargar);
        
        cbd1.guardarCliente(cliente1);
       // cbd1.borrarCliente(1331);
       // System.out.println(cbd1.buscarCliente(101));
       //cbd1.actualizarCliente(cliente1);
       List<Cliente> lista=cbd1.obtenerCliente();
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
        }
       
    }
}
