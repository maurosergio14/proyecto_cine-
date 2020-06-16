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

        // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();

        //CREAR UN CLIENTE
        Cliente cliente1 = new Cliente("Cesar", "Noso", 222);
        Cliente cliente2 = new Cliente("Armando", "Paredes", 223);
        Cliente cliente3 = new Cliente("Monica", "Galindo", 224);
        Cliente cliente4 = new Cliente("Elena", "Nito", 227);

        //CONTROLADOR CLIENTE_BD PARA GUARDAR LOS CLIENTES CREADOS EN LA BASE DE DATOS
        Cliente_bd cbd = new Cliente_bd(cargar);

        //GUARDAR CLIENTE EN BD
        cbd.guardarCliente(cliente1);
        cbd.guardarCliente(cliente2);
        cbd.guardarCliente(cliente3);
        cbd.guardarCliente(cliente4);

        //BORRAR UN CLIENTE DE BD MEDIANTE UN ID_DNI
        cbd.borrarCliente(1331);

        //ACTUALIZAR CLIENTE
        cliente4.setApellido("apellido");
        cliente4.setNombre("nombre");
        cbd.actualizarCliente(cliente4);

        //BUSCAR UN CLIENTE
        System.out.println(cbd.buscarCliente(224));

        //MOSTRAR LISTA DE CLIENTES
        List<Cliente> lista = cbd.obtenerCliente();
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
        }

    }
}
