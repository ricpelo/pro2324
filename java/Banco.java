public class Banco {
    public static void main(String[] args) {
        Cliente antonio = new Cliente("111", "Pepe", "Pérez");
        antonio.setDni("123123");

        Movimiento m = new Movimiento("Ingreso", 10.35f);
    }
}

class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;

    public Cliente(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}

class Movimiento {
    private String concepto;
    private float cantidad;

    public Movimiento(String concepto, float cantidad) {
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public float getCantidad() {
        return cantidad;
    }
}
