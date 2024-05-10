import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {
        new Compania("IB", "Iberia");
        new Compania("RY", "Ryanair");

        new Aeropuerto("XRY", "Jerez");
        new Aeropuerto("SVQ", "Sevilla");

        Usuario pepe = new Usuario("pepe@gmail.com", "pepito");
        new Usuario("juan@gmail.com", "juanito");

        Vuelo v1 = new Vuelo(
                "RY3214",
                200,
                Aeropuerto.find("XRY"),
                Aeropuerto.find("SVQ"),
                Compania.find("RY"),
                (new GregorianCalendar(2024, 5, 8, 12, 25)).getTime(),
                (new GregorianCalendar(2024, 5, 8, 14, 25)).getTime(),
                new BigDecimal("230.45"));

        pepe.reservar(v1, 5);

        // loguear al usuario
        Usuario usuario = loguear();
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============\n");
            System.out.println("1. Crear una reserva.");
            System.out.println("2. Mostrar las reservas del usuario.");
            System.out.println("0. Finalizar el programa.\n");
            System.out.print("Introduzca opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (opcion) {
                case 1:
                    crearReserva(usuario);
                    break;
                case 2:
                    mostrarReservas(usuario);
                    break;
                default:
                    // sc.close();
                    return;
            }
        }
    }

    public static void crearReserva(Usuario usuario) {
        Set<Vuelo> vuelos = Vuelo.all();
        System.out.println();
        for (Vuelo vuelo : vuelos) {
            System.out.print(vuelo);
            System.out.println(" " + (vuelo.getPlazas() - vuelo.cantidadReservas()));
        }
        System.out.println();

        Vuelo vuelo;
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.print("Introduzca el código del vuelo a reservar (0 para salir): ");
            String codigo = sc.nextLine().strip();
            if (codigo.equals("0")) {
                return;
            }
            vuelo = Vuelo.find(codigo);
            if (vuelo != null && vuelos.contains(vuelo)) {
                break;
            }
            System.out.println("Vuelo incorrecto.");
        }

        // Elegir asiento:
        int asiento;

        for (;;) {
            System.out.printf("El número de asiento debe estar comprendido entre 1 y %d\n", vuelo.getPlazas());
            System.out.print("Introduzca el asiento deseado: ");
            asiento = sc.nextInt();
            sc.nextLine();
            if (asiento <= 0 || asiento > vuelo.getPlazas()) {
                System.out.println("Asiento incorrecto.");
            } else if (vuelo.asientoOcupado(asiento)) {
                System.out.println("Asiento ya ocupado.");
            } else {
                break;
            }
        }

        // sc.close();
        usuario.reservar(vuelo, asiento);
        System.out.println("Reserva creada.\n");
    }

    private static Usuario loguear() {
        Usuario usuario;

        for (;;) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Correo del usuario: ");
            String email = sc.nextLine();
            System.out.print("Contraseña: ");
            String password = sc.nextLine();
            usuario = Usuario.find(email);
            if (usuario != null) {
                if (usuario.getPassword().equals(password)) {
                    break;
                }
            }
            System.out.println("Usuario o contraseña incorrectos.");
        }

        return usuario;
    }

    public static void mostrarReservas(Usuario usuario)
    {
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.println();
            System.out.println("N.º Vuelo Origen -> Destino Salida Asiento");
            System.out.println("------------------------------------------");
            int cantidad = 0;
            Map<Integer, Reserva> reservas = new HashMap<>();

            for (Reserva reserva : usuario) {
                System.out.println((++cantidad) + " " + reserva.toString());
                reservas.put(cantidad, reserva);
            }

            System.out.print("\nSeleccione la reserva (0 para salir): ");
            int numReserva = sc.nextInt();
            sc.nextLine();
            if (numReserva == 0) {
                break;
            }
            if (numReserva <= 0 || numReserva > cantidad) {
                System.out.println("Selección incorrecta.");
            }
            Reserva reserva = reservas.get(numReserva);
            reserva.mostrarDetalle();
            System.out.print("Pulse Intro para continuar... ");
            sc.nextLine();
        }

        // sc.close();
    }
}
