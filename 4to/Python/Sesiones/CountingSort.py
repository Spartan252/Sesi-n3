

import math
import os
import random
import re
import sys

#
# Complete the 'countSort' function below.
#
# The function accepts 2D_STRING_ARRAY arr as parameter.
#
def countSort(arr):
    dicc = {}
    mitad_arr = len(arr)//2
    for indice, contenido in enumerate(arr):
        clave = int(contenido[0])
        valor = "-" if indice < mitad_arr else contenido[1]
        if clave in dicc.keys():
            dicc[clave].append((indice, valor))
        else:
            dicc[clave] = [(indice, valor)]

    texto = ""
    for clav in sorted(dicc.keys()):
        strings = [x[1] for x in sorted(dicc[clav])]
        texto = " ".join([texto, *strings])
    print(texto.strip())



def countSort(arr):
    dicc = {}
    mitad_arr = len(arr) // 2

    for índice, contenido in enumerate(arr):
        clave = int(contenido[0])
        valor = "-" if índice < mitad_arr else contenido[1]
        if clave in dicc.keys():
            dicc[clave].append(valor)
        else:
            dicc[clave] = [valor]

    texto = ""
    for clav in sorted(dicc.keys()):
        texto = " " .join([texto, *dicc[clav]])
    print(texto.strip())
        

if __name__ == '__main__':
    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(input().rstrip().split())

    countSort(arr)