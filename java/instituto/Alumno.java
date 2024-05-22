import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Alumno {
    private long numero;
    private String nombre;
    private Grupo grupo;
    private Set<Asignatura> asignaturas;
    private Map<Asignatura, Map<Trimestre, Nota>> notas;

    public Alumno(long numero, String nombre, Grupo grupo) {
        this.numero = numero;
        this.nombre = nombre;
        setGrupo(grupo);
        asignaturas = new HashSet<>();
        // notas = new
    }

    public void matricular(Asignatura asignatura) {
        asignaturas.add(asignatura);
        if (!asignatura.matriculado(this)) {
            asignatura.matricular(this);
        }
    }

    public void desmatricular(Asignatura asignatura) {
        asignaturas.remove(asignatura);
    }

    public boolean matriculado(Asignatura asignatura) {
        return asignaturas.contains(asignatura);
    }

    public String getNombre() {
        return nombre;
    }

    public long getNumero() {
        return numero;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        if (this.grupo != null) {
            this.grupo.eliminarAlumno(this);
        }
        this.grupo = grupo;
        if (this.grupo != null) {
            this.grupo.insertarAlumno(this);
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Alumno)) {
            return false;
        }

        Alumno alumno = (Alumno) obj;
        return numero == alumno.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
