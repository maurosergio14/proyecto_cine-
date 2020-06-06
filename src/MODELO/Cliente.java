
package MODELO;

/**
 * @author grupo 4
 */
public class Cliente {
   private int id_cliente=1;
   private String nombre;
   private String apellido;
   private int dni;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido,int dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni=dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + id_cliente + ", apellido=" + apellido + '}';
    }

    public void id_cliente(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  
    
}
