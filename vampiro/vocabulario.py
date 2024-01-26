"""
El vocabulario del juego.
"""

class TipoPalabra:
    """Un tipo de palabra."""

    def __init__(self, etiqueta: str) -> None:
        self._etiqueta = etiqueta

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self._etiqueta == __value._etiqueta

    def __hash__(self) -> int:
        return hash(self._etiqueta)

    def __repr__(self) -> str:
        return f'TipoPalabra({self._etiqueta!r})'

    def etiqueta(self):
        """Devuelve la etiqueta de la palabra."""
        return self._etiqueta


class Palabra:
    """Una palabra del diccionario."""

    def __init__(self, etiqueta: str, tipo_palabra: TipoPalabra) -> None:
        self._etiqueta = etiqueta
        self._tipo_palabra = tipo_palabra

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self._etiqueta == __value._etiqueta and \
            self._tipo_palabra == __value._tipo_palabra

    def __hash__(self) -> int:
        return hash((self._etiqueta, self._tipo_palabra))

    def __repr__(self) -> str:
        return f'Palabra({self._etiqueta!r}, {self._tipo_palabra!r})'

    def etiqueta(self) -> str:
        """Devuelve la etiqueta de la palabra."""
        return self._etiqueta

    def tipo(self) -> TipoPalabra:
        """Devuelve el tipo de la palabra."""
        return self._tipo_palabra


class Vocabulario:
    """El vocabulario de las palabras que entiende la aventura."""

    def __init__(self, _entradas = {}) -> None:
        self._entradas: dict[str, Palabra] = _entradas

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self._entradas == __value._entradas

    def __repr__(self) -> str:
        return f'Vocabulario({self._entradas!r})'

    def insertar_entrada(self, lexema: str, palabra: Palabra) -> None:
        """Inserta una palabra en el vocabulario."""
        self._entradas[lexema] = palabra

    def esta(self, lexema: str) -> bool:
        """
        Comprueba si hay una entrada en el vocabulario
        con ese lexema.
        """
        return lexema in self._entradas

    def buscar_palabra(self, lexema: str) -> Palabra:
        """
        Devuelve la palabra asociada al lexema en el
        vocabulario.
        """
        try:
            return self._entradas[lexema]
        except KeyError as exc:
            raise ValueError('Palabra inexistente.') from exc


T_VERBO = TipoPalabra('verbo')
T_NOMBRE = TipoPalabra('nombre')

NORTE = Palabra('NORTE', T_VERBO)
SUR = Palabra('SUR', T_VERBO)
COGER = Palabra('COGER', T_VERBO)
CUCHILLO = Palabra('CUCHILLO', T_NOMBRE)
OESTE = Palabra('OESTE', T_VERBO)
ESTE = Palabra('ESTE', T_VERBO)
MIRAR = Palabra('MIRAR', T_VERBO)
INVENTARIO = Palabra('INVENTARIO', T_VERBO)

_entradas_vocabulario: dict[str,Palabra] = {
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
    'M': MIRAR,
    'I': INVENTARIO,
}

vocabulario = Vocabulario()

for k, v in _entradas_vocabulario.items():
    vocabulario.insertar_entrada(k, v)
