"""
Escribir en Python una función agrupar(arbol), que reciba el árbol
de nodos del documento XML (el cual se habrá cargado previamente).

La función deberá coger cada alumno y colgarlo bajo el grupo que
le corresponda, sabiendo que el nivel 1 corresponde al primer
curso de Primaria (para niños de 6 años), el nivel 2 corresponde
al segundo curso (para niños de 7 años), y así sucesivamente.

<?xml version="1.0"?>
<colegio>
    <grupos>
        <grupo nivel="1">
            <alumno mat="X48" edad="6">
                <nombre>Ana Ruiz</nombre>
            </alumno>
            <alumno mat="V33" edad="6">
                <nombre>Rosa Pérez</nombre>
            </alumno>
        </grupo>
        <grupo nivel="3">
            <alumno mat="J29" edad="8">
                <nombre>Antonio García</nombre>
            </alumno>
        </grupo>
    </grupos>
</colegio>

Al final, la función deberá devolver el árbol resultante.
"""

import xml.etree.ElementTree as ET

def agrupar(arbol):
    """Hace lo que dice el ejercicio."""
    raiz = arbol.getroot()
    grupos = ET.SubElement(raiz, 'grupos')
    alumnos = raiz.find('alumnos')
    for alumno in raiz.findall('alumnos/alumno'):
        nivel = int(alumno.get('edad')) - 5
        grupo = raiz.find(f'grupos/grupo[@nivel="{nivel}"]')
        if grupo is None:
            grupo = ET.SubElement(grupos, 'grupo', {'nivel': str(nivel)})
        grupo.append(alumno)
        alumnos.remove(alumno)
    raiz.remove(alumnos)
    return arbol

arbol = ET.parse('colegio.xml')
arbol = agrupar(arbol)
ET.dump(arbol.getroot())
