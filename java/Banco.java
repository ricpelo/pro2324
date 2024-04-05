import java.util.Arrays;

public class Banco {
    public static void main(String[] args) {
        Cliente antonio = new Cliente("111", "Antonio", "Martínez");
        Cuenta c1 = new Cuenta(1, antonio);
        Cuenta c2 = new Cuenta(2, antonio);

        c1.insertarMovimiento("Sueldo", 2000000f);
        c1.insertarMovimiento("Hacienda", -3000000f);
        c1.insertarMovimiento("Lotería", 1500000f);

        c2.insertarMovimiento("Apertura", 10f);
        c2.insertarMovimiento("Ingreso", 50f);
        c2.insertarMovimiento("Reintegro", -25f);

        System.out.println("El saldo de c1 es " + c1.getSaldo());
        System.out.println("El saldo de c2 es " + c2.getSaldo());

        c1.mostrarMovimientos();
        System.out.println();
        c1.mostrarMovimientosDescendente();

    }
}

class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;

    public Cliente(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

class Movimiento {
    private String concepto;
    private float cantidad;

    Movimiento(String concepto, float cantidad) {
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    Movimiento(Movimiento movimiento) {
        concepto = movimiento.getConcepto();
        cantidad = movimiento.getCantidad();
    }

    public String getConcepto() {
        return concepto;
    }

    public float getCantidad() {
        return cantidad;
    }
}

class Cuenta {
    private long numero;
    private Cliente titular;
    private Movimiento[] movimientos = new Movimiento[10];
    private int cantidadMovimientos = 0;
    private float saldo = 0f;

    Cuenta(long numero, Cliente titular) {
        this.numero = numero;
        setTitular(titular);
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
