package MODELO;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * @author grupo 4
 */
public class Ticket {
    private int id_ticket;
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;
    private Pelicula pelicula;
    private String fecha;
    private String hora;
    private double monto;
    private boolean estado;
    private String metodoDePago;

    public Ticket(Cliente cliente, Sala sala, Butaca butaca, Pelicula pelicula, String fecha, String hora, double monto, boolean estado, String metodoDePago) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
    }

    public Ticket() {
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

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora(){
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

    public boolean isEstado() {
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
        return "Ticket{" + "id_ticket=" + id_ticket + ", cliente=" + cliente + ", sala=" + sala + ", butaca=" + butaca + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", monto=" + monto + ", estado=" + estado + ", metodoDePago=" + metodoDePago + '}';
    }
    

   

}
