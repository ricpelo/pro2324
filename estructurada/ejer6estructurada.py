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


def pedir_numero_valido() -> int:
    """Solicita un número válido al usuario (entre 0 y 10)."""
    def validar_numero(ini: int, fin: int) -> bool:
        """Comprueba si un número está dentro de un rango."""
        return n in range(ini, fin + 1)
    while True:
        n = pedir_numero()
        if validar_numero(0, 10):
            return n
        print('El número no está comprendido entre 0 y 10.')


def imprimir_tabla_multiplicar(n: int) -> None:
    """Imprime la tabla de multiplicar de n."""
    for i in range(11):
        # print(n, 'x', i, '=', i * n)
        print(f'{n:>2} x {i:>2} = {i * n:>3}')


numero = pedir_numero_valido()
imprimir_tabla_multiplicar(numero)
