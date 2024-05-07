import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Vuelo implements Iterable<Reserva> {
    private int plazas;
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Compania compania;
    private Date salida;
    private Date llegada;
    private BigDecimal precio;

    private Set<Reserva> reservas;

    public Vuelo(
            String codigo,
            int plazas,
            Aeropuerto origen,
            Aeropuerto destino,
            Compania compania,
            Date salida,
            Date llegada,
            BigDecimal precio
    ) {
        this.codigo = codigo;
        this.plazas = plazas;
        this.origen = origen;
        this.destino = destino;
        this.compania = compania;
        this.salida = salida;
        this.llegada = llegada;
        this.precio = precio.setScale(2);
        reservas = new TreeSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Vuelo)) {
            return false;
        }

        Vuelo vuelo = (Vuelo) obj;
        return this.codigo.equals(vuelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public Iterator<Reserva> iterator() {
        return reservas.iterator();
    }

    public int getPlazas() {
        return plazas;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getSalida() {
        return salida;
    }

    public Compania getCompania() {
        return compania;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public Date getLlegada() {
        return llegada;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void registrarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            throw new IllegalArgumentException("El asiento ya está ocupado.");
        }
        reservas.add(reserva);
    }
}
