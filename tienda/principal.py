from modelo import Cliente, Articulo, Factura

rosa = Cliente('123123123', 'Rosa', 'González')
tv = Articulo('111', 'Televisor', 399.00)
grafica = Articulo('222', 'Tarjeta gráfica', 239.00)
factura = Factura(1, rosa, {tv: 2, grafica: 1})

print(f'Cliente: {rosa.dni()} {rosa.nombre()} {rosa.apellidos()}')
print()
print('Código Denominación            Cantidad   Precio   Importe')
print('------ --------------------- ---------- -------- ---------')
for articulo, cantidad in factura:
    codigo = articulo.codigo()
    denom = articulo.denominacion()
    precio = articulo.precio()
    importe = cantidad * articulo.precio()
    print(f'{codigo:>6} {denom:21} {cantidad:10} {precio:8} {importe:9}')
print('-' * 58)
print(f'TOTAL: {factura.total()} €')
