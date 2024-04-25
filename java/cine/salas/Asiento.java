package salas;

import java.math.BigDecimal;
import java.util.Objects;

public class Asiento {
    private int numero;
    private BigDecimal extra;
    private Sala sala;

    public Asiento(int numero, Sala sala, BigDecimal extra) {
        this.numero = numero;
        this.extra = extra.setScale(2);
        this.sala = sala;
    }

    public int getNumero() {
        return numero;
    }

    public Sala getSala() {
        return sala;
    }

    public BigDecimal getExtra() {
        return extra;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Asiento)) {
            return false;
        }

        Asiento asiento = (Asiento) obj;
        return numero == asiento.numero && sala.equals(asiento.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, sala);
    }
}
