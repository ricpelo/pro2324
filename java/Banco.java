public class Banco {
    public static void main(String[] args) {
        Cliente antonio = new Cliente();
        antonio.setDni("123123");
    }
}

class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
