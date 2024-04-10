import datetime

class Texto:
    def __init__(self, _long_max: int) -> None:
        self.__long_max = _long_max
        self.__cadena = ''
        self.__created_at = str(datetime.datetime.now(datetime.UTC))
        self.__actualizar_updated_at()

    def long_max(self) -> int:
        return self.__long_max

    def cadena(self) -> str:
        return self.__cadena

    def created_at(self) -> str:
        return self.__created_at

    def updated_at(self) -> str:
        return self.__updated_at

    def prepend(self, texto: str) -> None:
        self.__comprobar_longitud(texto)
        self.__cadena = texto + self.__cadena
        self.__actualizar_updated_at()

    def append(self, texto: str) -> None:
        self.__comprobar_longitud(texto)
        self.__cadena += texto
        self.__actualizar_updated_at()

    def __actualizar_updated_at(self):
        self.__updated_at = str(datetime.datetime.now(datetime.UTC))

    def __comprobar_longitud(self, texto) -> None:
        if len(self.cadena()) + len(texto) > self.long_max():
            raise ValueError('La cadena no cabe en el texto.')

    def __str__(self) -> str:
        return self.cadena()

    def imprimir(self) -> None:
        print(self.cadena())
        print(self.created_at())
        print(self.updated_at())


t = Texto(20)
t.append('Hola caracola')
print(t)
t.imprimir()
