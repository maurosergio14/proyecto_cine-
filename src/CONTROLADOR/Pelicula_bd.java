package CONTROLADOR;

import MODELO.Conexion;
import MODELO.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public void guardarPelicula(Pelicula pelicula) {
        try {
            String sql = "INSERT INT pelicula(titulo,genero,duracion,autor,idioma)VALUES(?,?,?,?,?);";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getDuracion());
            ps.setString(4, pelicula.getAutor());
            ps.setString(5, pelicula.getIdioma());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                pelicula.setId(rs.getInt(1));
            } else {
                System.out.println("No se puedo obtener el id luego de insertar una pelicula");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el id al insertar pelicula" + ex.getMessage());
        }

    }

    public List<Pelicula> obtenerPelicula() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();

        try {
            String sql = "SELECT * FROM pelicula;";
            PreparedStatement ps = conex.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            Pelicula pelicula;
            while (resultSet.next()) {
                pelicula = new Pelicula();

                pelicula.setId(resultSet.getInt("id_pelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDuracion(resultSet.getString("duracion"));
                pelicula.setAutor(resultSet.getString("autor"));
                pelicula.setIdioma(resultSet.getString("idioma"));

                peliculas.add(pelicula);

            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar Pelicula" + ex.getMessage());
        }

        return peliculas;
    }

    public void borrarPelicula(int id_pelicula) {

        try {

            String sql = "DELETE FROM pelicula WHERE id_pelicula =?;";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_pelicula);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("No se puede borrar la pelicula" + ex.getMessage());
        }

    }

    void actualizarPelicula(Pelicula pelicula) {

        try {
            String sql = "UPDATE pelicula SET titulo=?, genero=?, duracion=?,auto=? idioma=?;";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getDuracion());
            ps.setString(3, pelicula.getAutor());
            ps.setString(5, pelicula.getIdioma());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar pelicula");
        }

    }

    public Pelicula buscarPelicula(int id_pelicula) {

        Pelicula pelicula = null;
        try {
            String sql = "SELECT * FROM pelicula WHERE id_pelicula =?;";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_pelicula);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                pelicula = new Pelicula();

                pelicula.setId(resultSet.getInt("id_pelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDuracion(resultSet.getString("duracion"));
                pelicula.setAutor(resultSet.getString("autor"));
                pelicula.setIdioma(resultSet.getString("idioma"));

            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar el id pelicula" + ex.getMessage());
        }
        return pelicula;

    }
}
