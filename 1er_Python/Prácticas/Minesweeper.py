
import random

def GenerarMinas(tablero_v):
    minas = 0 
    while(minas < 100):
        posición = random.randint(0, 479)
        fil = posición // 30
        col = posición % 30

        if tablero_v[fil][col] != 9:
            tablero_v[fil][col] = 9
            minas += 1
            return tablero_v


def MostrarTablero(tablero_v, tablero_e):
    print("  ", end= " ")
    for i in range(fila):
        print(format(i+1, "2d"), end= " ")
    print()

    for i in range(fila):
        print(format(i+1, "2d"), end= " ")
    print()
    for j in range(columna):
            print(tablero[i][j], end= " ")
    else:
            print(tablero_v)


def InicializarTablero(tablero_e, tablero_v):
    for i in range(fila):
        filas = [0] * 30
        tablero_v.append(filas)
        filas = [0] * 30
        tablero_e.append(filas)


columna = int(input("Introduce el número de columnas: "))
fila=int(input("Introduce el número de filas: "))
archm = open("mapa.txt", "w")
arche = open("estado.txt", "w")

tablero=[]
for i in range(fila):
    for j in range(columna):
        print([i+1,j+1], end="")
        archm.write(str([i+1,j+1]) +" ")
    print()
    archm.write("\n")
archm.close()


