"""
Módulo principal.
"""

from banco import Cliente, Cuenta

antonio = Cliente('123123123', 'Antonio', 'Martínez')

Cuenta(antonio)
Cuenta(antonio)

c1 = Cuenta.buscar(1)
c2 = Cuenta.buscar(2)

c1.insertar_movimiento('Ingreso', 2000.00)
c1.insertar_movimiento('Reintegro', -250.00)
c1.insertar_movimiento('Nómina', 1800.00)

c2.insertar_movimiento('Ingreso', 4000.00)
c2.insertar_movimiento('Saca del cajero', -50.00)
c2.insertar_movimiento('Compra en Amazon', -3250.75)

for c in Cuenta.iterar():
    print(f'El saldo de la cuenta {c.numero()} es {c.saldo()}')
