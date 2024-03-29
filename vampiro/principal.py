"""
Módulo principal del juego del Vampiro.
"""

import mapa
import item
import interprete
import vocabulario as voc

def describir_lugar_actual() -> None:
    """Describe el lugar actual."""
    lugar_actual.describir_lugar()


lugar_actual = mapa.vestibulo

describir_lugar_actual()

while True:
    entrada = interprete.recoger_entrada_jugador()

    if not interprete.validar(entrada):
        print('No entiendo lo que dices.')
        continue

    verbo, nombre = interprete.decodificar(entrada)
    destino = mapa.mapa.destino(lugar_actual, verbo)

    if destino is not None:
        lugar_actual = destino
        describir_lugar_actual()
    elif verbo == voc.SUR and lugar_actual == mapa.vestibulo:
        print('Ni pienses en salir de aquí sin haber completado tu misión.')
    elif verbo == voc.MIRAR:
        describir_lugar_actual()
    elif verbo == voc.INVENTARIO:
        print('LLEVAS:')
        mapa.inventario.listar_items()
    elif verbo == voc.COGER:
        if nombre == voc.CUCHILLO:
            if item.CUCHILLO.lugar() == lugar_actual:
                item.CUCHILLO.coger()
            else:
                print('No veo ningún cuchillo por aquí.')
        else:
            print('No sé qué quieres que coja.')
    else:
        print('No puedes hacer eso.')
