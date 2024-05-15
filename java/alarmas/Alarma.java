import java.util.Map;
import java.util.TreeMap;

public class Alarma {
    public final int MAX_SENSORES = 64;

    private String marca;
    private String modelo;
    private Ubicacion ubicacion;
    private Comisaria comisaria;
    private String palabraClave;

    Map<Integer, Sensor> sensores;

    public Alarma(
        String marca,
        String modelo,
        Ubicacion ubicacion,
        Comisaria comisaria,
        String palabraClave
    ) {
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.comisaria = comisaria;
        setPalabraClave(palabraClave);
        sensores = new TreeMap<>();
    }

    public Alarma(Alarma vieja) {
        this.marca = vieja.marca;
        this.modelo = vieja.modelo;
        this.ubicacion = vieja.ubicacion;
        this.comisaria = vieja.comisaria;
        this.palabraClave = vieja.palabraClave;
        this.sensores = new TreeMap<>(vieja.sensores);
    }

    public Sensor getSensor(int numero) {
        if (!sensores.containsKey(numero)) {
            throw new IllegalArgumentException("Sensor no encontrado.");
        }
        return sensores.get(numero);
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

    public void insertarSensor(int numero, String ubicacion, TipoAlarma tipo) {
        comprobarNumeroMaximoSensores();
        Sensor sensor = new Sensor(numero, ubicacion, tipo);
        sensores.put(numero, sensor);
    }

    public void insertarSensor(String ubicacion, TipoAlarma tipo) {
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

    public void insertarIncidencia(Sensor sensor) {
        if (getSensor(sensor.getNumero()) != sensor) {
            throw new IllegalArgumentException("El sensor no es de esa alarma.");
        }
        new Incidencia(sensor);
    }

    private void comprobarNumeroMaximoSensores() {
        if (sensores.size() >= MAX_SENSORES) {
            throw new IllegalArgumentException("No caben más de " + MAX_SENSORES + " sensores en la instalación.");
        }
    }
}
