while True:
    try:
        x = int(input('Introduce un número: '))
        if x == 2:
            break
        else:
            print(x)
    except ValueError:
        print('No ha introducido un número válido.')
