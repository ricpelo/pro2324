"""
Módulo relacionado con la entrada del jugador, incluyendo
su filtrado e interpretación.
"""

import vocabulario as voc

def filtrar_entrada_valida(entrada: str) -> list:
    """
    Devuelve la entrada del jugador separando cada palabra
    y eliminando las que no pertenecen al vocabulario
    """
    return [x for x in entrada.split() if voc.esta(x)]


def recoger_entrada_jugador():
    """
    Solicita al jugador la siguiente entrada.
    """
    print('¿Qué quieres hacer ahora?')
    entrada = input('> ').rstrip().upper()
    return filtrar_entrada_valida(entrada)


def validar(entrada: list[str]) -> bool:
    """
    Comprueba si la entrada del jugador está correctamente
    escrita según las reglas gramaticales del juego.
    """
    if len(entrada) not in (1, 2):
        return False
    if voc.tipo(voc.palabra(entrada[0])) != voc.T_VERBO:
        return False
    if len(entrada) == 1:
        return True
    return voc.tipo(voc.palabra(entrada[1])) == voc.T_NOMBRE


def decodificar(entrada: list[str]) -> tuple[str, str|None]:
    """
    hola.
    """
    verbo = entrada[0]
    nombre = None
    if len(entrada) > 1:
        nombre = entrada[1]
    return (verbo, nombre)
