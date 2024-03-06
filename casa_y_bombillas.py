"""
Ejercicio 11 de POO.
"""

class Casa:
    def __init__(self, _bombillas=set()) -> None:
        self.__bombillas = set(_bombillas.clone())
        for b in self.__bombillas:
            b.set_casa(self)
        self.__interruptor = True

    def meter_bombilla(self, _bombilla: 'Bombilla') -> None:
        self.__bombillas.add(_bombilla)

    def hay_luz(self) -> bool:
        return self.__interruptor

    def apagar_interruptor(self) -> None:
        self.__interruptor = False
        for b in self.__bombillas:
            b.apagar()


class Bombilla:
    def __init__(self, _casa: Casa|None=None) -> None:
        self.__encendida = False
        self.__casa = _casa
        if _casa is not None:
            self.__casa.meter_bombilla(self)

    def encender(self) -> None:
        self.__encendida = True

    def apagar(self) -> None:
        self.__encendida = False

    def set_casa(self, _casa: Casa|None) -> None:
        self.__casa = _casa

    def esta_encendida(self) -> bool:
        return self.__encendida and \
            (self.__casa is None or self.__casa.hay_luz())
