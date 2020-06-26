/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author Dani Barros
 */
public class Sala {
    
    private int id_sala;
    private String ubicacion;

        
    public Sala(){}
    
    public Sala(String ubicacion) {
        this.id_sala = id_sala;
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
        return "Sala{" + "id_sala=" + id_sala + ", ubicacion=" + ubicacion + '}';
    }
    
    
}
