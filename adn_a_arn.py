"""
Escribir en Python una función adn_a_arn(adn) que transcriba la
cadena de ADN indicada en su correspondiente ARNm. El ADN está
formado por las bases A, T, G y C, que en el ARNm se convierten
a U, A, C y G, respectivamente.

Por ejemplo:

adn_a_arn('ATTAGCGCGATATACGCGTAC') == 'UAAUCGCGCUAUAUGCGCAUG'
adn_a_arn('CGATATA') == 'GCUAUAU'
adn_a_arn('GTCATACGACGTA') == 'CAGUAUGCUGCAU'
"""

def adn_a_arn(adn):
    """Traduce de ADN a ARNm."""
    trad = str.maketrans({'A': 'U', 'T': 'A', 'G': 'C', 'C': 'G'})
    return adn.translate(trad)
