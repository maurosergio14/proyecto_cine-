/*
 */
package MODELO;

/**
 *
 * @author Thomas
 */
public class FuncionVerPelicula {
    private int id_verPelicula;
    private Pelicula id_pelicula;
    private Sala id_sala;
    private String horario_desde;
    private String horario_hasta;

    public FuncionVerPelicula(Pelicula id_pelicula, Sala id_sala, String horario_desde, String horario_hasta) {
        this.id_pelicula = id_pelicula;
        this.id_sala = id_sala;
        this.horario_desde = horario_desde;
        this.horario_hasta = horario_hasta;
    }

    public int getId_verPelicula() {
        return id_verPelicula;
    }

    public void setId_verPelicula(int id_verPelicula) {
        this.id_verPelicula = id_verPelicula;
    }

    public Pelicula getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Pelicula id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Sala getId_sala() {
        return id_sala;
    }

    public void setId_sala(Sala id_sala) {
        this.id_sala = id_sala;
    }

    public String getHorario_hasta() {
        return horario_hasta;
    }

    public void setHorario_hasta(String horario_hasta) {
        this.horario_hasta = horario_hasta;
    }

    @Override
    public String toString() {
        return "FuncionVerPelicula{" + "id_verPelicula=" + id_verPelicula + ", id_pelicula=" + id_pelicula + ", id_sala=" + id_sala + ", horario_desde=" + horario_desde + ", horario_hasta=" + horario_hasta + '}';
    }
    
}
