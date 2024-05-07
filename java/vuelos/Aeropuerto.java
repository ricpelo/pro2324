import java.util.Objects;

public class Aeropuerto {
    private String codigo;
    private String nombre;

    public Aeropuerto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Aeropuerto)) {
            return false;
        }

        Aeropuerto aeropuerto = (Aeropuerto) obj;
        return this.codigo.equals(aeropuerto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(codigo);
        sb.append(") ");
        sb.append(nombre);
        return sb.toString();
    }
}
