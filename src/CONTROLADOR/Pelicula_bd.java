package CONTROLADOR;

import MODELO.Conexion;
import MODELO.Pelicula;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author grupo 4
 */
public class Pelicula_bd {

    private Connection conex;

    public Pelicula_bd() {
    }

    public Pelicula_bd(Conexion conexion) {
        conex = conexion.getConex();
        try {
            conex = conexion.getConex();
        } catch (Exception ex) {
            System.out.println("Error al obtener la conexion" + ex.getMessage());
        }
    }

    void guardarPelicula(Pelicula pelicula) {

    }

    List<Pelicula> obtenerPelicula() {
        return null;
    }

    void borrarPelicula(int id_pelicula) {

    }

    void actualizarPelicula(Pelicula pelicula) {

    }

    Pelicula buscarPelicula(int id_pelicula) {
        return null;
    }
}
