from math import sqrt

class Matriz:
    def __init__(self, secuencia) -> None:
        self.__secuencia = secuencia

    def rango(self):
        return int(sqrt(len(self.__secuencia)))

    def __iter__(self):
        return iter(self.__secuencia)

    def elem(self, fila: int, col: int):
        return self.__secuencia[self.rango() * fila + col]

    def suma(self, otra):
        if self.rango() != otra.rango():
            return None
        res = [x + y for x, y in zip(self, otra)]
        return Matriz(res)

una = Matriz([2, 4, 9, 6, 5, 1, 3, 8, 7])
otra = Matriz([1, 1, 1, 2, 2, 2, 3, 3, 3])

assert una.elem(1, 2) == 1
assert una.suma(otra).elem(2, 1) == 11
assert una.suma(Matriz([1, 2, 3, 4])) is None
