from abc import ABC, abstractmethod

class Animal(ABC):     # Abstract Base Class
    @abstractmethod
    def hablar(self):
        ...


class Gato(Animal):
    def hablar(self):
        print("Miau.")


class Perro(Animal):
    def hablar(self):
        print("Guau.")


def responder(a: Animal):
    a.hablar()


g = Gato()
responder(g)

p = Perro()
responder(p)

a = Animal()
responder(a)
