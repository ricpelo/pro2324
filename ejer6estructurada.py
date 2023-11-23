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

def imprimir_tabla_multiplicar(n: int) -> None:
    """Imprime la tabla de multiplicar de n."""
    i = 0
    while i <= 10:
        print(n, 'x', i, '=', i * n)
        i += 1

def validar_numero(n: int, ini: int, fin: int) -> bool:
    """Comprueba si un número está dentro de un rango."""
    if n not in range(ini, fin + 1):
        return False
    return True

while True:
    numero = pedir_numero()
    if validar_numero(numero, 0, 10):
        break
    print('El número no está comprendido entre 0 y 10.')
imprimir_tabla_multiplicar(numero)
