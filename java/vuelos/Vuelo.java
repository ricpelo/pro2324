import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Vuelo implements Iterable<Reserva>, Comparable<Vuelo> {
    private static Map<String, Vuelo> vuelos = new TreeMap<>();

    private int plazas;
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Compania compania;
    private Date salida;
    private Date llegada;
    private BigDecimal precio;

    private Map<Integer,Reserva> reservas;

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
        reservas = new TreeMap<>();
        vuelos.put(codigo, this);
    }

    public static Vuelo find(String codigo) {
        return vuelos.get(codigo);
    }

    /**
     * Devuelve el conjunto de los vuelos disponibles que tienen plazas libres,
     * ordenado por la fecha de salida.
     *
     * @return Los vuelos.
     */
    public static Set<Vuelo> all() {
        Set<Vuelo> res = new TreeSet<Vuelo>();

        for (Vuelo vuelo : vuelos.values()) {
            if (vuelo.tienePlazasLibres() && vuelo.estaDisponible()) {
                res.add(vuelo);
            }
        }

        return res;
    }

    public int cantidadReservas() {
        return reservas.size();
    }

    public boolean tienePlazasLibres() {
        return reservas.size() < plazas;
    }

    public boolean estaDisponible()
    {
        return salida.compareTo(new Date()) > 0;
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
        return reservas.values().iterator();
    }

    @Override
    public int compareTo(Vuelo vuelo) {
        if (this.equals(vuelo)) {
            return 0;
        }
        return this.getSalida().compareTo(vuelo.getSalida());
    }

    public boolean asientoOcupado(int asiento) {
        return reservas.containsKey(asiento);
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
        if (reservas.get(reserva.getAsiento()) != null) {
            throw new IllegalArgumentException("El asiento ya está ocupado.");
        }
        reservas.put(reserva.getAsiento(), reserva);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCodigo());
        sb.append(' ');
        sb.append(getOrigen());
        sb.append(" -> ");
        sb.append(getDestino());
        sb.append(' ');
        sb.append(getSalida());
        return sb.toString();
    }
}
