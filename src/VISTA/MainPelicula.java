package VISTA;

import CONTROLADOR.Pelicula_bd;
import MODELO.Conexion;
import MODELO.Pelicula;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class MainPelicula {

    public static void main(String[] args) throws ClassNotFoundException {

        // CONECCION A BASE DE DATOS
        Conexion cargar = new Conexion();
        Connection conex = cargar.getConex();

        //CREAR UN PELICULA
//        Pelicula pelicula1 = new Pelicula("dead pool", "comica", "latino");
        Pelicula pelicula4 = new Pelicula("pando", "gro", "duron", "SF", "ida");
//        Pelicula pelicula3 = new Pelicula(" pool", "ica", "ino");
//        Pelicula pelicula4 = new Pelicula("deol", "coa", "tin");

        //CONTROLADOR PELICULA_BD PARA GUARDAR LAS PELICULAS CREADOS EN LA BASE DE DATOS
        Pelicula_bd p_bd = new Pelicula_bd(cargar);

//        //GUARDAR PELICULA EN BD
//        p_bd.guardarPelicula(pelicula1);
        //         p_bd.guardarPelicula(pelicula4);
//        p_bd.guardarPelicula(pelicula3);
//        p_bd.guardarPelicula(pelicula4);
        //BORRAR UNA PELICULA DE BD MEDIANTE UN ID
        //  cbd.borrarCliente(1331);
        //ACTUALIZAR PELICULA
        pelicula4.setTitulo("yo");
        pelicula4.setGenero("gene");
        pelicula4.setDuracion("adad");
        pelicula4.setAutor("aurtor");
        pelicula4.setIdioma("yvdvo");
        p_bd.actualizarPelicula(pelicula4);

        //BUSCAR UNA PELICULA
        //System.out.println(p_bd.buscarPelicula(2));
        //MOSTRAR LISTA DE PELICULAS
//        List<Pelicula> lista = p_bd.obtenerPelicula();
//        for (Pelicula pelicula : lista) {
//            System.out.println(pelicula.toString());
//        }
    }

}
