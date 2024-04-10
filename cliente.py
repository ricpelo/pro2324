class Cliente:
    def __init__(self, _dni, _nombre) -> None:
        self.dni = _dni
        self.nombre = _nombre

    def __eq__(self, value: object) -> bool:
        if type(self) != type(value):
            return NotImplemented
        return self.dni == value.dni

    def __hash__(self) -> int:
        return hash(self.dni)


c1 = Cliente('123', 'Pepe')
c2 = Cliente('123', 'María')

print(hash(c1)) # print(c1.__hash__())
print(hash(c2))

print(c1 == c2) # print(c1.__eq__(c2))
