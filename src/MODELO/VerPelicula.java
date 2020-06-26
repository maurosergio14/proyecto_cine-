/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Time;
import java.util.*;

/**
 *
 * @author Dani Barros
 */
public class VerPelicula {
    
    private int id_verPelicula;
    private int id_pelicula;
    private int id_sala;
    private Time horario_desde;
    private Time horario_hasta;
    private List<Butaca> butacas = new ArrayList<>();

    public VerPelicula(Pelicula pelicula, Sala sala, Time horario_desde, Time horario_hasta) {
        this.id_pelicula = pelicula.getId_pelicula();
        this.id_sala = sala.getId_sala();
        this.horario_desde = horario_desde;
        this.horario_hasta = horario_hasta;
    }

    public int getId_verPelicula() {
        return id_verPelicula;
    }

    public void setId_verPelicula(int id_verPelicula) {
        this.id_verPelicula = id_verPelicula;
    }

    public int getPelicula() {
        return id_pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.id_pelicula = pelicula.getId_pelicula();
    }

    public int getSala() {
        return id_sala;
    }

    public void setSala(Sala sala) {
        this.id_sala = sala.getId_sala();
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
    
    
}
