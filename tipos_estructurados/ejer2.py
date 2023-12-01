"""
2 Asignar personas a profesiones
Tienes dos listas. Una muestra los nombres de las personas
(names), mientras que el otro muestra sus profesiones (jobs).
Tu tarea es crear un diccionario que muestre a cada persona
con su respectiva profesión.
"""

def assign_person_to_job(names: list[str], jobs: list[str]) -> dict:
    """
    >>> names = ["Dennis", "Vera", "Mabel", "Annette", "Sussan"]
    >>> jobs = ["Butcher", "Programmer", "Doctor", "Teacher", "Lecturer"]
    >>> assign_person_to_job(names, jobs)
    {
        "Dennis": "Butcher",
        "Vera": "Programmer",
        "Mabel": "Doctor",
        "Annette": "Teacher",
        "Sussan": "Lecturer"
    }
    """
    res = {}
    for n, t in zip(names, jobs):
        res[n] = t
    return res
    # return dict(zip(names, jobs))
