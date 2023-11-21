# 7. Escribir un programa que pida dos números al usuario: a y b.
# Deberá mostrar Sí si ambos números son iguales y No en caso
# contrario.

from goto_plus import goto, gotoconfig

gotoconfig(__file__)

a = int(input('Introduzca el primer número: '))
b = int(input('Introduzca el segundo número: '))
if a == b: goto(14)
print('No')
goto(15)
print('Sí')
# Fin
