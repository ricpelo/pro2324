package peliculas;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import salas.Sala;

public class Sesion {
    private Date fechaHora;
    private Sala sala;
    private BigDecimal precioBase;

    public Sesion(Date fechaHora, Sala sala) {
        this.fechaHora = (Date) fechaHora.clone();
        this.sala = sala;
        this.precioBase = new BigDecimal("0").setScale(2);
    }

    public Sesion(Date fechaHora, Sala sala, BigDecimal precioBase) {
        this.fechaHora = (Date) fechaHora.clone();
        this.sala = sala;
        this.precioBase = precioBase.setScale(2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Sesion)) {
            return false;
        }

        Sesion sesion = (Sesion) obj;
        return fechaHora.equals(sesion.fechaHora)
                && sala.equals(sesion.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora, sala);
    }

    public Date getFechaHora() {
        return (Date) fechaHora.clone();
    }

    public Sala getSala() {
        return sala;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }
}
