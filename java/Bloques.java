public class Bloques {
    public static void main(String[] args) {
        int x = 25;
        System.out.println("Bloque externo");
        System.out.println(x);
        {
            int y = 14;
            System.out.println("Bloque interno");
            System.out.println(x);
            System.out.println(y);
            x++;
            System.out.println(x);
        }
    }
}
