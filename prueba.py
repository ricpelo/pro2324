class Alumno:
    def __init__(self, nombre: str) -> None:
        self.__nombre = nombre
        self.__asignaturas = {}

    def nombre(self) -> str:
        return self.__nombre

    def grupo(self, grupo: 'Grupo'):
        self.__grupo = grupo
        return self

    def matricular(self, asignatura: 'Asignatura'):
        self.__asignaturas[asignatura] = {}
        return self

    def set_nota(self, asignatura: 'Asignatura', trimestre: int, nota: float):
        self.__asignaturas[asignatura][trimestre] = nota
        return self

    def media(self, asignatura: 'Asignatura'):
        suma = 0.0
        numero = 0
        for nota in self.__asignaturas[asignatura].values():
            suma += nota
            numero += 1
        return suma / numero

    def nota(self, asignatura: 'Asignatura', trimestre: int) -> float | None:
        try:
            return self.__asignaturas[asignatura][trimestre]
        except KeyError:
            return None

    def aprobada(self, asignatura: 'Asignatura'):
        return self.media(asignatura) >= 5.0


class Asignatura:
    def __init__(self, denominacion: str, trimestre: int) -> None:
        self.set_denominacion(denominacion)
        self.set_trimestre(trimestre)

    def __eq__(self, value: object) -> bool:
        if type(self) != type(value):
            return NotImplemented
        return self.denominacion() == value.denominacion() # type: ignore

    def __hash__(self) -> int:
        return hash(self.denominacion())

    def set_denominacion(self, denominacion: str) -> None:
        self.__denominacion = denominacion

    def set_trimestre(self, trimestre: int) -> None:
        self.__trimestre = trimestre

    def denominacion(self) -> str:
        return self.__denominacion

    def trimestre(self) -> int:
        return self.__trimestre

    def asignar(self, grupo: 'Grupo'):
        self.__grupo = grupo
        return self


class Grupo:
    def __init__(self, nombre: str) -> None:
        self.__nombre = nombre
        self.__alumno = []

    def anadir_alumno(self, alumno: Alumno):
        self.__alumno.append(alumno)


ingles = Asignatura("Inglés", 3)
mates = Asignatura("Matemáticas", 2)
juan = Alumno("Juan Pérez").matricular(ingles).matricular(mates)
juan.set_nota(ingles, 1, 4.0).set_nota(ingles, 2, 6.0).set_nota(ingles, 3, 8.0)
antonio = Alumno("Antonio García").matricular(mates)
antonio.set_nota(mates, 1, 2.5)

assert juan.media(ingles) == 6.0
assert antonio.nota(mates, 2) is None
assert antonio.nota(mates, 1) == antonio.media(mates)
assert juan.aprobada(ingles)
