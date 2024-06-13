import java.util.Arrays;

public class Cons {
    public static void main(String[] args) {
        System.out.println(cons(new int[] { 5, 1, 4, 3, 2 }));
        System.out.println(cons(new int[] { 5, 1, 4, 3, 2, 8 }));
        System.out.println(cons(new int[] { 5, 6, 7, 8, 9, 9 }));
    }

    public static boolean cons(int[] arr) {
        Arrays.sort(arr);
        int ultimo = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != ultimo + 1) {
                return false;
            }
            ultimo = arr[i];
        }

        return true;
    }
}
