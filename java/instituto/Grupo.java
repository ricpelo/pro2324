import java.util.HashSet;
import java.util.Set;

public class Grupo {
    private String nombre;
    private Set<Alumno> alumnos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void insertarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }
}
