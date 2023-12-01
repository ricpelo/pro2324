"""
9 Obtener nombres de estudiantes
Crear una función que tome un diccionario de nombres de
estudiantes y devuelva una lista de nombres de estudiantes
en orden alfabético.
Ejemplos
get_student_names({
"Student 1" : "Steve",
"Student 2" : "Becky",
"Student 3" : "John"
}) == ["Becky", "John", "Steve"]
"""

def get_student_names(d: dict) -> list[str]:
    """
    >>> get_student_names({ \
            "Student 1" : "Steve", \
            "Student 2" : "Becky", \
            "Student 3" : "John" \
        })
    ['Becky', 'John', 'Steve']
    """
    return sorted(d.values())
