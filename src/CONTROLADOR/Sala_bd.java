package CONTROLADOR;


import MODELO.Conexion;
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
 
    private Connection conex;

    public Sala_bd() {
    }

    public Sala_bd(Conexion conexion) {
     conex = conexion.getConex();
        try {
            conex = conexion.getConex();
        } catch (Exception ex) {
            System.out.println("Error al abrir al obtener la conexion" + ex.getMessage());
        }
    }

   public void guardarSala(Sala sala) {

        try {
            String sql = "INSERT INTO sala (ubicacion)VALUE(?);";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setNString(1, sala.getUbicacion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                sala.setId_sala(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id de insertar una sala");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar Sala" + ex.getMessage());
        }

    }

   public void actualizarSala(Sala sala) {

        try {
            String sql = "UPDATE sala SET ubicacion=?;";

            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setNString(1, sala.getUbicacion());
            ps.executeUpdate();
            
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar sala" + ex.getMessage());
        }

    }

    public void borrarSala(int id) {
        try {
            String sql = "DELETE FROM sala WHERE id_sala=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
     
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar sala " + ex.getMessage());
        }
    }
   public Sala buscarSala(int id) {
        Sala sala = null;
        try {
            String sql = "SELECT * FROM sala WHERE id_sala=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                sala = new Sala();
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getNString("cant_butacas"));
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar el id de sala" + ex.getMessage());
        }

        return sala;
    }

    public List<Sala> obtenerSala() {
        List<Sala> salas = new ArrayList<Sala>();
        try {
            String sql = "SELECT * FROM sala;";

            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            Sala sala;

            while (resultSet.next()) {
                sala = new Sala();

                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setUbicacion(resultSet.getNString("cant_butacas"));

                salas.add(sala);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las salas  " + ex.getMessage());
        }

        return salas;
    }
}
