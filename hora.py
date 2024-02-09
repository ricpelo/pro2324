"""
Ejercicios 3 y 4.
"""

class Hora:
    """
    Un instante de tiempo en horas y minutos.

    >>> h = Hora(23, 59)
    >>> print(h)
    23:59
    >>> h.inc()
    >>> print(h)
    00:00
    """

    def __init__(self, hora: int, minutos: int) -> None:
        self.set_hora(hora)
        self.set_minutos(minutos)

    def __str__(self) -> str:
        return f'{self.hora():02}:{self.minutos():02}'

    @staticmethod
    def __hora_valida(hora: int) -> bool:
        return hora in range(0, 24)

    @staticmethod
    def __minutos_validos(minutos: int) -> bool:
        return minutos in range(0, 60)

    def set_hora(self, hora):
        if not Hora.__hora_valida(hora):
            return False
        self.__hora = hora
        return True

    def set_minutos(self, minutos):
        if not Hora.__minutos_validos(minutos):
            return False
        self.__minutos = minutos
        return True

    def hora(self) -> int:
        return self.__hora

    def minutos(self) -> int:
        return self.__minutos

    def inc(self) -> None:
        """Incrementa el instante en un minuto."""
        if self.minutos() < 59:
            self.set_minutos(self.minutos() + 1)
        else:
            self.set_minutos(0)
            if self.hora() < 23:
                self.set_hora(self.hora() + 1)
            else:
                self.set_hora(0)


class HoraExacta(Hora):
    def __init__(self, hora: int, minutos: int, segundos: int) -> None:
        super().__init__(hora, minutos)
        self.set_segundos(segundos)

    def set_segundos(self, segundos):
        self.__segundos = segundos

    def segundos(self):
        return self.__segundos

    def __str__(self) -> str:
        return super().__str__() + f':{self.segundos():02}'


if __name__ == "__main__":
    import doctest
    doctest.testmod()
