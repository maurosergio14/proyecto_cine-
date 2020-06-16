package MODELO;
import java.util.Date;
/**
 * @author grupo 4
 */
public class Ticket {
    Date Fecha = new Date();
    
    private int id_ticket;
    private Cliente cliente;
    private Sala sala;
    private Pelicula pelicula;
    private Date fecha;
    private Date hora;
    private Butaca butaca;
    private double monto;
    private String metodoDePago;

    public Ticket() {
    }
    public Ticket(int id_ticket, Cliente cliente, Sala sala, Pelicula pelicula, Butaca butaca,double monto,String metodoDePago) {
        this.id_ticket = id_ticket;
        this.cliente = cliente;
        this.sala = sala;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora=hora;
        this.butaca = butaca;
        this.monto=monto;
        this.metodoDePago=metodoDePago;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    
    
   

    @Override
    public String toString() {
        return "Negocio{" + "cliente=" + cliente + ", sala=" + sala + ", pelicula=" + pelicula + ", ticket=" + id_ticket + ", fecha=" + fecha + '}';
    }

}
