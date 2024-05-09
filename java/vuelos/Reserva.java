import java.util.Date;

public class Reserva implements Comparable<Reserva> {
    private Vuelo vuelo;
    private int asiento;
    private Date fechaHora;

    private Usuario usuario;

    public Reserva(Vuelo vuelo, Usuario usuario, int asiento) {
        if (asiento <= 0 || asiento > vuelo.getPlazas()) {
            throw new IllegalArgumentException("Asiento incorrecto.");
        }
        this.vuelo = vuelo;
        this.usuario = usuario;
        this.asiento = asiento;
        fechaHora = new Date();
        vuelo.registrarReserva(this);
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public int getAsiento() {
        return asiento;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Reserva)) {
            return false;
        }

        Reserva reserva = (Reserva) obj;
        return this.vuelo.equals(reserva.vuelo) &&
                this.asiento == reserva.asiento;
    }

    @Override
    public int compareTo(Reserva otra) {
        String unCodigo = this.vuelo.getCodigo();
        String otroCodigo = otra.vuelo.getCodigo();
        if (unCodigo.equals(otroCodigo)) {
            return this.asiento - otra.asiento;
        }
        return unCodigo.compareTo(otroCodigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vuelo);
        sb.append(' ');
        sb.append(asiento);
        return sb.toString();
    }

    public void mostrarDetalle() {
        System.out.println("Código vuelo: " + getVuelo().getCodigo());
        System.out.println("Asiento: " + getAsiento());
        System.out.println("Origen: " + getVuelo().getOrigen());
        System.out.println("Destino: " + getVuelo().getDestino());
        System.out.println("Compañía: " + getVuelo().getCompania());
        System.out.println("Salida: " + getVuelo().getSalida());
        System.out.println("Llegada: " + getVuelo().getLlegada());
        System.out.println("Precio: " + getVuelo().getPrecio());
    }
}
