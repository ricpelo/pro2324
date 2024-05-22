import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Trimestre implements Comparable<Trimestre> {
    private static Set<Trimestre> trimestres = new TreeSet<>();

    private int numero;

    public Trimestre(int numero) {
        this.numero = numero;
        if (trimestres.contains(this)) {
            throw new IllegalArgumentException("El trimestre ya existe.");
        }
        trimestres.add(this);
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Trimestre)) {
            return false;
        }

        Trimestre trimestre = (Trimestre) obj;
        return numero == trimestre.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public int compareTo(Trimestre otro) {
        return numero - otro.numero;
    }
}
