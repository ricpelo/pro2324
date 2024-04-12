abstract class Animal {
    String nombre;

    Animal(String nombre) {
        this.nombre = nombre;
        System.out.println("Se ha creado un animal");
    }
}

class Perro extends Animal {
    String raza;

    Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
        System.out.println("Se ha creado un perro");
    }
}

public class Constructores {
    public static void main(String args[]) {
        Perro p = new Perro("Manolo", "Collie");
    }
}
