"""
Ejercicio 8 tema POO.
"""

class Hora:
    """
    Invariantes:
      - __hora tiene que estar entre 0 y 23.
      - __minuto tiene que estar entre 0 y 59.
      - __segundo tiene que estar entre 0 y 59.

    >>> h = Hora('23:59:59')
    >>> h.incrementar()
    >>> h
    00:00:00
    """
    def __init__(self, _hora: int, _minuto: int, _segundo: int) -> None:
        self.set_hora(_hora)
        self.set_minuto(_minuto)
        self.set_segundo(_segundo)

    def __str__(self) -> str:
        return f'{self.hora():02}:{self.minuto():02}:{self.segundo():02}'

    def hora(self):
        return self.__hora

    def minuto(self):
        return self.__minuto

    def segundo(self):
        return self.__segundo

    def set_hora(self, _hora: int) -> None:
        if _hora not in range(0, 24):
            raise ValueError('Hora incorrecta.')
        self.__hora = _hora

    def set_minuto(self, _minuto: int) -> None:
        if _minuto not in range(0, 60):
            raise ValueError('Minuto incorrecto.')
        self.__minuto = _minuto

    def set_segundo(self, _segundo: int) -> None:
        if _segundo not in range(0, 60):
            raise ValueError('Segundo incorrecto.')
        self.__segundo = _segundo

    def incrementar(self) -> None:
        """Incrementa la hora en un segundo."""
        if self.segundo() < 59:
            self.set_segundo(self.segundo() + 1)
        else:
            self.set_segundo(0)
            if self.minuto() < 59:
                self.set_minuto(self.minuto() + 1)
            else:
                self.set_minuto(0)
                if self.hora() < 23:
                    self.set_hora(self.hora() + 1)
                else:
                    self.set_hora(0)

        assert self._comprobar()

    def _comprobar(self) -> bool:
        return self.hora() in range(0, 24) and \
            self.minuto() in range(0, 60) and \
            self.segundo() in range(0, 60)

def main():
    while True:
        try:
            entrada = input('Introduzca la hora en formato hh:mm:ss: ')
            hora, minuto, segundo = map(int, entrada.split(':'))
            h = Hora(hora, minuto, segundo)
            entrada = input('Introduzca el número de segundos: ')
            n = int(entrada)
            break
        except ValueError:
            print('Entrada incorrecta.')

    print(h)
    for _ in range(n):
        h.incrementar()
        print(h)


if __name__ == '__main__':
    main()
