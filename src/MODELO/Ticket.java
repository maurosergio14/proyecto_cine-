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
public class Ticket {
    
    private int id_ticket;
    private int IDcliente;
    private int IDsala;
    private int IDbutaca;
    private int pelicula;
    private String fecha;
    private String hora;
    private double monto;
    private boolean estado;
    private String metodoDePago;

    public Ticket(){}
    
    public Ticket(Cliente cliente, Sala sala, Butaca butaca, Pelicula pelicula, String fecha, String hora, double monto, boolean estado, String metodoDePago) {
        this.IDcliente = cliente.getId_cliente();
        this.IDsala = sala.getId_sala();
        this.IDbutaca = butaca.getId_butaca();
        this.pelicula = pelicula.getId_pelicula();
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getCliente() {
        return IDcliente;
    }

    public void setCliente(int cliente) {
        this.IDcliente = cliente;
    }

    public int getSala() {
        return IDsala;
    }

    public void setSala(int sala) {
        this.IDsala = sala;
    }

    public int getButaca() {
        return IDbutaca;
    }

    public void setButaca(int butaca) {
        this.IDbutaca = butaca;
    }

    public int getVerPelicula() {
        return pelicula;
    }

    public void setVerPelicula(int verPelicula) {
        this.pelicula = verPelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", cliente=" + IDcliente + ", sala=" + IDsala + ", butaca=" + IDbutaca + ", verPelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", monto=" + monto + ", estado=" + estado + ", metodoDePago=" + metodoDePago + '}';
    }
    
    
    
}
