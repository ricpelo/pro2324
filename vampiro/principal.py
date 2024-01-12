"""
Módulo principal del juego del Vampiro.
"""

import mapa
import interprete

def describir_lugar_actual():
    """Describe el lugar actual."""
    mapa.describir_lugar(lugar_actual)

lugar_actual = mapa.vestibulo

describir_lugar_actual()

while True:
    entrada = interprete.recoger_entrada_jugador()

    if not interprete.validar(entrada):
        print('No entiendo lo que dices.')
        continue

    verbo, nombre = interprete.decodificar(entrada)

    print(f'El verbo es {verbo} y el nombre es {nombre}.')

    destino = mapa.destino(lugar_actual, verbo)
    if destino is not None:
        lugar_actual = destino
        describir_lugar_actual()
