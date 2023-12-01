"""
3 Calcular pérdidas totales
¡Acabas de regresar a casa y descubres que han robado tu
mansión! Dado un diccionario de los artículos robados, devolver
el monto total del robo (número). Si no se robó nada, devolver
la cadena "Lucky you!".

Ejemplos
calculate_losses({
"tv" : 30,
"skate" : 20,
"stereo" : 50,
}) == 100
calculate_losses({
"painting" : 20000,
}) == 20000
calculate_losses({}) == "Lucky you!"

Notas
• El valor del artículo siempre es positivo.
"""

def calculate_losses(articulos: dict) -> int|str:
    """
    >>> calculate_losses({ \
            "tv" : 30, \
            "skate" : 20, \
            "stereo" : 50, \
        })
    100
    >>> calculate_losses({"painting" : 20000})
    20000
    >>> calculate_losses({})
    'Lucky you!'
    """
    if articulos == {}:
        return 'Lucky you!'
    # return sum(articulos.values())
    suma = 0
    for v in articulos.values():
        suma += v
    return sum(articulos[k] for k in articulos)
