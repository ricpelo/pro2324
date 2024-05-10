import java.util.Map;
import java.util.TreeMap;

public class Alarma {
    private final int MAX_SENSORES = 64;

    private String marca;
    private String modelo;
    private Ubicacion ubicacion;
    private Comisaria comisaria;

    Map<Integer, Sensor> sensores;

    public Alarma(
        String marca,
        String modelo,
        Ubicacion ubicacion,
        Comisaria comisaria
    ) {
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.comisaria = comisaria;
        sensores = new TreeMap<>();
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

    public void insertarSensor(int numero, String ubicacion, TipoAlarma tipo) {
        if (sensores.size() >= MAX_SENSORES) {
            throw new IllegalArgumentException("No caben más de " + MAX_SENSORES + " sensores en la instalación.");
        }
        Sensor sensor = new Sensor(numero, ubicacion, tipo);
        sensores.put(numero, sensor);
    }

    public void insertarSensor(String ubicacion, TipoAlarma tipo) {
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
}
