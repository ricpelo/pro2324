"""
Definiciones de clases del banco.
"""

class Cliente:
    """Un cliente del banco."""

    def __init__(
        self,
        dni: str,
        nombre: str,
        apellidos: str
    ) -> None:
        self.set_dni(dni)
        self.set_nombre(nombre)
        self.set_apellidos(apellidos)

    def set_dni(self, dni: str) -> None:
        # Comprobar la letra del DNI
        self.__dni = dni

    def set_nombre(self, nombre: str) -> None:
        self.__nombre = nombre

    def set_apellidos(self, apellidos: str) -> None:
        self.__apellidos = apellidos

    def dni(self) -> str:
        return self.__dni

    def nombre(self) -> str:
        return self.__nombre

    def apellidos(self) -> str:
        return self.__apellidos


class Movimiento:
    """Un movimiento de una cuenta del banco."""

    def __init__(self, concepto: str, cantidad: float) -> None:
        self.__concepto = concepto
        self.__cantidad = cantidad

    def concepto(self) -> str:
        return self.__concepto

    def cantidad(self) -> float:
        return self.__cantidad


class Cuenta:
    """
    Una cuenta del banco.

    Invariantes:
      - El número de la cuenta tiene que ser >= 0.
      - La suma de las cantidades de los movimentos de la cuenta
        tienen que coincidir con el saldo de la misma.
    """

    __ultimo = 0
    __cuentas = {}

    def __init__(self, titular: Cliente) -> None:
        """Pre: titular no puede ser None."""
        Cuenta.__ultimo += 1
        self.__numero = Cuenta.__ultimo
        self.__titular = titular
        self.__movimientos: list[Movimiento] = []
        self.__saldo = 0.0
        Cuenta.__cuentas[self.__numero] = self
        assert self.__comprobar_saldo()

    def __comprobar_saldo(self) -> bool:
        return sum(m.cantidad() for m in self.__movimientos) == \
            self.saldo()

    @staticmethod
    def buscar(numero: int):
        return Cuenta.__cuentas[numero]

    @staticmethod
    def iterar():
        return iter(Cuenta.__cuentas.values())

    def numero(self) -> int:
        return self.__numero

    def titular(self) -> Cliente:
        return self.__titular

    def movimientos(self) -> list[Movimiento]:
        return self.__movimientos[:]

    def saldo(self) -> float:
        return self.__saldo

    def insertar_movimiento(
        self,
        concepto: str,
        cantidad: float
    ) -> None:
        movimiento = Movimiento(concepto, cantidad)
        saldo_anterior = self.saldo()
        self.__movimientos.append(movimiento)
        self.__saldo += cantidad
        assert self.__comprobar_saldo()
        assert saldo_anterior + movimiento.cantidad() == self.saldo()
