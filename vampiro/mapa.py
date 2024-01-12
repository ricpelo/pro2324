"""
Este módulo proporciona las funcionalidades necesarias para que
el juego disponga de mapeado. Aquí se registrarán los diferentes
lugares que forman el mapa del juego, así como las conexiones
entre ellos y sus descripciones.
"""

import vocabulario as voc

cocina = (
    'COCINA',
    'Estás en la cocina del castillo. Esto está lleno de \
    cacerolas y de cacharros para cocinar. Hay un horno, \
    un fregadero y un armario pequeño.'
)

pasillo = (
    'PASILLO',
    'Te encuentras en medio del pasillo principal de este \
    piso. Al oeste está la cocina y al este la biblioteca. \
    El pasillo sigue hacia el norte.'
)

vestibulo = (
    'VESTÍBULO',
    'Estás en el vestíbulo del castillo. El ambiente es muy \
    húmedo y frío. Un pasillo se extiende hacia el norte. Al \
    sur queda la puerta de entrada al castillo.'
)

conexiones = {
    vestibulo: { voc.NORTE: pasillo },
    pasillo: { voc.SUR: vestibulo, voc.OESTE: cocina },
    cocina: { voc.ESTE: pasillo }
}

def nombre(lugar) -> str:
    """Devuelve el nombre de un lugar."""
    return lugar[0]


def descripcion(lugar) -> str:
    """Devuelve la descripción de un lugar."""
    return lugar[1]


def destino(lugar, direccion: tuple|None):
    """
    Devuelve el destino desde un lugar hacia una dirección,
    o None si no hay salida hacia esa dirección.
    """
    if lugar in conexiones:
        return conexiones[lugar].get(direccion)
    return None


def describir_lugar(lugar) -> None:
    """Describe el lugar al jugador."""
    print(nombre(lugar))
    print(descripcion(lugar))
