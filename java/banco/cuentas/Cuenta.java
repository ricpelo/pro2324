package cuentas;

import java.util.Arrays;
import java.util.Objects;
import clientes.Cliente;

public class Cuenta implements Cloneable {
    private static long ultimoNumero = 0L;
    private long numero;
    private Cliente titular;
    private Movimiento[] movimientos = new Movimiento[10];
    private int cantidadMovimientos = 0;
    private float saldo = 0f;

    public Cuenta(Cliente titular) {
        numero = ++ultimoNumero;
        setTitular(titular);
    }

    Cuenta(Cuenta otra) {
        numero = otra.numero;
        titular = otra.titular;
        movimientos = otra.movimientos.clone();
        cantidadMovimientos = otra.cantidadMovimientos;
        saldo = otra.saldo;
    }

    @Override
    protected Cuenta clone() throws CloneNotSupportedException {
        Cuenta res = (Cuenta) super.clone();
        res.movimientos = this.movimientos.clone();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cuenta)) {
            return false;
        }

        Cuenta c = (Cuenta) obj;

        return numero == c.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    private void setTitular(Cliente titular) {
        if (titular == null) {
            throw new NullPointerException("El titular no puede ser nulo.");
        }
        this.titular = titular;
    }

    public void mostrarMovimientos() {
        Movimiento[] movimientos = getMovimientos();
        float saldo = 0f;

        for (int i = 0; i < cantidadMovimientos; i++) {
            saldo += movimientos[i].getCantidad();
            System.out.println(movimientos[i].getConcepto() + ' ' +
                    movimientos[i].getCantidad() + ' ' +
                    saldo);
        }
    }

    public void mostrarMovimientosDescendente() {
        Movimiento[] movimientos = getMovimientos();
        float saldo = getSaldo();

        for (int i = cantidadMovimientos - 1; i >= 0; i--) {
            System.out.println(movimientos[i].getConcepto() + ' ' +
                    movimientos[i].getCantidad() + ' ' +
                    saldo);
            saldo -= movimientos[i].getCantidad();
        }
    }

    public long getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public Movimiento[] getMovimientos() {
        Movimiento[] res = new Movimiento[cantidadMovimientos];

        for (int i = 0; i < cantidadMovimientos; i++) {
            res[i] = new Movimiento(movimientos[i]);
        }

        return res;
    }

    public void insertarMovimiento(String concepto, float cantidad) {
        Movimiento movimiento = new Movimiento(concepto, cantidad);
        if (cantidadMovimientos >= movimientos.length) {
            movimientos = Arrays.copyOf(movimientos,
                            (int) (movimientos.length * 1.5f));
        }
        movimientos[cantidadMovimientos++] = movimiento;
        saldo += cantidad;
    }
}
