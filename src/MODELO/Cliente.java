
package MODELO;

/**
 * @author grupo 4
 */
public class Cliente {

   private int id_cliente;

   //private int id_cliente=-1;

   private String nombre;
   private String apellido;
   private int dni;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public Cliente(String nombre, String apellido,int dni) {

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

        return  "Id: "+ id_cliente + " "+nombre+" "+ apellido + " dni: " + dni ;
    }

      

   

  
    
    }
