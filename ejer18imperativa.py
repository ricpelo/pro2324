# 18. Escribir un programa que guarde en una lista diez cadenas
# introducidas por teclado y luego las muestre en orden inverso
# a como se han introducido, desde la última cadena introducida
# hasta la primera.
# Indicación: Usar el método append sobre la lista y luego un
# bucle que recorra la lista desde el último elemento hasta el
# primero.

from goto_plus import goto, gotoconfig

gotoconfig(__file__)

lista = []
cadena = input('Introduzca una cadena: ')
lista.append(cadena)
if len(lista) < 10: goto(14)

i = -1
print(lista[i])
i -= 1
if i >= -len(lista): goto(19)
