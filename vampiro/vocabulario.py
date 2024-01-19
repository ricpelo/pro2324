"""
El vocabulario del juego.
"""

def crear_tipo_palabra(etiq):
    """Crea un nuevo tipo de palabra."""

    def etiqueta():
        return etiq

    def despacho(mensaje):
        if mensaje == 'etiqueta':
            return etiqueta
        raise ValueError('Mensaje incorrecto.')

    return despacho


def crear_palabra(etiq, tipo_pal):
    """Crea una nueva palabra."""

    def etiqueta():
        """Devuelve la etiqueta de la palabra."""
        return etiq

    def tipo():
        """Devuelve el tipo de la palabra."""
        return tipo_pal

    dic = {
        'etiqueta': etiqueta,
        'tipo': tipo
    }

    def despacho(mensaje):
        """Despacha los mensajes."""
        if mensaje in dic:
            return dic[mensaje]
        raise ValueError('Mensaje incorrecto.')

    return despacho


def crear_vocabulario():
    """Crea un nuevo vocabulario."""

    entradas = {}

    def insertar_entrada(lexema, palabra):
        """Inserta una entrada en el vocabulario."""
        entradas[lexema] = palabra

    def esta(lexema):
        """
        Comprueba si hay una entrada en el vocabulario
        con ese lexema.
        """
        return lexema in entradas

    def buscar_palabra(lexema):
        """
        Devuelve la palabra asociada al lexema en el
        vocabulario.
        """
        if esta(lexema):
            return entradas[lexema]
        raise ValueError('Palabra inexistente.')

    dic = {
        'insertar_entrada': insertar_entrada,
        'esta': esta,
        'buscar_palabra': buscar_palabra
    }

    def despacho(mensaje):
        """Despacha los mensajes."""
        if mensaje in dic:
            return dic[mensaje]
        raise ValueError('Mensaje incorrecto.')

    return despacho


T_VERBO = crear_tipo_palabra('verbo')
T_NOMBRE = crear_tipo_palabra('nombre')

NORTE = crear_palabra('NORTE', T_VERBO)
SUR = crear_palabra('SUR', T_VERBO)
COGER = crear_palabra('COGER', T_VERBO)
CUCHILLO = crear_palabra('CUCHILLO', T_NOMBRE)
OESTE = crear_palabra('OESTE', T_VERBO)
ESTE = crear_palabra('ESTE', T_VERBO)
MIRAR = crear_palabra('MIRAR', T_VERBO)

entradas_vocabulario = {
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

vocabulario = crear_vocabulario()
_insertar = vocabulario('insertar_entrada')

for k, v in entradas_vocabulario.items():
    _insertar(k, v)
