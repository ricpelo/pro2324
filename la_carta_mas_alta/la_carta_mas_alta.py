class Numero:
    @staticmethod
    def valido(numero):
        if isinstance(numero, int):
            return numero in range(2, 11)
        return numero in ['J', 'Q', 'K', 'As']

    def __init__(self, numero: int|str) -> None:
        if not Numero.valido(numero):
            raise ValueError('El número no es válido')
        self.__numero: str = str(numero)
        assert Numero.valido(self.numero())

    def __repr__(self) -> str:
        return f'Numero({self.numero!r})'

    def __str__(self) -> str:
        return self.numero()

    def numero(self) -> str:
        return self.__numero


class Palo:
    def __init__(self, palo: str) -> None:
        self.__palo = palo

    def palo(self) -> str:
        return self.__palo

    def __repr__(self) -> str:
        return f'Palo({self.palo()!r})'

    def __str__(self) -> str:
        return self.palo()


PICAS = Palo('picas')
DIAMANTES = Palo('diamantes')
TREBOLES = Palo('tréboles')
CORAZONES = Palo('corazones')

class Carta:
    def __init__(self, numero: Numero, palo: Palo) -> None:
        self.__numero = numero
        self.__palo = palo

    def __repr__(self) -> str:
        return f'Carta({self.numero()!r}, {self.palo()!r})'

    def __str__(self) -> str:
        return f'{self.numero()} de {self.palo()}'

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self.numero() == __value.numero() and \
            self.palo() == __value.palo()

    def numero(self) -> Numero:
        return self.__numero

    def palo(self) -> Palo:
        return self.__palo

    def valor(self) -> int:
        num = self.numero().numero()
        if isinstance(num, int):
            return num
        valores = {'J': 11, 'Q': 12, 'K': 13, 'As': 14}
        return valores[num]

    def comparar(self, otra) -> int:
        if self.valor() < otra.valor():
            return -1
        if self.valor() == otra.valor():
            return 0
        return 1

baraja = []

for palo in [CORAZONES, DIAMANTES, TREBOLES, PICAS]:
    for numero in ['As', 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K']:
        baraja.append(Carta(numero, palo))

class Coleccion:
    def __init__(self, elementos=None) -> None:
        if elementos is None:
            elementos = []
        self.__elementos = elementos[:]

    def elementos(self):
        return self.__elementos[:]

    def mover(self, elem, otra):
        pass
