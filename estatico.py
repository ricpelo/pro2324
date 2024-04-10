class Estatico:
    def __init__(self, _numero) -> None:
        self.numero = _numero

    @staticmethod
    def duplicar(c: str) -> str:
        return c + c

    @staticmethod
    def cuadruplicar(c: str) -> str:
        return Estatico.duplicar(Estatico.duplicar(c))


class Subclase(Estatico):
    @staticmethod
    def cuadruplicar(c: str) -> str:
        return Estatico.cuadruplicar(Estatico.cuadruplicar(c))

e = Estatico(5)
print(e.duplicar('manolo'))


x = Estatico.cuadruplicar('pepe')
print(x)

y = Subclase.cuadruplicar('juan')
print(y)
