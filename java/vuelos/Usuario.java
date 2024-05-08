import java.util.Set;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Usuario implements Iterable<Reserva> {
    private String email;
    private String password;
    private Set<Reserva> reservas;

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        reservas = new LinkedHashSet<>();
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
        for (Reserva reserva : vuelo) {
            if (reserva.getAsiento() > asiento) {
                break;
            } else if (reserva.getAsiento() == asiento) {
                throw new IllegalArgumentException("Ya hay una reserva para ese vuelo con ese asiento.");
            }
        }
        Reserva reserva = new Reserva(vuelo, this, asiento);
        reservas.add(reserva);
    }
}
