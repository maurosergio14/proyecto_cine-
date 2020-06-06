package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author grupo 4
 */
public class Cliente_bd {

    private Connection conex;

    public Cliente_bd() {
    }

    public Cliente_bd(Conexion conexion) {
        conex = conexion.getConex();
        try {
            conex = conexion.getConex();
        } catch (Exception ex) {
            System.out.println("Error al abrir al obtener la conexion" + ex.getMessage());
        }
    }

    List<Cliente> obtenerCliente() {
        return null;
    }

    public void guardarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (id_cliente , nombre , apellido,dni) VALUES ( ? , ? , ? , ?  );";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getDni());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.id_cliente(rs.getInt(1));

            } else {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar un cliente: " + ex.getMessage());
        }

        System.out.println("guardado");
    }

    public void borrarCliente(Cliente cliente) {
        try {
            String sql = "DELETE FROM cliente WHERE id_dni =?;";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1,);
            ps.executeUpdate();
            ps.close();
            //  int x=Integer.parseInt(JOptionPane.showInputDialog("introduzca el id a borrar"));
        } catch (SQLException ex) {
            System.out.println("Error al borrar un alumno: " + ex.getMessage());
        }
    }

    public void actualizarCliente(int dni) {

    }

    public Cliente buscarCliente(int dni) {
        return null;
    }

}
