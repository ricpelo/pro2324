"""
Módulo de funciones matemáticas sencillas.
"""

delta = 5

def suma(x, y):
    """Suma dos números."""
    return x + y + delta

def resta(x, y):
    """Resta dos números."""
    return x - y - delta

def factorial(n):
    """Factorial de un número."""
    return _fact_iter(n, 1)

def _fact_iter(n, acc):
    """Calcula el factorial con una función recursiva iterativa."""
    if n == 0:
        return acc
    return _fact_iter(n - 1, acc * n)

if __name__ == '__main__':
    print('La suma de 4 y 3 es', suma(4, 3))
    print('La resta de 4 y 3 es', resta(4, 3))
    print('El factorial de 5 es', factorial(5))
