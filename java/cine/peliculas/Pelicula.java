package peliculas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import salas.Sala;

public class Pelicula {
    private static long ultimoCodigo = 0L;
    private long codigo;
    private List<Sesion> sesiones;
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        codigo = ++ultimoCodigo;
        sesiones = new ArrayList<>();
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

    public long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void insertarSesion(Date fechaHora, Sala sala, BigDecimal precioBase) {
        Sesion sesion = new Sesion(fechaHora, sala, precioBase);
        if (sesiones.contains(sesion)) {
            return;
        }
        sesiones.add(sesion);
    }

    public void eliminarSesion(Date fechaHora, Sala sala) {
        Sesion sesion = new Sesion(fechaHora, sala);
        sesiones.remove(sesion);
    }

    public int getCantidadSesiones() {
        return sesiones.size();
    }

    public Sesion getSesion(int numeroSesion) {
        return sesiones.get(numeroSesion);
    }
}
