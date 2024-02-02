import xml.etree.ElementTree as ET

def generar(archivo):
    """hola"""
    arbol = ET.parse(archivo)
    raiz = arbol.getroot()
    definiciones = []
    for funcion in raiz.findall('funcion'):
        nombre = funcion.find('nombre').text
        docstring = funcion.find('docstring')
        docstring = f'\n    """{docstring.text}"""' if docstring is not None else ''
        params = []
        for parametro in funcion.findall('parametros/parametro'):
            params.append(parametro.text)
        cuerpo = funcion.find('cuerpo').text
        cuerpo = '    ' + cuerpo.replace('\n', '\n    ')
        # res = []
        # for linea in cuerpo.split('\n'):
        #     res.append('    ' + linea)
        # cuerpo = '\n'.join(res)
        params = ', '.join(params)
        definicion = f'def {nombre}({params}):{docstring}{cuerpo}'
        definiciones.append(definicion)
    return '\n'.join(definiciones)

print(generar('p1.xml'))
