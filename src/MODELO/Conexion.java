
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author grupo 4
 */
public class Conexion {
  private String url="jdbc:mysql://localhost/proyecto-cine";
  private String usuario="root";
  private String password="";
  public Connection conexion=null;

    public Conexion() throws ClassNotFoundException {
          Class.forName("org.mariadb.jdbc.Driver");
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/proyecto-cine", "root", "");
            System.out.println("conexion exitosa!!!!!");
        } catch (SQLException ex) {
            System.out.println("error al conectar" + ex.getMessage());
        }
    }

    public Conexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection getConex() {
          if (conexion == null) {
              try {
                  // Setup the connection with the DB
                  conexion = DriverManager
                          .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                                  + "&user=" + usuario + "&password=" + password);
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"error al conectar"+ex.getMessage());
              }
          }
            return conexion; 
    }
}

