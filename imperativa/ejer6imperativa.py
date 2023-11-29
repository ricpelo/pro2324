# 6. Escribe un programa que pida el año actual y el
# de nacimiento del usuario. Debe calcular su edad,
# suponiendo que en el año en curso el usuario ya
# ha cumplido años.

while True:
    try:
        actual = int(input('Introduce el año actual: '))
    except ValueError:
        print('Debe introducir un año válido.')
    else:
        break

while True:
    try:
        nacimiento = int(input('Introduce tu año de nacimiento: '))
    except ValueError:
        print('Debe introducir un año válido.')
    else:
        break

edad = actual - nacimiento
print('Tu edad es', edad, 'años.')
