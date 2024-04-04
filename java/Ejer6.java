/**
 * Crear la clase Empleado con campos nombre y apellidos.
 * A partir de ellos, crear los métodos nombreCompleto y email
 * de la siguiente forma:
 * • El nombreCompleto será simplemente el nombre y los apellidos
 * unidos con un espacio en blanco.
 * • El email se forma con el nombre y los apellidos (todo en
 * minúsculas) unidos con un . intermedio y seguido de @company.com.
 * Ejemplos:
 * >>> Empleado emp1 = new Empleado("Juan", "Pérez")
 * >>> Empleado emp2 = new Empleado("María", "García")
 * >>> Empleado emp3 = new Empleado("Antonio", "González")
 * >>> emp1.nombreCompleto()
 * "Juan Pérez"
 * >>> emp2.email()
 * "maría.garcía@company.com"
 * >>> emp3.nombre
 * "Antonio"
 */

public class Ejer6 {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado("Juan", "Pérez");
        Empleado x = new Empleado();
        System.out.println(Empleado.veces);
        System.out.println(x.nombreCompleto());
        System.out.println(emp1.nombreCompleto());
        System.out.println(emp1.email());
        System.out.println(Empleado.estatico());
    }
}

class Empleado {
    public String nombre;
    public String apellidos;

    public static int veces = 0;

    Empleado() {
        nombre = "John";
        apellidos = "Doe";
        veces++;
    }

    Empleado(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        veces++;
    }

    public String nombreCompleto() {
        return nombre + ' ' + apellidos + ' ' + estatico();
    }

    public String email() {
        return nombreCompleto().toLowerCase();
    }

    public static String estatico() {
        return "Hola, soy el método estático";
    }
}
