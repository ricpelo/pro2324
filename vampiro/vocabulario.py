"""
El vocabulario del juego.
"""

T_VERBO = 1
T_NOMBRE = 2

NORTE = (1, T_VERBO)
SUR = (2, T_VERBO)
COGER = (3, T_VERBO)
CUCHILLO = (4, T_NOMBRE)
OESTE = (5, T_VERBO)
ESTE = (6, T_VERBO)
MIRAR = (7, T_VERBO)

vocabulario = {
    'N': NORTE,
    'NORTE': NORTE,
    'S': SUR,
    'SUR': SUR,
    'O': OESTE,
    'OESTE': OESTE,
    'E': ESTE,
    'ESTE': ESTE,
    'COGER': COGER,
    'COGE': COGER,
    'TOMAR': COGER,
    'TOMA': COGER,
    'RECOGER': COGER,
    'RECOGE': COGER,
    'CUCHILLO': CUCHILLO,
    'MIRAR': MIRAR,
    'M': MIRAR
}


def esta(lexema: str) -> bool:
    """
    Comprueba si en el vocabulario hay una palabra con ese lexema.
    """
    return palabra(lexema) is not None


def palabra(lexema: str) -> tuple|None:
    """
    Devuelve una palabra del vocabulario a partir de su lexema.
    Devuelve None si la palabra no existe.
    """
    return vocabulario.get(lexema)


def tipo(palab: tuple|None):
    """
    Devuelve el tipo de la palabra indicada.
    """
    if palab is not None:
        return palab[1]
    return None
