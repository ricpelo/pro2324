class Soporte:
    def __init__(self, _playlist) -> None:
        self.__playlist = tuple(_playlist)

    def playlist(self) -> tuple:
        return self.__playlist

    def reproducir(self, indice: int) -> str:
        return self.__playlist[indice]


class Televisor:
    def __init__(self) -> None:
        self.__encendido = False
        self.__canal = 1
        self.__volumen = 0
        self.__soporte = None

    def encender(self) -> 'Televisor':
        self.__encendido = True
        return self

    def apagar(self) -> 'Televisor':
        self.__encendido = False
        return self

    def subir_volumen(self) -> 'Televisor':
        if self.__encendido and self.__volumen < 30:
            self.__volumen += 1
        return self

    def bajar_volumen(self) -> 'Televisor':
        if self.__encendido and self.__volumen > 0:
            self.__volumen -= 1
        return self

    def volumen(self) -> int:
        return self.__volumen

    def sintonizar(self, _canal: int) -> 'Televisor':
        if self.__encendido and _canal in range(1, 101):
            self.__canal = _canal
        return self

    def canal(self) -> int:
        return self.__canal

    def conectar(self, _soporte: Soporte) -> 'Televisor':
        self.__soporte = _soporte
        return self

    def desconectar_si_conectado(self) -> 'Televisor':
        self.__soporte = None
        return self

    def reproducir_si_conectado(self) -> tuple:
        if not self.__encendido or self.__soporte is None:
            return ()
        res = []
        for medio in self.__soporte.playlist():
            res.append(medio)
        return tuple(res)


if __name__ == '__main__':
    soporte = Soporte(["Batman.mp4", "Superman.mp4"])
    assert Televisor().encender().bajar_volumen().volumen() == 0
    assert Televisor().subir_volumen().encender().subir_volumen().volumen() == 1
    assert Televisor().conectar(soporte).reproducir_si_conectado() == ()
    assert Televisor().conectar(soporte).encender().reproducir_si_conectado() == ("Batman.mp4", "Superman.mp4")
