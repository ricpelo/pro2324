class Cliente:
    def __init__(self, _dni: str, _nombre: str, _apellidos: str) -> None:
        self.__dni = _dni
        self.__nombre = _nombre
        self.__apellidos = _apellidos

    def dni(self) -> str:
        return self.__dni

    def nombre(self) -> str:
        return self.__nombre

    def apellidos(self) -> str:
        return self.__apellidos


class Articulo:
    def __init__(self, _codigo: str, _denominacion: str, _precio: float) -> None:
        self.__codigo = _codigo
        self.__denominacion = _denominacion
        self.__precio = _precio

    def __eq__(self, __value: object) -> bool:
        if type(self) != type(__value):
            return NotImplemented
        return self.codigo() == __value.codigo()

    def __hash__(self) -> int:
        return hash(self.codigo())

    def codigo(self):
        return self.__codigo

    def denominacion(self):
        return self.__denominacion

    def precio(self):
        return self.__precio


class Factura:
    """
    Invariante: El total de la factura tiene que coincidir con la suma
    de las cantidades por los precios de sus artículos.
    """
    def __init__(self, _numero: int, _cliente: Cliente, _lineas=None) -> None:
        self.__numero = _numero
        if _cliente is None:
            raise ValueError('La factura debe tener un cliente.')
        self.__cliente = _cliente
        _lineas = {} if _lineas is None else _lineas.copy()
        self.__lineas: dict[Articulo, int] = _lineas
        assert self.__comprobar_total()

    def __iter__(self):
        return iter(self.__lineas.copy().items())

    def __comprobar_total(self) -> bool:
        return self.total() == sum(a.precio() * c for a, c in self)

    def numero(self) -> int:
        return self.__numero

    def cliente(self) -> Cliente:
        return self.__cliente

    def lineas(self) -> dict[Articulo, int]:
        return self.__lineas.copy()

    def insertar_linea(self, articulo: Articulo, cantidad: int) -> None:
        if articulo in self.__lineas:
            raise ValueError('Ya hay una línea con ese artículo.')
        long_anterior = len(self.__lineas)
        self.__lineas[articulo] = cantidad
        assert len(self.__lineas) == long_anterior + 1
        assert self.__comprobar_total()

    def eliminar_linea(self, articulo: Articulo) -> None:
        if articulo not in self.__lineas:
            raise ValueError('No hay ninguna línea con ese artículo.')
        long_anterior = len(self.__lineas)
        del self.__lineas[articulo]
        assert len(self.__lineas) == long_anterior - 1
        assert self.__comprobar_total()

    def total(self) -> float:
        return sum(a.precio() * c for a, c in self)
