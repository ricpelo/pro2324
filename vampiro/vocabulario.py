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

    def __str__(self) -> str:
        return self._etiqueta

    def etiqueta(self):
        """Devuelve la etiqueta de la palabra."""
        return self._etiqueta


class Palabra:
    """Una palabra del diccionario."""

    cantidad = 0
    entradas_vocabulario = {}

    def __init__(self, tipo_palabra: TipoPalabra, lexemas: list[str]) -> None:
        self.__tipo_palabra = tipo_palabra
        self.__lexemas = lexemas
        Palabra.cantidad += 1
        for lexema in lexemas:
            Palabra.entradas_vocabulario[lexema] = self

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self.etiqueta() == __value.etiqueta() and \
            self.tipo() == __value.tipo()

    def __hash__(self) -> int:
        return hash((self.etiqueta(), self.tipo()))

    def __repr__(self) -> str:
        return f'Palabra({self.etiqueta()!r}, {self.tipo()!r})'

    def __str__(self) -> str:
        return f'Palabra {self.etiqueta()}, de tipo {self.tipo()!s}'

    def etiqueta(self) -> str:
        """Devuelve la etiqueta de la palabra."""
        return self.__lexemas[0]

    def tipo(self) -> TipoPalabra:
        """Devuelve el tipo de la palabra."""
        return self.__tipo_palabra


class Vocabulario:
    """El vocabulario de las palabras que entiende la aventura."""

    def __init__(self, _entradas = {}) -> None:
        self._entradas: dict[str, Palabra] = _entradas
        assert len(_entradas) >= 0

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self._entradas == __value._entradas

    def __repr__(self) -> str:
        return f'Vocabulario({self._entradas!r})'

    def insertar_entrada(self, lexema: str, palabra: Palabra) -> None:
        """Inserta una palabra en el vocabulario."""
        cantidad_antes = self.cantidad()
        self._entradas[lexema] = palabra
        cantidad_despues = self.cantidad()
        assert cantidad_despues - cantidad_antes in range(0, 2)

    def cantidad(self) -> int:
        """Devuelve la cantidad de palabras que contiene el vocabulario."""
        longitud = len(self._entradas)
        assert longitud >= 0
        return longitud

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

NORTE = Palabra(T_VERBO, ['NORTE', 'N'])
SUR = Palabra(T_VERBO, ['SUR', 'S'])
COGER = Palabra(T_VERBO, ['COGER', 'COGE', 'TOMAR', 'TOMA', 'RECOGER', 'RECOGE'])
CUCHILLO = Palabra(T_NOMBRE, ['CUCHILLO'])
OESTE = Palabra(T_VERBO, ['OESTE', 'O'])
ESTE = Palabra(T_VERBO, ['ESTE', 'E'])
MIRAR = Palabra(T_VERBO, ['MIRAR', 'M'])
INVENTARIO = Palabra(T_VERBO, ['INVENTARIO', 'I'])

vocabulario = Vocabulario(Palabra.entradas_vocabulario)
