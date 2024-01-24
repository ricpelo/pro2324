"""
Este módulo proporciona las funcionalidades necesarias para que
el juego disponga de mapeado. Aquí se registrarán los diferentes
lugares que forman el mapa del juego, así como las conexiones
entre ellos y sus descripciones.
"""

import vocabulario as voc

class Lugar:
    """Los lugares del mapa del juego."""

    def __init__(self, nombre, descripcion):
        self._nombre = nombre
        self._descripcion = descripcion

    def nombre(self):
        """Devuelve el nombre del lugar."""
        return self._nombre

    def descripcion(self):
        """Devuelve la descripción del lugar."""
        return self._descripcion

    def describir_lugar(self):
        """Imprime por la salida el nombre y la descripción del lugar."""
        print(self.nombre())
        print(self.descripcion())


cocina = Lugar(
    'COCINA',
    'Estás en la cocina del castillo. Esto está lleno de \
    cacerolas y de cacharros para cocinar. Hay un horno, \
    un fregadero y un armario pequeño.'
)


# def crear_lugar(nomb, descr):
#     def nombre():
#         return nomb

#     def descripcion():
#         return descr

#     def describir_lugar() -> None:
#         print(nombre())
#         print(descripcion())

#     dic = {
#         'nombre': nombre,
#         'descripcion': descripcion,
#         'describir_lugar': describir_lugar
#     }

#     def despacho(mensaje):
#         if mensaje in dic:
#             return dic[mensaje]
#         raise ValueError('Mensaje incorrecto.')

#     return despacho


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


def crear_mapa():
    """Crea un mapa."""

    conexiones = {}

    def insertar_conexiones(origen, conex):
        conexiones[origen] = conex

    def destino(lugar, direccion):
        if lugar in conexiones:
            return conexiones[lugar].get(direccion)
        return None

    dic = {'insertar_conexiones': insertar_conexiones, 'destino': destino}

    def despacho(mensaje):
        """Despacha los mensajes."""
        if mensaje in dic:
            return dic[mensaje]
        raise ValueError('Mensaje incorrecto.')

    return despacho


_con = {
    vestibulo: { voc.NORTE: pasillo },
    pasillo: { voc.SUR: vestibulo, voc.OESTE: cocina },
    cocina: { voc.ESTE: pasillo }
}

mapa = crear_mapa()
_insertar_conexiones = mapa('insertar_conexiones')

for k, v in _con.items():
    _insertar_conexiones(k, v)
