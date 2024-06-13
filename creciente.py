def creciente(f):
    actual = 0
    for linea in f:
        if len(linea) < actual:
            return False
        actual = len(linea)
    return True


def main():
    with open('archivo.txt') as f:
        print(creciente(f))


if __name__ == '__main__':
    main()
