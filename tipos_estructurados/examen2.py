"""
Escribir en Python una función diferencia_diagonales(matriz) que
reciba una matriz cuadrada (mismo número de filas que de
columnas) y que devuelva la diferencia (en valor absoluto) de
las sumas de sus diagonales.
"""
from math import sqrt

def diferencia_diagonales(matriz):
    """
    Bla bla bla...
    """
    tam = int(sqrt(len(matriz)))
    suma_principal = sum(v for k, v in matriz.items() if k[0] == k[1])
    suma_secundaria = sum(v for k, v in matriz.items() if k[0] + k[1] == tam - 1)
    return abs(suma_principal - suma_secundaria)
