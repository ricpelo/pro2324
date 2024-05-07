import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Principal {
    public static void main(String[] args) {
        Compania iberia = new Compania("Iberia");
        Compania ryanair = new Compania("Ryanair");
        Aeropuerto jerez = new Aeropuerto("XRY", "Jerez");
        Aeropuerto sevilla = new Aeropuerto("SVQ", "Sevilla");
        Usuario pepe = new Usuario("pepe@gmail.com", "pepito");
        Usuario juan = new Usuario("juan@gmail.com", "juanito");
        Vuelo v1 = new Vuelo(
            "RY3214",
            200,
            jerez,
            sevilla,
            ryanair,
            (new GregorianCalendar(2024, 5, 8, 12, 25)).getTime(),
            (new GregorianCalendar(2024, 5, 8, 14, 25)).getTime(),
            new BigDecimal("230.45")
        );
        pepe.reservar(v1, 5);

        for (Reserva reserva : pepe) {
            System.out.println("Código vuelo: " + reserva.getVuelo().getCodigo());
            System.out.println("Asiento: " + reserva.getAsiento());
            System.out.println("Origen: " + reserva.getVuelo().getOrigen());
            System.out.println("Destino: " + reserva.getVuelo().getDestino());
            System.out.println("Compañía: " + reserva.getVuelo().getCompania());
        }

        System.out.println();

        for (Reserva reserva : v1) {
            System.out.println("Código vuelo: " + v1.getCodigo());
            System.out.println("Asiento: " + reserva.getAsiento());
            System.out.println("Origen: " + reserva.getVuelo().getOrigen());
            System.out.println("Destino: " + reserva.getVuelo().getDestino());
            System.out.println("Compañía: " + reserva.getVuelo().getCompania());
            System.out.println("Usuario: " + reserva.getUsuario());
        }
    }
}
