from abc import ABC, abstractmethod

class Nota:
    DO = 'do'
    RE = 're'
    MI = 'mi'
    FA = 'fa'
    SOL = 'sol'
    LA = 'la'
    SI = 'si'


class Instrumento(ABC):
    def __init__(self, melodia=None) -> None:
        if melodia is None:
            melodia = []
        self.__melodia: list[str] = melodia[:]

    def melodia(self) -> list[str]:
        return self.__melodia[:]

    def add(self, nota: str):
        self.__melodia.append(nota)
        return self

    @abstractmethod
    def interpretar(self) -> None:
        ...


class Piano(Instrumento):
    def __init__(self, tipo, melodia=None) -> None:
        super().__init__(melodia)
        self.__tipo = tipo

    def interpretar(self) -> None:
        print(self.melodia())

p = Piano([Nota.DO, Nota.RE, Nota.MI, Nota.FA])
# p.add(Nota.DO).add(Nota.RE).add(Nota.MI).add(Nota.FA)
p.interpretar()
