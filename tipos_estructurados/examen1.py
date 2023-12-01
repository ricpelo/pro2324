"""
Escribir una función dict2list(dic) que «convierta» un
diccionario en una lista, con base en la siguiente especificación
informal:
- Debe recibir como argumento un diccionario y devolver una lista.
- Debe ser una función pura.
- Las claves del diccionario deben ser enteros y representan los
  índices de los elementos de la lista.
- Los valores del diccionario pueden ser de cualquier tipo y
  representan los elementos almacenados en la lista.
- Si hay huecos que rellenar en mitad de la lista, deben
  rellenarse con None.
- La lista no debe tener más elementos de los necesarios.

Tests:
dict2list({0: ’a’, 2: ’c’, 1: ’b’}) # => [’a’, ’b’, ’c’]
dict2list({2: ’c’, 0: ’a’}) # => [’a’, None, ’c’]
"""

def dict2list(dic: dict) -> list:
    """
    >>> dict2list({0: 'a', 2: 'c', 1: 'b'})
    ['a', 'b', 'c']
    >>> dict2list({2: 'c', 0: 'a'})
    ['a', None, 'c']
    """
    lon = max(dic.keys()) + 1
    res = []
    for _ in range(lon):
        res.append(None)
    for k, v in dic.items():
        res[k] = v
    return res

# Escribir una función list2dict(lista)
# que «convierta» una lista en un diccionario, con base en la
# siguiente especificación informal:
# Debe recibir como argumento una lista y devolver un diccionario.
# Debe ser una función pura.
# Las claves del diccionario deben ser enteros y representan los índices de los elementos de la lista.
# Cada elemento debe aparecer dos veces: con índice positivo (o cero) y con índice negativo.
# Los valores del diccionario pueden ser de cualquier tipo y representan los elementos almacena-
# dos en la lista.
# Los elementos de la lista deben insertarse en el diccionario en el orden en el que aparecen en la
# lista.
# Tests:
# list2dict([’a’, ’b’, ’c’]) # => {0: ’a’, -3: ’a’, 1: ’b’, -2: ’b’, 2: ’c’, -1: ’c’}
# list2dict([’a’, ’b’]) # => {0: ’a’, -2: ’a’, 1: ’b’, -1: ’b’}

def list2dict(lst: list) -> dict:
    """
    >>> list2dict(['a', 'b', 'c'])
    {0: 'a', -3: 'a', 1: 'b', -2: 'b', 2: 'c', -1: 'c'}
    >>> list2dict(['a', 'b'])
    {0: 'a', -2: 'a', 1: 'b', -1: 'b'}
    """
    res = {}
    for i, v in enumerate(lst):
        res[i] = v
        res[-len(lst) + i] = v
    return res
