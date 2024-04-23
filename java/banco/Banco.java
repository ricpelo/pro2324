import clientes.Cliente;
import cuentas.Cuenta;

public class Banco {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cliente antonio = new Cliente("111", "Antonio", "Martínez");
        Cuenta c1 = new Cuenta(antonio);
        Cuenta c2 = new Cuenta(antonio);

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
