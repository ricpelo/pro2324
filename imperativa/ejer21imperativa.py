# 21. Escribir un programa que duplique el contenido de un
# archivo cuyo nombre se pide al usuario. El archivo copia
# tendrá el mismo nombre con el prefijo «copia_de_»

from goto_plus import goto, gotoconfig

gotoconfig(__file__)

nombre = input('Introduzca el nombre del archivo: ')

entrada = open(nombre, 'r')
salida = open('copia_de_' + nombre, 'w')
linea = entrada.readline()
if linea == '': goto(17)
salida.write(linea)
goto(13)
salida.close()
entrada.close()
