package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Conexion;
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

    public List<Cliente> obtenerCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            String sql = "SELECT * FROM cliente;";

            PreparedStatement ps = conex.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            Cliente cliente;

            while (resultSet.next()) {
                cliente = new Cliente();

                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                
                clientes.add(cliente);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de clientes");
        }

        return clientes;

    }

    public void guardarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente  (nombre , apellido,dni) VALUES (? , ? , ?  );";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.setId_cliente(rs.getInt(1));

            } else {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar un cliente: " + ex.getMessage());
        }

        System.out.println("guardado");
    }

    public void borrarCliente(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente =?;";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            //  int x=Integer.parseInt(JOptionPane.showInputDialog("introduzca el id a borrar"));
        } catch (SQLException ex) {
            System.out.println("Error al borrar un alumno: " + ex.getMessage());
        }
    }

    public void actualizarCliente(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET nombre=?,apellido=?,dni=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());

            ps.setInt(4, cliente.getId_cliente());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar cliente" + ex.getMessage());
        }

    }

    public Cliente buscarCliente(int id) {
        Cliente cliente = null;

        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente=?;";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));

            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar cliente por ID" + ex.getMessage());
        }

        return cliente;
    }

}
