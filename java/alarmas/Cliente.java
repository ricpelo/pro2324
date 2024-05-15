import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cliente {
    private int numero;
    private String nif;
    private String nombre;
    private Ubicacion ubicacion;
    private String telefonoFijo;
    private Map<String, Movil> moviles;

    private Set<Alarma> alarmas;

    public Cliente(
        int numero,
        String nif,
        String nombre,
        Ubicacion ubicacion,
        String telefonoFijo
    ) {
        this.numero = numero;
        this.nif = nif;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefonoFijo = telefonoFijo;
        moviles = new LinkedHashMap<>();
        alarmas = new HashSet<>();
    }

    public Set<Map.Entry<String, Movil>> getMoviles() {
        return moviles.entrySet();
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void asociarMovil(String numero, String nombre) {
        moviles.put(numero, new Movil(numero, nombre));
    }

    public void quitarMovil(String numero) {
        moviles.remove(numero);
    }

    public void altaAlarma(Alarma alarma) {
        alarmas.add(alarma);
    }

    public void bajaAlarma(Alarma alarma) {
        alarmas.remove(alarma);
    }
}
