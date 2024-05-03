package peliculas;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import salas.Sala;

public class Pelicula implements Iterable<Sesion> {
    private static long ultimoCodigo = 0L;
    private long codigo;
    private Set<Sesion> sesiones;
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        codigo = ++ultimoCodigo;
        sesiones = new TreeSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pelicula)) {
            return false;
        }

        Pelicula pelicula = (Pelicula) obj;
        return codigo == pelicula.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public Iterator<Sesion> iterator() {
        return sesiones.iterator();
    }

    public long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void insertarSesion(Date fechaHora, Sala sala, BigDecimal precioBase) {
        Sesion sesion = new Sesion(fechaHora, sala, precioBase);
        sesiones.add(sesion);
    }

    public void eliminarSesion(Date fechaHora, Sala sala) {
        Sesion sesion = new Sesion(fechaHora, sala);
        sesiones.remove(sesion);
    }

    public int getCantidadSesiones() {
        return sesiones.size();
    }
}
