class Abonado:
    def __init__(self, nombre, servicios):
        self.nombre = nombre
        self.servicios_contratados = servicios

    def contratar(self, servicio):
        if isinstance(servicio, Television):
            encontrado = False
            for ser in self.servicios_contratados:
                if isinstance(ser, Internet):
                    encontrado = True
                    break
            if not encontrado:
                return None
        self.servicios_contratados.append(servicio)
        return self

    def num_servicios(self):
        return len(self.servicios_contratados)


class Fijo:
    def __init__(self, numero, punto_servicio):
        self.numero = numero
        self.punto_servicio = punto_servicio


class Movil:
    def __init__(self, numero):
        self.numero = numero


class Internet:
    def __init__(self, punto_servicio):
        self.punto_servicio = punto_servicio


class Television:
    def __init__(self, punto_servicio):
        self.punto_servicio = punto_servicio


pepe = Abonado('Pepe', [Fijo(956361514, 'Calle Corta, 33'), Movil(666555444)])
juan = Abonado('Juan', [Movil(666666666)])

assert Abonado('Manolo', []).num_servicios() == 0
assert pepe.num_servicios() == 2
assert pepe.contratar(Internet('Calle Ancha, 23')).num_servicios() == 3
assert juan.contratar(Television('Calle Larga, 25')) is None
