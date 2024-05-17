import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Alarma {
    public static long ultimoNumero = 0L;

    public final int MAX_SENSORES = 64;

    private long numero;
    private String marca;
    private String modelo;
    private Ubicacion ubicacion;
    private Comisaria comisaria;
    private String palabraClave;

    private Map<Integer, Sensor> sensores;

    public Alarma(
        String marca,
        String modelo,
        Ubicacion ubicacion,
        Comisaria comisaria,
        String palabraClave
    ) {
        this.numero = ++ultimoNumero;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.comisaria = comisaria;
        setPalabraClave(palabraClave);
        sensores = new TreeMap<>();
    }

    public Alarma(Alarma vieja) {
        this.numero = ++ultimoNumero;
        this.marca = vieja.marca;
        this.modelo = vieja.modelo;
        this.ubicacion = vieja.ubicacion;
        this.comisaria = vieja.comisaria;
        this.palabraClave = vieja.palabraClave;
        this.sensores = new TreeMap<>(vieja.sensores);
    }

    public long getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alarma)) {
            return false;
        }
        Alarma alarma = (Alarma) obj;
        return this.numero == alarma.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public Sensor getSensor(int numero) {
        if (!sensores.containsKey(numero)) {
            throw new IllegalArgumentException("Sensor no encontrado.");
        }
        return sensores.get(numero);
    }

    public Collection<Sensor> getSensores() {
        return sensores.values();
    }

    public Collection<Sensor> getSensores(TipoSensor tipoSensor) {
        Collection<Sensor> res = new HashSet<>();
        for (Sensor sensor : getSensores()) {
            if (sensor.getTipo().equals(tipoSensor)) {
                res.add(sensor);
            }
        }
        return res;
    }

    public Comisaria getComisaria() {
        return comisaria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public boolean validarPalabraClave(String intento) {
        return palabraClave.equals(intento);
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public void insertarSensor(int numero, String ubicacion, TipoSensor tipo) {
        comprobarNumeroMaximoSensores();
        Sensor sensor = new Sensor(numero, ubicacion, tipo);
        sensores.put(numero, sensor);
    }

    public void insertarSensor(String ubicacion, TipoSensor tipo) {
        comprobarNumeroMaximoSensores();
        int numero;
        for (numero = 1; !sensores.containsKey(numero); numero++)
            ;
        Sensor sensor = new Sensor(numero, ubicacion, tipo);
        sensores.put(numero, sensor);
    }

    public void eliminarSensor(int numero) {
        if (!sensores.containsKey(numero)) {
            throw new IllegalArgumentException("El sensor no existe.");
        }
        sensores.remove(numero);
    }

    private void comprobarNumeroMaximoSensores() {
        if (sensores.size() >= MAX_SENSORES) {
            throw new IllegalArgumentException("No caben más de " + MAX_SENSORES + " sensores en la instalación.");
        }
    }

    public Collection<Incidencia> getIncidencias() {
        Collection<Incidencia> res = new HashSet<>();
        for (Sensor sensor : getSensores()) {
            res.addAll(sensor.getIncidencias());
        }
        return res;
    }

    @Override
    public String toString() {
        return numero + " - " + marca + modelo;
    }
}
