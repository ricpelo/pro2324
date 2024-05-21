import java.util.Arrays;

public class CuadradoSecuencia {
    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(Cuadrado.cuadrado(1), new int[][] { {1} }));
        System.out.println(Arrays.deepEquals(Cuadrado.cuadrado(2), new int[][] { {1, 2}, {2, 1} }));
        System.out.println(Arrays.deepEquals(Cuadrado.cuadrado(3), new int[][] { {1, 2, 3}, {3, 1, 2}, {2, 3, 1} }));
        System.out.println(Arrays.deepEquals(Cuadrado.cuadrado(4), new int[][] { {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1} }));
    }
}

class Cuadrado {
    public static int[][] cuadrado(int n) {
        if (n <= 0) {
            return new int[0][];
        }

        int[][] res = new int[n][n];
        int[] fila = new int[n];

        // Prepara la primera fila del resultado:
        for (int i = 0; i < n; i++) {
            fila[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            // Copia la fila en el resultado:
            System.arraycopy(fila, 0, res[i], 0, n);
            // Rotación de fila para la siguiente iteración:
            int ultimo = fila[n - 1];
            System.arraycopy(fila, 0, fila, 1, n - 1);
            fila[0] = ultimo;
        }

        return res;
    }
}
