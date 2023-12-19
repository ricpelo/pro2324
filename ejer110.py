"""
El juego de los anagramas.
"""

import random

def palabra_aleatoria():
    """Devuelve una palabra aleatoria."""
    num_lineas = 0

    with open('/usr/share/dict/words') as f:
        while True:
            if f.readline() == '':
                break
            num_lineas += 1

    num_linea = random.randrange(1, num_lineas + 1)
    res = ''

    with open('/usr/share/dict/words') as f:
        for _ in range(num_linea):
            res = f.readline().rstrip()

    return res


objetivo = palabra_aleatoria()
anagrama = ''.join(random.sample(objetivo, k=len(objetivo)))

while True:
    print('El anagrama es:', anagrama)
    entrada = input('Introduzca su posible solución: ')
    if entrada == objetivo:
        break
    print('Mal')

print('¡Ganó!')
