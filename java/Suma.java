public class Suma {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5 };
        long suma = 0L;

        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }

        System.out.println("La suma es " + suma);
    }
}
