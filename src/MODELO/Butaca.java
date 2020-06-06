
package MODELO;

/**
 * @author grupo 4
 */
public class Butaca {
    int id_butaca;
    int fila;
    boolean ocupada;

    public Butaca() {
    }

    public Butaca(int id_butaca, int fila, boolean ocupada) {
        this.id_butaca = id_butaca;
        this.fila = fila;
        this.ocupada = ocupada;
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

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    
}
