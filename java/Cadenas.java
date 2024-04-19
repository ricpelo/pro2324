public class Cadenas {
    public static void main(String[] args) {
        String s = "Hola";
        StringBuilder sb = new StringBuilder("Pepe");
        StringBuffer sbf = new StringBuffer("Manolo");

        System.out.println(s instanceof CharSequence);

        System.out.println(longitud(s));
        System.out.println(longitud(sb));
        System.out.println(longitud(sbf));
    }

    public static int longitud(CharSequence s) {
        return s.length();
    }
}
