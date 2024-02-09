class Trabajador:
    def __init__(self, nombre: str, salario: float) -> None:
        self.set_nombre(nombre)
        self.set_salario(salario)

    def set_nombre(self, nombre: str) -> None:
        self.__nombre = nombre

    def get_nombre(self) -> str:
        return self.__nombre

    def set_salario(self, salario: float) -> None:
        self.__salario = salario

    def get_salario(self) -> float:
        return self.__salario

class Docente(Trabajador):
    ...

def diferencia_salarios(t1: Trabajador, t2: Trabajador):
    """t1 y t2 son instancias de Trabajador"""
    return t1.get_salario() - t2.get_salario()
