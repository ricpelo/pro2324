
class Animal {
    protected String nombre = "Gato con botas";

    void moverse() {
        System.out.println("Me muevo");
    }

    public void saludar() {
        System.out.println("Hola");
    }
}

class Gato extends Animal {
    @Override
    public void saludar() {
        System.out.println("Miau");
    }
}

class Perro extends Animal {
    @Override
    public void saludar() {
        System.out.println("Guau");
    }
}

class Base {
    public String hola(String s) {
        return "Hola, " + s + ", soy la clase Base";
    }

    public void saludar(Animal a) {
        a.saludar();
    }
}

class Derivada extends Base {
    @Override
    public String hola(String s) {
        return "Hola, " + s + ", soy la clase Derivada";
    }
}

public class Animales {
    public static void main(String[] args) {

        Number[] n = new Integer[5];
        Number[] m = { 1, 2, 3, 4, 5 };

        Derivada d = new Derivada();
        Base b = new Derivada();
        System.out.println(b.hola("Pepe"));
    }
}
