"""
Números racionales.
"""

from math import gcd

class Racional:
    """Clase de números racionales."""

    def __init__(self, numer: int, denom: int) -> None:
        g = gcd(numer, denom)
        self._numer = numer // g
        self._denom = denom // g

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self.numer() * __value.denom() == __value.numer() * self.denom()

    def numer(self) -> int:
        return self._numer

    def denom(self) -> int:
        return self._denom

    def suma(self, otro):
        nx, dx = self.numer(), self.denom()
        ny, dy = otro.numer(), otro.denom()
        return Racional(nx * dy + ny * dx, dx * dy)

    def imprimir(self):
        """Imprime un racional por la salida."""
        print(self.numer(), '/', self.denom(), sep='')


def racional(n, d):
    """Un racional es una lista que contiene el numerador y el denominador."""
    g = gcd(n, d)
    return [n // g, d // g]

def numer(x):
    """El numerador es el primer elemento de la lista."""
    return x[0]

def denom(x):
    """El denominador es el segundo elemento de la lista."""
    return x[1]

def suma(x, y):
    """Suma dos racionales."""
    nx, dx = numer(x), denom(x)
    ny, dy = numer(y), denom(y)
    return racional(nx * dy + ny * dx, dx * dy)

def mult(x, y):
    """Multiplica dos racionales."""
    return racional(numer(x) * numer(y), denom(x) * denom(y))

def iguales(x, y):
    """Comprueba si dos racionales son iguales."""
    return numer(x) * denom(y) == numer(y) * denom(x)

def imprimir(x):
    """Imprime un racional por la salida."""
    print(numer(x), '/', denom(x), sep='')

# def potencia(r, e):
#     """Devuelve el racional r elevado a e."""
#     return racional(numer(r) ** e, denom(r) ** e)

def potencia(r, e):
    """Devuelve el racional r elevado a e."""
    res = r
    for _ in range(e - 1):
        res = mult(res, r)
    return res
