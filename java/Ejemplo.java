public class Ejemplo {
    public static void main(String[] args) {
        Prueba p = new Prueba();

        p.x = 50;
        p.saludo("Ricardo"); // Correcto
        // p.oculto();                 // Error: «oculto» es privado en «Prueba»
    }
}


class Prueba {
    public int x = 4;

    public void saludo(String nombre) {
        System.out.println(x);
        System.out.println("¡Hola, " + nombre + "!");
    }

    private void oculto() {
        System.out.println("No se puede llamar desde fuera de «Prueba»");
    }
}


class Cliente {
    private String nombre = "Manolo";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
