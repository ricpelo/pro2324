import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Asignatura {
    private String codigo;
    private String denominacion;
    private Set<Trimestre> trimestres;
    private Set<Alumno> alumnos;

    public Asignatura(String codigo, String denominacion, Collection<Trimestre> trimestres) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.trimestres = new TreeSet<>(trimestres);
        this.alumnos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public Set<Trimestre> getTrimestres() {
        return new TreeSet<Trimestre>(trimestres);
    }

    public void matricular(Alumno alumno) {
        alumnos.add(alumno);
        if (!alumno.matriculado(this)) {
            alumno.matricular(this);
        }
    }

    public void desmatricular(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public boolean matriculado(Alumno alumno) {
        return alumnos.contains(alumno);
    }
}
