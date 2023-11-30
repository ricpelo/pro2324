"""
4 Cantidad total de caracteres únicos
Dadas dos cadenas, crear una función que devuelva el número
total de caracteres únicos de la cadena combinada.

Ejemplos
count_unique("apple", "play") == 5
# "appleplay" tiene 5 caracteres únicos:
# "a", "e", "l", "p", "y"
count_unique("sore", "zebra") == 7
count_unique("a", "soup") == 5

Notas
• Cada palabra contendrá al menos una letra.
• Todas las palabras estarán en minúsculas.
"""

def count_unique(s1: str, s2: str) -> int:
    """
    Dadas dos cadenas, devuelve el número total de
    caracteres únicos de la cadena combinada.
    >>> count_unique("apple", "play")
    5
    >>> count_unique("sore", "zebra")
    7
    >>> count_unique("a", "soup")
    5
    """
    return len(set(s1 + s2))
