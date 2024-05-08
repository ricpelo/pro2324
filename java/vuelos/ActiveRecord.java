import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class ActiveRecord {
    protected static Map<String, ActiveRecord> coleccion = new HashMap<>();

    private String codigo;

    public ActiveRecord(String codigo) {
        this.codigo = codigo;
        coleccion.put(codigo, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ActiveRecord)) {
            return false;
        }

        ActiveRecord activerecord = (ActiveRecord) obj;
        return this.codigo.equals(activerecord.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public static ActiveRecord find(String codigo) {
        return coleccion.get(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
