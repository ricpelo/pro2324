public class PilaPrincipal {
    public static void main(String[] args) {
        Pila<String> p = new Pila<>();
        var i = new Pila<Integer>();

        p.apilar("Hola");
        i.apilar(25);
        p.desapilar();
        System.out.println(i.cima());
    }
}
