from abc import ABC, abstractmethod

class Expresion(ABC):
    @abstractmethod
    def valor(self) -> int:
        ...

class Numero(Expresion):
    def __init__(self, _numero: int) -> None:
        super().__init__()
        self.__numero = _numero

    def valor(self) -> int:
        return self.__numero

class Suma(Expresion):
    def __init__(self, _x: Expresion, _y: Expresion) -> None:
        super().__init__()
        self.__x = _x
        self.__y = _y

    def valor(self) -> int:
        return self.__x.valor() + self.__y.valor()

class Producto(Expresion):
    def __init__(self, _x: Expresion, _y: Expresion) -> None:
        super().__init__()
        self.__x = _x
        self.__y = _y

    def valor(self) -> int:
        return self.__x.valor() * self.__y.valor()


assert Numero(2).valor() == 2
assert Suma(Numero(2), Producto(Numero(3), Numero(5))).valor() == 17
assert Producto(Numero(2), Suma(Numero(3), Numero(5))).valor() == 16
