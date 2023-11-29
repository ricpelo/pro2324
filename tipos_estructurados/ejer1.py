"""
1. Crear una función que devuelva el valor del último elemento
de una lista o cadena.

Notas

• Las listas/cadenas pueden ser de cualquier tamaño.
• Devuelve None si la lista/cadena está vacía.
"""

def last_ind(s: list|str):
    """
    Función que devuelve el valor del último elemento de una
    lista o cadena.

    Ejemplos:

    >>> last_ind([0, 4, 19, 34, 50, -9, 2])
    2
    >>> last_ind("The quick brown fox jumped over the lazy dog")
    'g'
    >>> last_ind([])
    None
    """
    return s[-1] if len(s) > 0 else None
