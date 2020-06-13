package MODELO;

/**
 * @author grupo 4
 */
public class Ticket {

    private int id_ticket;
    private Cliente cliente;
    private Sala sala;
    private Pelicula pelicula;
    private String fecha;
    private Butaca butaca;

    public Ticket() {
    }
    public Ticket(Cliente cliente, Sala sala, Pelicula pelicula, String fecha, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.butaca = butaca;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

   

    @Override
    public String toString() {
        return "Negocio{" + "cliente=" + cliente + ", sala=" + sala + ", pelicula=" + pelicula + ", ticket=" + id_ticket + ", fecha=" + fecha + '}';
    }

}
