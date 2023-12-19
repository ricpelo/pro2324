"""
Escribir un programa que codifique un texto.
"""

def codifica(sec1: str, sec2: str, c: str) -> str:
    """Codifica un carácter."""
    c = c.lower()
    if c in sec1:
        return sec2[sec1.index(c)]
    return c


S1 = 'eikmpqrstuv'
S2 = 'pviumterkqs'

cadena = input('Introduzca la cadena a codificar: ')
res = ''.join(codifica(S1, S2, car) for car in cadena)

print('La cadena codificada es:', res)
