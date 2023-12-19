"""
Un anagrama es una palabra que resulta del cambio del orden de los caracteres de
otra. Ejemplos de anagramas para la palabra roma son: amor, ramo o mora. Escribir un
programa que solicite al usuario dos palabras e indique si son anagramas una de otra.
"""

def es_anagrama(p1: str, p2: str) -> bool:
    """Comprueba si las dos palabras son anagramas una de la otra."""
    return sorted(p1) == sorted(p2)


palabra1 = input('Introduzca la primera palabra: ')
palabra2 = input('Introduzca la segunda palabra: ')

if es_anagrama(palabra1, palabra2):
    print('Son anagramas.')
else:
    print('NO son anagramas.')
