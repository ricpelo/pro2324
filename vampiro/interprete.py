"""
Módulo relacionado con la entrada del jugador, incluyendo
su filtrado e interpretación.
"""

import vocabulario as voc

def _filtrar_entrada_valida(entrada: str) -> list[str]:
    """
    Devuelve la entrada del jugador separando cada palabra
    y eliminando las que no pertenecen al vocabulario
    """
    return [x for x in entrada.split() if voc.vocabulario.esta(x)]


def recoger_entrada_jugador() -> list[str]:
    """
    Solicita al jugador la siguiente entrada.
    """
    print('¿Qué quieres hacer ahora?')
    entrada = input('> ').rstrip().upper()
    return _filtrar_entrada_valida(entrada)


def validar(entrada: list[str]) -> bool:
    """
    Comprueba si la entrada del jugador está correctamente
    escrita según las reglas gramaticales del juego.
    """
    if len(entrada) not in (1, 2):
        return False

    palabra = voc.vocabulario.buscar_palabra(entrada[0])

    if palabra.tipo() != voc.T_VERBO:
        return False

    if len(entrada) == 1:
        return True

    palabra = voc.vocabulario.buscar_palabra(entrada[1])
    return palabra.tipo() == voc.T_NOMBRE


def decodificar(entrada: list[str]) -> tuple[voc.Palabra,voc.Palabra|None]:
    """
    Decodifica la entrada del jugador y la convierte en una
    tupla (verbo, nombre).
    """
    verbo = voc.vocabulario.buscar_palabra(entrada[0])
    nombre = None

    if len(entrada) > 1:
        nombre = voc.vocabulario.buscar_palabra(entrada[1])

    return (verbo, nombre)
