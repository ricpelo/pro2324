public class Ejer10 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        final int n;
        int[][] a;

        System.out.print("Introduzca el valor de N: ");
        n = sc.nextInt();
        sc.close();

        if (n == 0) {
            a = new int[0][]; // Array de 0 elementos
        } else {
            a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = n;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
