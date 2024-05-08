import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class Usuario implements Iterable<Reserva> {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    private String email;
    private String password;
    private Set<Reserva> reservas;

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        reservas = new LinkedHashSet<>();
        usuarios.put(email, this);
    }

    public static Usuario find(String email) {
        return usuarios.get(email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario) obj;
        return this.email.equals(usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public Iterator<Reserva> iterator() {
        return reservas.iterator();
    }

    @Override
    public String toString() {
        return email;
    }

    public void reservar(Vuelo vuelo, int asiento) {
        Reserva reserva = new Reserva(vuelo, this, asiento);
        reservas.add(reserva);
    }
}
