
package MODELO;

import java.util.List;
import java.util.Map;

/**
 * @author grupo 4
 */
public class Sala {
   private int id_sala;
   private String nombre;
   private int horario;
   private List butacas;
   private boolean estadoButacas;

    public Sala() {
    }

    public Sala(/*int id_sala,*/String nombre, int horario,List butacas, boolean estadoButacas) {
        //this.id_sala = id_sala;
        this.nombre = nombre;
        this.horario = horario;
        this. butacas =  butacas;
        this.estadoButacas = estadoButacas;
    }

    public int getId() {
        return id_sala;
    }

    public void setId(int id) {
        this.id_sala = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public List getButacas() {
        return butacas;
    }

    public List setButacas(List butacas) {
        this.butacas = butacas;
       return butacas;
    }

    public boolean isEstadoButacas() {
        return estadoButacas;
    }

    public void setEstadoButacas(boolean estadoButacas) {
        this.estadoButacas = estadoButacas;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id_sala + ", nombre=" + nombre + '}';
    }
    
    
}
