package MODELO;

import java.util.List;
import java.util.Map;

/**
 * @author grupo 4
 */
public class Sala {

    private int id_sala;
    //private String nombre;
    private String ubicacion;
    private List butacas;

    public Sala() {
    }

    public Sala(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
  
    @Override
    public String toString() {
        return "Sala{" + "id=" + id_sala + ", nombre=" + ubicacion  + '}';
    }

}
