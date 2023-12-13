"""
Escribir en Python una función mas_repetido(lista) que reciba una
lista de números y que devuelva un conjunto que contenga el que
más se repita dentro de la lista:

mas_repetido([1, 7, 5, 8, 2, 6, 5, 9]) == {5}

Si hay más de un número que se repita el número máximo de veces,
deberá devolver un conjunto con todos ellos:
mas_repetido([1, 7, 5, 8, 1, 6, 5, 9]) == {1, 5}

Si la lista está vacía, deberá devolver un conjunto vacío (set()).

Tests:
mas_repetido([1, 7, 5, 8, 2, 6, 5, 9]) == {5}
mas_repetido([1, 7, 5, 8, 1, 6, 5, 9]) == {1, 5}
"""

def mas_repetido(lista):
    """Devuelve  el elemento o elementos que más se repiten."""
    if lista == []:
        return set()
    maximo = max(lista.count(e) for e in lista)
    res = {e for e in lista if lista.count(e) == maximo}
    return res
