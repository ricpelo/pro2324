"""
Escribir en Python una función sumas() sin parámetros que lea un
archivo de texto llamado «entrada.txt» con un texto formado por
líneas donde en cada una habrá un número, como el ejemplo
siguiente (no tiene por qué ser exactamente igual, pero sí de la
misma forma):

2
37
21
105

La función deberá crear un archivo «salida.txt» que contenga el
mismo contenido que el archivo original pero añadiendo la suma
parcial acumulada hasta esa línea, y una línea más que indique
la suma total, de la siguiente forma:

   2         2
  37        39
  21        60
 105       165
--------------
SUMA:      165


Es decir: en cada línea, se añade la suma de esa línea con la suma
que se ha ido acumulando hasta esa línea. Los números de la
entrada sólo pueden ser enteros positivos y nunca podrán ser
superiores a 999. La función no debe devolver nada.

Indicación: se pueden usar campos de sustitución en una f-string
con el formato {numero:anchof} para alinear un número entero a la
derecha.
"""

def sumas():
    """Hace lo que dice el ejercicio."""
    with (
        open('entrada.txt', 'r') as entrada,
        open('salida.txt', 'w') as salida
    ):
        suma, derecha = 0, 0
        for linea in entrada:
            numero = int(linea.rstrip())
            derecha = numero + suma
            suma += numero
            salida.write(f'{numero:>4} {derecha:>9}\n')
        salida.write(('-' * 14) + '\n')
        salida.write(f'SUMA: {derecha:>8}\n')

sumas()
