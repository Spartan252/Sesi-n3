def cambio(denominaciones, monto):
    resultado = [float('inf')] * (monto + 1)
    resultado[0] = 0
    for i in range(1, monto + 1):
        for j in range(len(denominaciones)):
            if denominaciones[j] <= i:
                subresultado = resultado[i - denominaciones[j]]
                if subresultado != float('inf') and subresultado + 1 < resultado[i]:
                    resultado[i] = subresultado + 1
    return resultado[monto]


denominaciones = [2, 7, 9]
monto = 15
print("Monto:",monto,"\tDenominaciones:",denominaciones, "\nNúmero mínimo de monedas necesarias:", cambio(denominaciones, monto))
