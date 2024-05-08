public class Compania extends ActiveRecord {
    private String nombre;

    public Compania(String codigo, String nombre) {
        super(codigo);
        this.nombre = nombre;
    }

    public static Compania find(String codigo) {
        return (Compania) ActiveRecord.find(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
