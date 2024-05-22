public class Nota {
    private Asignatura asignatura;
    private Trimestre trimestre;
    private float nota;

    public Nota(Asignatura asignatura, Trimestre trimestre, float nota) {
        this.asignatura = asignatura;
        this.trimestre = trimestre;
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public float getNota() {
        return nota;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

}
