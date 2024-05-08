public class Aeropuerto extends ActiveRecord {
    private String nombre;

    public Aeropuerto(String codigo, String nombre) {
        super(codigo);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(super.toString());
        sb.append(") ");
        sb.append(nombre);
        return sb.toString();
    }

    public static Aeropuerto find(String codigo) {
        return (Aeropuerto) ActiveRecord.find(codigo);
    }
}
