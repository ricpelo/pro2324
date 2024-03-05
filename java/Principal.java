/*
 * ¡Hola, mundo!
 */

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        boolean mostrado = false;

        for (;;) {
            System.out.print("Introduzca un número entre 0 y 10: ");

            while (!sc.hasNextInt()) {
                if (!mostrado) {
                    System.out.println("El dato introducido no es un número entero");
                    mostrado = true;
                }
                sc.next();
            }

            mostrado = false;
            numero = sc.nextInt();

            if (numero >= 0 && numero <= 10) {
                break;
            }

            System.out.println("El número no está comprendido entre 0 y 10");
        };

        sc.close();

        for (int i = 0; i <= 10; i++) {
            System.out.print(numero);
            System.out.print(" x ");
            System.out.print(i);
            System.out.print(" = ");
            System.out.println(numero * i);
        }
    }
}
