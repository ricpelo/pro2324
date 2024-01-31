class Cliente:

    __id = 0
    __filas = set()

    def __init__(self, dni, nombre, apellidos, telefono) -> None:
        self.set_dni(dni)
        self.set_nombre(nombre)
        self.set_apellidos(apellidos)
        self.set_telefono(telefono)
        Cliente.__id += 1
        self.__id = Cliente.__id
        Cliente.__filas.add(self)

    def __repr__(self) -> str:
        return f'Cliente({self.dni()!r}, {self.nombre()!r}, {self.apellidos()!r}, {self.telefono()!r})'

    def __hash__(self) -> int:
        return self.id()

    def dni(self):
        return self.__dni

    def nombre(self):
        return self.__nombre

    def apellidos(self):
        return self.__apellidos

    def telefono(self):
        return self.__telefono

    def set_dni(self, dni):
        self.__dni = dni

    def set_nombre(self, nombre):
        self.__nombre = nombre

    def set_apellidos(self, apellidos):
        self.__apellidos = apellidos

    def set_telefono(self, telefono):
        self.__telefono = telefono

    def id(self):
        return self.__id

    @staticmethod
    def filas():
        return Cliente.__filas.copy()

Cliente('123123A', 'Manolo', 'Pérez', 956956956)
Cliente('123131J', 'María', 'Rodríguez', 123123123)
