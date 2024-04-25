import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import peliculas.Pelicula;
import peliculas.Sesion;
import salas.Sala;

public class Principal {
    public static void main(String[] args) {
        Sala uno = new Sala(1, 30);
        Sala dos = new Sala(2, 40);
        Pelicula starwars = new Pelicula("Star Wars");
        Calendar c = new GregorianCalendar();
        c.set(2024, 4, 26, 18, 30);
        starwars.insertarSesion(
            c.getTime(),
            dos,
            new BigDecimal("4.50").setScale(2)
        );
        Sesion sesion = starwars.getSesion(0);
        Entrada entrada = new Entrada(sesion, sesion.getSala().getAsiento(2));
        System.out.println(entrada.getPrecio());
    }
}
