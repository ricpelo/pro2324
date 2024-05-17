import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Incidencia {
    private static long ultimoNumero = 0L;
    private long numero;
    private Date fechaHora;
    private Sensor sensor;

    private Set<Actuacion> actuaciones;

    public Incidencia(Sensor sensor) {
        fechaHora = new Date();
        this.sensor = sensor;
        numero = ++ultimoNumero;
        actuaciones = new LinkedHashSet<>();
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public long getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object otra) {
        if (this == otra) {
            return true;
        }

        if (!(otra instanceof Incidencia)) {
            return false;
        }

        Incidencia incidencia = (Incidencia) otra;
        return numero == incidencia.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public void insertarActuacion(TipoActuacion tipoActuacion, String observaciones) {
        actuaciones.add(new Actuacion(tipoActuacion, observaciones));
    }

    public Set<Actuacion> getActuaciones() {
        return new LinkedHashSet<>(actuaciones);
    }
}
