package MODELO;

/**
 * @author grupo 4
 */
public class Butaca {

    private int id_butaca = -1;
    private Sala sala;
    private int fila;
    private String columna;
    private FuncionVerPelicula verPelicula; // funcionVerPelicula
    
    
    public Butaca() {
    }

    public Butaca(Sala sala, int fila, String columna) {
        this.sala = sala;
        this.fila = fila;
        this.columna = columna;
    }

    public Butaca(int id_butaca, Sala sala, int fila, String columna) {
        this.id_butaca = id_butaca;
        this.sala = sala;
        this.fila = fila;
        this.columna = columna;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public FuncionVerPelicula getVerPelicula() {
        return verPelicula;
    }

    public void setVerPelicula(FuncionVerPelicula verPelicula) {
        this.verPelicula = verPelicula;
    }
  
    
    
    public int getId_butaca() {
        return id_butaca;
    }

    public void setId_butaca(int id_butaca) {
        this.id_butaca = id_butaca;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

}
