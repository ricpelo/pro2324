# 11. Escribir un programa que determine si un número entero
# introducido por teclado es primo o compuesto.
# Indicación: Un número primo es aquel que sólo puede dividirse
# exactamente por sí mismo y por 1.

def recoger_numero():
    while True:
        try:
            n = int(input('Introduzca un número: '))
            return n
        except ValueError:
            print('El dato introducido no es un número.')

def cantidad_divisores(n):
    # divisores = sum(1 for i in range(1, n + 1) if n % i == 0)
    divisores = 0
    i = 1
    while i <= n:
        if n % i == 0:
            divisores += 1
        i += 1
    return divisores

def anunciar_primalidad(divisores):
    # print('Es primo' if divisores == 2 else 'Es compuesto')
    if divisores == 2:
        print('Es primo')
    else:
        print('Es compuesto')

n = recoger_numero()
divisores = cantidad_divisores(n)
anunciar_primalidad(divisores)
