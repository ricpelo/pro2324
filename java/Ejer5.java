import java.util.Arrays;
import java.util.Scanner;

public class Ejer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        int proximo = 0;
        int n;

        for (;;) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if (proximo >= a.length) {
                a = Arrays.copyOf(a, (int) (1.5f * a.length));
            }
            a[proximo++] = n;
        }

        for (int i = 0; i < proximo; i++) {
            System.out.println(a[i]);
        }
    }
}
