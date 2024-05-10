public class Comisaria {
    private String telefono;
    private Ubicacion ubicacion;

    public Comisaria(String telefono, Ubicacion ubicacion) {
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
