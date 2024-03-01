class Llave:
    def __init__(self, _color: str) -> None:
        self.__color = _color

    def color(self) -> str:
        return self.__color


class Puerta:
    def __init__(self, _color: str) -> None:
        self.__color: str = _color
        self.__abierta: bool = False
        self.__llave: Llave|None = None

    def color(self) -> str:
        return self.__color

    def poner(self, llave: Llave) -> 'Puerta':
        self.__llave = llave
        return self

    def quitar(self) -> Llave|None:
        llave = self.__llave
        self.__llave = None
        return llave

    def abrir(self) -> bool:
        if self.__abierta:
            return True
        if self.__llave is None:
            return False
        if self.color() != self.__llave.color():
            return False
        self.__abierta = True
        return True

    def cerrar(self) -> None:
        self.__abierta = False

if __name__ == '__main__':
    assert Puerta('rojo').poner(Llave('rojo')).abrir()
    assert not Puerta('rojo').poner(Llave('verde')).abrir()
    assert not Puerta('rojo').abrir()
