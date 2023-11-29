# 19. Crear el archivo de texto «numeros_reales.txt» en el
# directorio de trabajo actual que contenga una sola línea
# de texto con números reales separados por espacios. A
# continuación, escribir un programa que abre ese archivo,
# lea los números que contiene y calcule la suma y la media
# aritmética, mostrando los resultados por pantalla.

f = open('numeros_reales.txt', 'r')
linea = f.readline().rstrip()
f.close()
lista = linea.split(' ')
lista = list(map(float, lista))
suma = sum(lista)
media = suma / len(lista)
print(f'La suma es {suma} y la media es {media}')
