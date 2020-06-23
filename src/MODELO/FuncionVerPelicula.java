/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class FuncionVerPelicula {

    private int id_verPelicula = -1;

    private Pelicula pelicula;
    private Sala sala;
    private Time horario_desde;
    private Time horario_hasta;
    private List<Butaca> butacas = new ArrayList<>();

    public FuncionVerPelicula(Pelicula pelicula, Sala sala, Time horario_desde, Time horario_hasta) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario_desde = horario_desde;
        this.horario_hasta = horario_hasta;
    }

    public FuncionVerPelicula() {
    }

    public int getId_verPelicula() {
        return id_verPelicula;
    }

    public void setId_verPelicula(int id_verPelicula) {
        this.id_verPelicula = id_verPelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Time getHorario_desde() {
        return horario_desde;
    }

    public void setHorario_desde(Time horario_desde) {
        this.horario_desde = horario_desde;
    }

    public Time getHorario_hasta() {
        return horario_hasta;
    }

    public void setHorario_hasta(Time horario_hasta) {
        this.horario_hasta = horario_hasta;
    }

    public List<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(List<Butaca> butacas) {
        this.butacas = butacas;
    }

   
    
    
    
    @Override
    public String toString() {
        return "FuncionVerPelicula{" + "id_verPelicula=" + id_verPelicula + ", id_pelicula=" + pelicula + ", id_sala=" + sala + ", horario_desde=" + horario_desde + ", horario_hasta=" + horario_hasta + '}';
    }

}
