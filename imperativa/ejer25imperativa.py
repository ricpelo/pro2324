# 25. Escribir un programa que lea dos listas de números enteros
# no ordenados de sendos archivos con un número por línea, los
# reúna en una lista única y los guarde en orden creciente en un
# tercer archivo, de nuevo uno por línea.

with open('lineas1.txt', 'r') as f:
    lineas1 = list(int(s.strip()) for s in f.readlines())

with open('lineas2.txt', 'r') as f:
    lineas2 = list(int(s.strip()) for s in f.readlines())

lineas = sorted(lineas1 + lineas2)

with open('resultado.txt', 'w') as f:
    f.writelines(str(n) + '\n' for n in lineas)
