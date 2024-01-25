"""
Módulo que se encarga de todo lo relacionado con los ítems
del juego.
"""

import mapa
import vocabulario as voc


CUCHILLO = mapa.Item(
    'Un cuchillo',
    'Un simple cuchillo de cocina. Pincha',
    mapa.cocina,
    voc.CUCHILLO
)
