# 21. Escribir un programa que duplique el contenido de un
# archivo cuyo nombre se pide al usuario. El archivo copia
# tendrá el mismo nombre con el prefijo «copia_de_»

nombre = input('Introduzca el nombre del archivo: ')

with (
    open(nombre, 'r') as entrada,
    open('copia_de_' + nombre, 'w') as salida
):
    while True:
        linea = entrada.readline()
        if linea == '':
            break
        else:
            salida.write(linea)
