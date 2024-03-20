import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) {
        final int CANTIDAD = 5;
        Scanner sc = new Scanner(System.in);
        int[] a = new int[CANTIDAD];
        long suma = 0L;

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.print("Introduzca el valor " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            a[i] = sc.nextInt();
            suma += a[i];
        }

        sc.close();

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println(a[i]);
        }

        System.out.println(suma);
    }
}
