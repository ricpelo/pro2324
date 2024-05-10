public class Sensor {
    private int numero;
    private String ubicacion;
    private TipoAlarma tipo;

    public Sensor(int numero, String ubicacion, TipoAlarma tipo) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoAlarma getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
