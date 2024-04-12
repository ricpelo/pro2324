class Abonado:
    def __init__(self, nombre: str, telefonos: list) -> None:
        self.__nombre = nombre
        self.__servicios = telefonos[:]

    def contratar(self, servicio):
        if isinstance(servicio, Television):
            for s in self.__servicios:
                if isinstance(s, Internet):
                    break
            return None
        self.__servicios.append(servicio)
        return self

    def num_servicios(self):
        return len(self.__servicios)

class Fijo:
    def __init__(self, numero: int, punto: str) -> None:
        self.__numero = numero
        self.__punto = punto

class Movil:
    def __init__(self, numero) -> None:
        self.__numero = numero

class Internet:
    def __init__(self, punto) -> None:
        self.__punto = punto

class Television:
    def __init__(self, punto) -> None:
        self.__punto = punto


pepe = Abonado('Pepe', [Fijo(956361514, 'Calle Corta, 33'), Movil(666555444)])
juan = Abonado('Juan', [Movil(666666666)])

assert Abonado('Manolo', []).num_servicios() == 0
assert pepe.num_servicios() == 2
assert pepe.contratar(Internet('Calle Ancha, 23')).num_servicios() == 3
assert juan.contratar(Television('Calle Larga, 25')) is None
