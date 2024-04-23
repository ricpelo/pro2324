public class Ejer2ProgMod {
    public static void main(String[] args) {
        Object[] a = new Object[] {
            5,
            "Hola",
            true,
            null,
            new StringBuilder("Manoli")
        };
        metodo(a);
    }

    public static void metodo(Object[] par) {
        for (int i = 0; i < par.length; i++) {
            if (par[i] instanceof CharSequence) {
                CharSequence cs = (CharSequence) par[i];
                System.out.println(cs.length());
            }
        }
    }
}
