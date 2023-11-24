def binomial(n, k):
    def semi_fact(n, k):
        i = n
        res = 1
        while i >= (k + 1):
            res *= i
            i -= 1
        return res

    def fact(m):
        res, i = 1, 1
        while i <= m:
            res *= i
            i += 1
        return res

    return semi_fact(n, k) / fact(n - k)


def binomial_rec(n, k):
    if k == 0 or n == k:
        return 1
    return binomial_rec(n - 1, k - 1) + binomial_rec(n - 1, k)


def lista_sobre_A(ultima_fila: int):
    if ultima_fila == 0:
        return [[1]]
    uno_menos = lista_sobre_A(ultima_fila - 1)
    anterior = uno_menos[-1]
    x = [0] + anterior
    y = anterior + [0]
    i = 0
    ultima = []
    while i < len(x):
        ultima.append(x[i] + y[i])
        i += 1
    return uno_menos + [ultima]
