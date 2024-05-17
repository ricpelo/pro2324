import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sensor {
    private int numero;
    private String ubicacion;
    private TipoSensor tipo;

    private Map<Long, Incidencia> incidencias;

    public Sensor(int numero, String ubicacion, TipoSensor tipo) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        incidencias = new LinkedHashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public TipoSensor getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void insertarIncidencia() {
        Incidencia incidencia = new Incidencia(this);
        incidencias.put(incidencia.getNumero(), incidencia);
    }

    public void eliminarIncidencia(long numero) {
        if (!incidencias.containsKey(numero)) {
            throw new IllegalArgumentException("La incidencia no existe.");
        }
        incidencias.remove(numero);
    }

    public Collection<Incidencia> getIncidencias() {
        return incidencias.values();
    }

    public int getCantidadIncidencias() {
        return incidencias.size();
    }
}
