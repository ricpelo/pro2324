# 20. Crear un archivo de texto con una colección de números
# reales, uno por línea. A continuación, escribir un
# programa que:
#  a. Abra el archivo para lectura.
#  b. Lea todas sus líneas.
#  c. Muestre finalmente la suma de todos ellos.

f = open('mas_numeros_reales.txt', 'r')
lineas = f.readlines()
f.close()
lista = list(map(lambda x: float(x.rstrip()), lineas))
suma = sum(lista)
print('La suma es', suma)
