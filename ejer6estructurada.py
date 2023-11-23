"""
6. Escribir un programa que muestre por pantalla la tabla
de multiplicar de un número comprendido entre 0 y 10,
introducido por teclado.
"""

def pedir_numero() -> int:
    """Solicita un número al usuario."""
    while True:
        try:
            n = int(input('Introduzca el número: '))
            return n
        except ValueError:
            print('El dato introducido no es un número.')


def validar_numero(n: int, ini: int, fin: int) -> bool:
    """Comprueba si un número está dentro de un rango."""
    return n in range(ini, fin + 1)


def pedir_numero_valido() -> int:
    """Solicita un número válido al usuario (entre 0 y 10)."""
    while True:
        n = pedir_numero()
        if validar_numero(n, 0, 10):
            return n
        print('El número no está comprendido entre 0 y 10.')


def imprimir_tabla_multiplicar(n: int) -> None:
    """Imprime la tabla de multiplicar de n."""
    i = 0
    while i <= 10:
        print(n, 'x', i, '=', i * n)
        i += 1


numero = pedir_numero_valido()
imprimir_tabla_multiplicar(numero)
