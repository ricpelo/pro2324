import java.math.BigDecimal;

public class Articulo {
    private long codigo;
    private String denominacion;
    private BigDecimal precio;

    Articulo(long codigo, String denominacion, BigDecimal precio) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio.setScale(2);
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
}
