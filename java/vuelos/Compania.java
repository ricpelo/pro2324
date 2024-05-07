import java.util.Objects;

public class Compania {
    private String nombre;

    public Compania(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Compania)) {
            return false;
        }

        Compania compania = (Compania) obj;
        return this.nombre.equals(compania.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
