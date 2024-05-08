import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
            new BigDecimal("230.45")
        );

        pepe.reservar(v1, 5);

        // for (Reserva reserva : pepe) {
        //     System.out.println("Código vuelo: " + reserva.getVuelo().getCodigo());
        //     System.out.println("Asiento: " + reserva.getAsiento());
        //     System.out.println("Origen: " + reserva.getVuelo().getOrigen());
        //     System.out.println("Destino: " + reserva.getVuelo().getDestino());
        //     System.out.println("Compañía: " + reserva.getVuelo().getCompania());
        // }

        // System.out.println();

        // for (Reserva reserva : v1) {
        //     System.out.println("Código vuelo: " + v1.getCodigo());
        //     System.out.println("Asiento: " + reserva.getAsiento());
        //     System.out.println("Origen: " + reserva.getVuelo().getOrigen());
        //     System.out.println("Destino: " + reserva.getVuelo().getDestino());
        //     System.out.println("Compañía: " + reserva.getVuelo().getCompania());
        //     System.out.println("Usuario: " + reserva.getUsuario());
        // }

        // loguear al usuario
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

        // mostrar las reservas del usuario
        for (Reserva reserva : usuario) {
            System.out.println(reserva);
        }

        //     - crear una nueva reserva
        //     - ver el detalle de una reserva
    }
}
