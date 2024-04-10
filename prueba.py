class Alumno:
    def __init__(self, nombre) -> None:
        self.__nombre = nombre
        self.__asignaturas = {}

    def nombre(self):
        return self.__nombre

    def grupo(self, grupo):
        self.__grupo = grupo
        return self

    def matricular(self, asignatura):
        self.__asignaturas[asignatura] = {}
        return self

    def set_nota(self, asignatura: 'Asignatura', trimestre, nota):
        self.__asignaturas[asignatura][trimestre] = nota
        return self

    def media(self, asignatura):
        for _ in self.__asignatura:
            media = sum(asignatura()) / len(asignatura())
            return media

    def nota(self, asignatura, trimestre):
        return asignatura(trimestre)

    def aprobada(self, asignatura):
        if asignatura.media >= 5:
            return True
        else:
            return False

class Asignatura:
    def __init__(self, denominacion, trimestre) -> None:
        self.set_denominacion(denominacion)
        self.set_trimestre(trimestre)

    def __eq__(self, value: object) -> bool:
        if type(self) != type(value):
            return NotImplemented
        return self.denominacion() == value.denominacion()

    def __hash__(self) -> int:
        return hash(self.denominacion())

    def set_denominacion(self, denominacion: str) -> None:
        self.__denominacion = denominacion

    def set_trimestre(self, trimestre: int) -> None:
        self.__trimestre = trimestre

    def denominacion(self) -> str:
        return self.__denominacion

    def trimestre(self):
        return self.__trimestre

    def asignar(self, grupo):
        self.__grupo = grupo
        return self

class Grupo:
    def __init__(self, nombre) -> None:
        self.__nombre = nombre
        self.__alumno = []

    def anadir_alumno(self, alumno):
        self.__alumno.append(alumno)

ingles = Asignatura("Inglés", 3)
mates = Asignatura("Matemáticas", 2)
juan = Alumno("Juan Pérez").matricular(ingles).matricular(mates)
juan.set_nota(ingles, 1, 4.0).set_nota(ingles, 2, 6.0).set_nota(ingles, 3, 8.0)
antonio = Alumno("Antonio García").matricular(mates)
antonio.set_nota(mates, 1, 2.5)

# assert juan.media(ingles) == 6.0
# assert antonio.nota(mates, 2) is None
# assert antonio.nota(mates, 1) == antonio.media(mates)
# assert juan.aprobada(ingles)
