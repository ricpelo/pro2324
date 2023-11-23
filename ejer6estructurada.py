# 6. Escribir un programa que muestre por pantalla la tabla
# de multiplicar de un número comprendido entre 0 y 10,
# introducido por teclado.

def pedir_numero_valido():
    while True:
        try:
            n = int(input('Introduzca el número: '))
            if n not in range(0, 11):
                print('El número debe estar comprendido entre 0 y 10.')
                continue
            return n
        except ValueError:
            print('El dato introducido no es un número válido.')


def imprimir_tabla_multiplicar(n):
    i = 0
    while i <= 10:
        print(n, 'x', i, '=', i * n)
        i += 1

numero = pedir_numero_valido()
imprimir_tabla_multiplicar(numero)
