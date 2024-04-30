package salas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sala {
    private int numero;
    private List<Asiento> asientos;

    public Sala(int numero, int cantidadAsientos) {
        this.numero = numero;
        asientos = new ArrayList<>(cantidadAsientos);

        for (int i = 0; i < cantidadAsientos; i++) {
            BigDecimal extra = new BigDecimal((i % 2 == 0) ? "0" : "2");
            extra.setScale(2);
            asientos.add(new Asiento(i + 1, this, extra));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Sala)) {
            return false;
        }

        Sala sala = (Sala) obj;
        return numero == sala.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public int getNumero() {
        return numero;
    }

    public int cantidadAsientos() {
        return asientos.size();
    }

    public Asiento getAsiento(int numeroAsiento) {
        return asientos.get(numeroAsiento - 1);
    }
}
