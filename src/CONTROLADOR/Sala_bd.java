package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Sala;
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
public class Sala_bd {

    Connection conexion;

    public Sala_bd(Connection conexion) {
        this.conexion = conexion;
    }

    void guardarSala(Sala sala) {

        try {
            String sql = "INSERT sala INTO (ubicacion);";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.executeQuery();
            ps.setString(1, sala.getUbicacion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                sala.setId_sala(rs.getInt(1));
            } else {
                System.out.println("Nose puedo obtener el id de insertar una sala");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar Sala" + ex.getMessage());
        }

    }

    void actualizarSala(Sala sala) {

        try {
            String sql = "UPDATE sala SET ubicacion=?;";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, sala.getUbicacion());
            ps.setInt(2, sala.getId_sala());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar sala" + ex.getMessage());
        }

    }

    void borrarSala(int id_sala) {
        Cliente cliente = null;
        try {
            String sql = "DELETE FROM sala WHERE id_sala=?;";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_sala);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar sala " + ex.getMessage());
        }

    }

    Sala buscarSala(int id) {
        Sala sala = null;
        try {
            String sql = "SELEC * FROM sala WHERE id_sala=?;";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                sala = new Sala();
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getString("ubicacion"));
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar el id de sala" + ex.getMessage());
        }

        return sala;
    }

    List<Sala> obtenerSala() {
        List<Sala> salas = new ArrayList<Sala>();
        try {
            String sql = "SELEC * FROM sala;";

            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = ps.executeQuery();

            Sala sala;

            while (resultSet.next()) {
                sala = new Sala();

                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getString("ubicacion"));

                salas.add(sala);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las salas  " + ex.getMessage());
        }

        return salas;
    }

}
