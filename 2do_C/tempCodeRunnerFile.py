def Divide_a():
    Div = []
    temporal = 0
    cont = 0
    for x in C_Relacion:
        for y in x:
            if temporal == 0:
                temporal = y
            if cont == 1:
                if (y // temporal) == (y / temporal):
                    Div.append(x)
                temporal = 0
                cont = 0
            cont =+ 1
        cont = 0
    print(Div)
    C_Relacion = Div
    print(C_Relacion)
    
def Suma_par():
    Par = []
    temporal = 0
    for x in C_Relacion:
        for y in x:
            temporal += y
    if temporal == ((temporal//2)*2):
        Par.append(x)
        temporal = 0
    print(Par)