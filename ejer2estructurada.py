# 2. Escribir un programa que pida al usuario su edad y que
# imprima el mensaje «¡Qué joven!» si es menor de 25 años.

while True:
    try:
        edad = int(input('Introduzca su edad: '))
        if edad < 25:
            print('¡Qué joven!')
        break
    except ValueError:
        print('El dato introducido no es un número.')
