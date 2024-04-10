class Trabajador:
    def __init__(self, _dni, _nombre) -> None:
        self.dni = _dni
        self.nombre = _nombre

    def __str__(self) -> str:
        return f'{self.dni} - {self.nombre}'


class Docente(Trabajador):
    def __init__(self, _dni, _nombre, _especialidad) -> None:
        super().__init__(_dni, _nombre)
        self.especialidad = _especialidad

    def __str__(self) -> str:
        return super().__str__() + f' - {self.especialidad}'

    def imprimir(self) -> str:
        return super().__str__() + f' - {self.especialidad}'


t = Trabajador('123', 'Pepe')
print(t)

d = Docente('567', 'María', 'Informática')
print(d)

print(d.imprimir())
