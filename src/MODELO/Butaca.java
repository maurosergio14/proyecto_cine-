package MODELO;

/**
 * @author grupo 4
 */
public class Butaca {

    private int id_butaca = -1;
    private FuncionVerPelicula verPelicula; 
    private int fila;
    private int columna;
    private boolean estado;

    public Butaca() {
    }

    
    
    public Butaca(FuncionVerPelicula verPelicula, int fila, int columna, boolean estado) {
        this.verPelicula = verPelicula;
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
    }

    public int getId_butaca() {
        return id_butaca;
    }

    public void setId_butaca(int id_butaca) {
        this.id_butaca = id_butaca;
    }

    public FuncionVerPelicula getVerPelicula() {
        return verPelicula;
    }

    public void setVerPelicula(FuncionVerPelicula verPelicula) {
        this.verPelicula = verPelicula;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Butaca{" + "id_butaca=" + id_butaca + ", verPelicula=" + verPelicula + ", fila=" + fila + ", columna=" + columna + ", estado=" + estado + '}';
    }
    
   
}
