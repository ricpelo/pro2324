# Escribir un programa que reciba tres datos de entrada y que
# los ordene de menor a mayor, indicando cuál es el primero,
# cuál el segundo y cuál el tercero.

x = 4
y = 2
z = 3

primero = x if x < y and x < z else \
          y if y < x and y < z else \
          z

segundo = x if y < x and x < z else \
          y if x < y and y < z else \
          z

tercero = x if y < x and z < x else \
          y if x < y and z < y else \
          z

# Si los datos son numéricos:
# primero = min(x, y, z)
# tercero = max(x, y, z)
# segundo = x + y + z - primero - tercero
