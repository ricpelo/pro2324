class Animal:
    pass

class Terrestre(Animal):
    def mover(self):
        print('Voy andando.')

class Acuatico(Animal):
    def mover(self):
        print('Voy nadando.')


class Anfibio(Terrestre, Acuatico):
    def mover(self):
        print('Voy dando saltos.')

rana = Anfibio()
rana.mover()
