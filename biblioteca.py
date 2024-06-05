import xml.etree.ElementTree as ET
from datetime import datetime, timedelta

def buscar(nodo: ET.Element, consulta: str):
    res = nodo.find(consulta)
    if res is None:
        raise ValueError('No se encuentra')
    return res


def buscar_texto(nodo: ET.Element, consulta: str) -> str:
    res = buscar(nodo, consulta).text
    if res is None:
        raise ValueError('No se encuentra')
    return res


def prestamos(archivo):
    """Muestra por la salida todos los préstamos vigentes en la biblioteca."""
    arbol = ET.parse(archivo)
    raiz = arbol.getroot()

    for libro in raiz.findall('libros/libro'):
        for ejemplar in libro.findall('ejemplares/ejemplar'):
            prestamo = ejemplar.find('prestamo')
            if prestamo is not None:
                lector_id = prestamo.attrib['lector']
                lector = buscar(raiz, f'lectores/lector[@id="{lector_id}"]')
                print(f"Título: {buscar_texto(libro, 'titulo')}")
                print(f"Autor: {buscar_texto(libro, 'autor')}")
                print(f"Ejemplar número: {ejemplar.attrib['id']}")
                print(f"Lector: {buscar_texto(lector, 'nombre')}")
                print(f"Fecha: {buscar_texto(prestamo, 'fecha')}")
                fecha = buscar_texto(prestamo, 'fecha')
                devolucion = datetime.fromisoformat(fecha) + timedelta(days=30)
                print(f"Devolver antes de: {devolucion.date()}")
                print()


def main():
    prestamos('biblioteca.xml')


if __name__ == '__main__':
    main()
