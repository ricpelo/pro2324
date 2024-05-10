public class Ubicacion {
    private String direccion;
    private String poblacion;
    private String provincia;
    private String codigoPostal;

    public Ubicacion(
        String direccion,
        String poblacion,
        String provincia,
        String codigoPostal
    ) {
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getProvincia() {
        return provincia;
    }
}
