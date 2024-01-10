"""
Módulo principal del juego del Vampiro.
"""

import mapa

def describir_lugar_actual():
    """Describe el lugar actual."""
    mapa.describir_lugar(lugar_actual)

lugar_actual = mapa.vestibulo

describir_lugar_actual()

while True:
    print('¿Qué quieres hacer ahora?')
    entrada = input('> ').rstrip().upper()
    destino = mapa.destino(lugar_actual, entrada)
    if destino is not None:
        lugar_actual = destino
        describir_lugar_actual()
