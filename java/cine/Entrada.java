import java.math.BigDecimal;
import peliculas.Sesion;
import salas.Asiento;

public class Entrada {
    private Sesion sesion;
    private Asiento asiento;

    public Entrada(Sesion sesion, Asiento asiento) {
        boolean esta = false;
        for (int i = 0; i < sesion.getSala().cantidadAsientos(); i++) {
            if (sesion.getSala().getAsiento(i + 1).equals(asiento)) {
                esta = true;
                break;
            }
        }
        if (!esta) {
            // Error
        }
        this.sesion = sesion;
        this.asiento = asiento;
    }

    public BigDecimal getPrecio() {
        return sesion.getPrecioBase().add(asiento.getExtra());
    }

    public Sesion getSesion() {
        return sesion;
    }

    public Asiento getAsiento() {
        return asiento;
    }
}
