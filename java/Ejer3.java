public class Ejer3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("¡Hola, ");

        if (args.length > 0) {
            sb.append(args[0]);
            sb.append('!');
            System.out.println(sb);
        } else {
            System.err.println("Por favor, proporcione un nombre.");
        }
    }
}
