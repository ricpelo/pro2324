package peliculas;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import salas.Sala;

public class Pelicula {
    private static long ultimoCodigo = 0L;
    private long codigo;
    private Sesion[] sesiones;
    private int cantidadSesiones = 0;
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        codigo = ++ultimoCodigo;
        sesiones = new Sesion[1];
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

    private Sesion[] eliminarElemento(Sesion[] sesiones, int i) {
        Sesion[] nuevo = new Sesion[cantidadSesiones - 1];
        System.arraycopy(sesiones, 0, nuevo, 0, i);
        System.arraycopy(sesiones, i + 1, nuevo, i, cantidadSesiones - i - 1);
        return nuevo;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void insertarSesion(Date fechaHora, Sala sala, BigDecimal precioBase) {
        Sesion sesion = new Sesion(fechaHora, sala, precioBase);
        for (int i = 0; i < cantidadSesiones; i++) {
            if (sesiones[i].equals(sesion)) {
                return;
            }
        }
        if (cantidadSesiones >= sesiones.length) {
            sesiones = Arrays.copyOf(sesiones, (int) (sesiones.length * 1.5f));
        }
        sesiones[cantidadSesiones++] = sesion;
    }

    public void eliminarSesion(Date fechaHora, Sala sala) {
        Sesion sesion = new Sesion(fechaHora, sala);
        for (int i = 0; i < cantidadSesiones; i++) {
            if (sesiones[i].equals(sesion)) {
                sesiones = eliminarElemento(sesiones, i);
                cantidadSesiones--;
            }
        }
    }

    public int getCantidadSesiones() {
        return cantidadSesiones;
    }

    public Sesion getSesion(int numeroSesion) {
        return sesiones[numeroSesion];
    }
}
