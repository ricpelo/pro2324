from abc import ABC, abstractmethod    # importamos del módulo abc

class Figura(ABC):                     # Figura es subclase de ABC
    def __init__(self, ancho, alto):
        self.set_ancho(ancho)
        self.set_alto(alto)

    def set_ancho(self, ancho):
        self.ancho = ancho

    def set_alto(self, alto):
        self.alto = alto

    def get_ancho(self):
        return self.ancho

    def get_alto(self):
        return self.alto

    @abstractmethod                    # declaramos el método como abstracto
    def area(self):
        ...                            # representa que no tiene cuerpo

    @abstractmethod
    def dibujar(self):
        ...

    # resto de código


class Triangulo(Figura):
    def area(self):
        return self.get_ancho() * self.get_alto() / 2

    # def dibujar(self):
    #     print('  *  ')
    #     print(' *** ')
    #     print('*****')
