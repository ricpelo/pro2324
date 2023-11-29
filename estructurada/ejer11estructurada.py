"""
11. Escribir un programa que determine si un número entero
introducido por teclado es primo o compuesto.
Indicación: Un número primo es aquel que sólo puede dividirse
exactamente por sí mismo y por 1.
"""


def recoger_numero() -> int:
    """Solicita un número al usuario."""
    while True:
        try:
            return int(input('Introduzca un número: '))
        except ValueError:
            print('El dato introducido no es un número.')


def anunciar_primalidad(n: int) -> None:
    """Muestra por la salida la primalidad de n."""
    def cantidad_divisores() -> int:
        """Devuelve la cantidad de divisores de n."""
        return sum(1 for i in range(1, n + 1) if n % i == 0)
    print('El número', n, 'es ', end='')
    print('primo' if cantidad_divisores() == 2 else 'compuesto')


numero = recoger_numero()
anunciar_primalidad(numero)
