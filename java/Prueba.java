/*
 * Escribir un programa que pida al usuario una cadena introducida
 * por la entrada estándar y mostrar por la salida el número de
 * caracteres que contiene. Si la cadena es vacía, se termina la
 * ejecución.
 */

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca una cadena: ");
            String s = sc.nextLine();
            sb.append(s);
        }

        sc.close();
        System.out.println(sb);
    }
}
