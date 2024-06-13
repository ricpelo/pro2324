"""
Escribir en Python una función recursiva llamada

unicos(secuencia)

que reciba una secuencia de números enteros en la que todos aparecen
dos o más veces, excepto dos de ellos que sólo aparecen una
vez. La función deberá devolver un conjunto de tipo set que contenga
sólo esos dos elementos únicos.

Importante:
- La función debe ser pura.
- La llamada a la función debe provocar la ejecución de una función
  recursiva que genere un proceso iterativo.
- No se puede usar ningún bucle while, for, definiciones por
  comprensión ni expresiones generadoras.

Por ejemplo:

unicos([1,9,8,8,7,6,1,6]) == {7,9}
unicos((5,5,2,4,4,4,9,9,9,1)) == {1,2}
unicos([9,5,6,8,7,7,1,1,1,1,1,9,8]) == {5,6}
unicos([4,3,9,9,1,1,6,1,6,2,4]) == {2,3}
"""

def unicos(sec) -> set[int]:
    def unicos_aux(sec, acc: set[int]):
        if len(sec) == 0:
            return acc
        if sec[0] in acc:
            return unicos_aux(sec[1:], acc - {sec[0]})
        return unicos_aux(sec[1:], acc | {sec[0]})

    return unicos_aux(sec, set())


print(unicos([1,9,8,8,7,6,1,6]))
print(unicos((5,5,2,4,4,4,9,9,9,1)))
print(unicos([9,5,6,8,7,7,1,1,1,1,1,9,8]))
print(unicos([4,3,9,9,1,1,6,1,6,2,4]))
