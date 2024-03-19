import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] cuadrado;
        int fila, col, n;

        for (;;) {
            System.out.print("Introduzca el valor de n: ");
            n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Mal.");
            } else if (n % 2 == 0) {
                System.out.println("Mal también.");
            } else {
                break;
            }
        }

        sc.close();

        // Crear el cuadrado mágico:
        cuadrado = new int[n][n];
        fila = 0;
        col = n / 2;

        for (int i = 1; i <= n * n; i++) {
            cuadrado[fila][col] = i;
            int fila_ant = fila, col_ant = col;
            fila = (fila > 0) ? fila - 1 : n - 1;
            col = (col < n - 1) ? col + 1 : 0;
            if (cuadrado[fila][col] != 0) {
                fila = fila_ant + 1;
                col = col_ant;
            }
        }

        // Mostrar el cuadrado mágico por la salida:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2s", cuadrado[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        // Comprobación:
        int suma;

        for (int i = 0; i < n; i++) {
            suma = 0;
            for (int j = 0; j < n; j++) {
                suma += cuadrado[i][j];
            }
            System.out.printf("%3s", suma);
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            suma = 0;
            for (int j = 0; j < n; j++) {
                suma += cuadrado[j][i];
            }
            System.out.printf("%3s", suma);
        }

        System.out.println();
        suma = 0;

        for (int i = 0; i < n; i++) {
            suma += cuadrado[i][i];
        }

        System.out.println(suma);

        suma = 0;

        for (int i = 0; i < n; i++) {
            suma += cuadrado[i][n - i - 1];
        }

        System.out.println(suma);
    }
}
