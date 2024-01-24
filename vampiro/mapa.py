"""
Este módulo proporciona las funcionalidades necesarias para que
el juego disponga de mapeado. Aquí se registrarán los diferentes
lugares que forman el mapa del juego, así como las conexiones
entre ellos y sus descripciones.
"""

import vocabulario as voc

class Lugar:
    """Los lugares del mapa del juego."""

    def __init__(self, nombre: str, descripcion: str) -> None:
        self._nombre = nombre
        self._descripcion = descripcion

    def nombre(self) -> str:
        """Devuelve el nombre del lugar."""
        return self._nombre

    def descripcion(self) -> str:
        """Devuelve la descripción del lugar."""
        return self._descripcion

    def describir_lugar(self) -> None:
        """Imprime por la salida el nombre y la descripción del lugar."""
        print(self.nombre())
        print(self.descripcion())


class Mapa:
    """El mapa de la aventura."""

    def __init__(self):
        self.conexiones: dict[Lugar,dict[voc.Palabra,Lugar]] = {}

    def insertar_conexiones(
        self,
        origen: Lugar,
        conex: dict[voc.Palabra,Lugar]
    ) -> None:
        """
        Inserta en el mapa una o varias conexiones entre el lugar (self)
        y otros lugares.
        """
        self.conexiones[origen] = conex

    def destino(self, lugar: Lugar, direccion: voc.Palabra) -> Lugar|None:
        """
        Devuelve el destino desde el lugar hacia la dirección (si existe).
        En caso contrario, devuelve None.
        """
        if lugar in self.conexiones:
            return self.conexiones[lugar].get(direccion)
        return None


cocina = Lugar(
    'COCINA',
    'Estás en la cocina del castillo. Esto está lleno de \
    cacerolas y de cacharros para cocinar. Hay un horno, \
    un fregadero y un armario pequeño.'
)

pasillo = Lugar(
    'PASILLO',
    'Te encuentras en medio del pasillo principal de este \
    piso. Al oeste está la cocina y al este la biblioteca. \
    El pasillo sigue hacia el norte.'
)

vestibulo = Lugar(
    'VESTÍBULO',
    'Estás en el vestíbulo del castillo. El ambiente es muy \
    húmedo y frío. Un pasillo se extiende hacia el norte. Al \
    sur queda la puerta de entrada al castillo.'
)

_con = {
    vestibulo: { voc.NORTE: pasillo },
    pasillo: { voc.SUR: vestibulo, voc.OESTE: cocina },
    cocina: { voc.ESTE: pasillo }
}

mapa = Mapa()

for k, v in _con.items():
    mapa.insertar_conexiones(k, v)
