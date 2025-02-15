
"""
nombre = input("Introduce tu nombre: ")
apellidos = input("Introduce tus apellidos: ")
edad = int(input("Introduce tu edad: "))
carrera = input("Introduce tu carrera: ")
expediente = int(input("Introduce tu expediente: "))
ciudad_de_origen = input("Introduce tu ciudad de origen: ")
foraneo = input("Introduce si eres foraneo ( Y, N ): ")
codigo_postal = int(input("Introduce tu codigo postal: "))
altura = int(input("Introduce tu altura: "))
peso = int(input("Introduce tu peso: "))

print("Nombre: ", nombre, apellidos)
print("Carrera: ", carrera, end=", ")
print("Expediente: ", expediente)
print("Ciudad de origen: ", ciudad_de_origen)
print("Altura: ",altura, end="mts, ")
print("Peso: ", peso, end="kgs")
"""
#
#
"""
#IMC

p = float(input("Introduce tu peso en kg: "))
a = float(input("Introduce tu altura en mt: "))
imc= p / a**2
if(imc < 25):
    if(imc <= 18.5):
        print("Tu índice de masa corporal es: bajo peso")
    else:
        print("Tu índice de masa corporal es: bajo peso")
elif(imc < 30):
    print("Tu índice de masa corporal es: sobrepeso")
else:
    print("Tu índice de masa corporal es: obesidad")
print("Gracias, adios")

#Diana

x = float(input("Introduce la coordenada X: "))
y = float(input("Introduce la coordenada Y: "))
r = (x**2 + y**2)**.5
if(r <= 1):
    print("Sección A")
elif(r <= 2):
    print("Sección B")
elif(r <= 3):
    print("Sección C")
elif(r <= 4):
    print("Sección D")
elif(r <= 5):
    print("Sección E")
elif(r <= 6):
    print("Sección F")
else:
    print("Fuera")
print("Gracias, adios")
"""
#
#
"""
number = int(input( "Dame un número: "))
i = 2
toggle = 0

while i < number:
    if(number%i == 0):
        toggle = 1
        print ("No es primo ")
        break
    else:
        i = i+1
if toggle == 0:
    print ("Es primo")
"""
#
#
"""
import time
inicio = time.time()

number = int(input( "Dame un número: "))
i = 2
primo = False

while i < number**0.5:
    if(number%i == 0):
        primo = True
        print ("No es primo ")
        break
    else:
        i += 2
if primo == False:
    print ("Es primo")
"""
#
# 22/09/2022
"""
num = (input( "Dame un número del 0 al 10: "))
if(num.isnumeric() == True):
    num = int(num)
    if(num >=0 and num <=10):
        print(num, "es un número y está dentro del rango")
    elif(num < 0 or num >10):
        print(num, "es un número pero está fuera del rango")
elif(num.isnumeric() == False):
    print(num, "no es un número")
"""
#
#26/09/2022
"""
num = int(input("Dame un número: "))
x = 0
if(num<0):
    num = num * -1
    x = 1
while(int(num) >= 10):
    num = (num // 10) + (num - ((num // 10)*10))
if(x == 1):
    print(num*-1)
else:
    print(num)
"""
#
#03/10/2022
"""
frase = str(input("Escribe una frase: "))
correcto = True

for i in range(len(frase)):
    if (i == 0):
        if not(frase[i].isupper()):
            correcto = False
    elif(i == len(frase) - 1):
        if(frase[i] != "."):
            correcto = False
    else:
        if not(frase[i].islower() and frase[i] != " "):
            correcto = False
        else:
            if(frase[i] == " "):
                if not( frase[i + 1].islower()):
                    correcto = False
print(correcto)
"""
#
#06/10/2022
"""
from math import asin, cos, radians, sin, sqrt

x1 = float(input(""))
y1 = float(input(""))
x2 = float(input(""))
y2 = float(input(""))
r = 6371.01

x1 = radians(x1)
y1 = radians(y1)
x2 = radians(x2)
y2 = radians(y2)

d = 2rasin(sqrt((sin((x2-x1)/2))2+(cos(x1)cos(x2)((sin((y2-y1)/2))2))))

print(round(d))
"""
#
#10/10/2022
"""
c = input("Introduce una cadena de números separados por comas: ")

lista = c.split(",")
print(c)
print(lista)

for i in lista:
    print(i)
"""
#
#13/10/2022
"""
cadena = "Hola mundo"
lista = [1, 2, 3, "Hola", "mundo", ["a", "b", "c"]]

print (cadena)
print(lista)
print(cadena[0])
print(lista[0])
print(cadena[0:3])
print(lista[0:4])
print(lista[5][2])
"""
"""
print("   [a]")
print("  [b, c]")
print(" [d, e, f]")
print("[g, h, i, j]")

print("Escriba los valores de:")
a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))
d = int(input("d: "))
e = int(input("e: "))
f = int(input("f: "))
g = int(input("g: "))
h = int(input("h: "))
i = int(input("i: "))
j = int(input("j: "))

if(a+b+d+e+g+h+i > a+c+e+f+h+i+j):
    camino = 1
else:
    camino = 2

if(camino == 1):
    if(a+b+d+g+h > a+b+e+h+i):
        camino = 3
if(camino == 3):
    if()

"""
#
#17/10/2022
"""
lar = float(input("Introduce el largo de la muralla: "))
if(lar < 0):
    lar = lar * -1
anch = float(input("Introduce el ancho de la muralla: "))
while(anch > (lar / 2)):
    print("Introduce un numero que sea menor a la mitad del largo")
    anch = float(input("Introduce el ancho de la muralla: "))
if(anch < 0):
    anch = anch * -1
r_2 = float(input("Introduce el r2 de la torre: "))
while(r_2 > (lar / 2)):
    print("Introduce un numero que sea menor a la mitad del largo")
    r_2 = float(input("Introduce el r2 de la torre: "))
if(r_2 < 0):
    r_2 = r_2 * -1
r_1 = float(input("Introduce el r1 de la torre: "))
while(r_1 >= r_2):
    print("Introduce un número que sea menor al r2")
    r_1 = float(input("Introduce el r1 de la torre: "))
if(r_1 < 0):
    r_1 = r_1 * -1


x = float(input("Introduce la coordenada X: "))
y = float(input("Introduce la coordenada Y: "))

if((x-(lar/2))**2 + (y-(lar/2))**2 < r_1**2):
    print("Cayó en la torre")
elif((x-(lar/2))**2 + (y-(lar/2))**2 < r_2**2):
    print("Cayó en la muralla")
elif((lar/2)-(anch/2) <= x <= (lar/2)+(anch/2) and 0 <= y <= (lar/2)):
    print("Cayó en la muralla")
elif((lar/2)-(anch/2) <= y <= (lar/2)+(anch/2) and 0 <= x <= (lar/2)):
    print("Cayó en la muralla")
elif(x <= (lar/2)-(anch/2) and y <= (lar/2)-(anch/2)):
    print("Cayó en el patio")
else:
    print("Cayó fuera del castillo")
"""
#Práctica 7
#20/10/2022
"""
CASTILLO:
WallLength = float(input())
if(WallLength < 0):
    WallLength = WallLength * -1
    
wallWidth = float(input())
if(wallWidth < 0):
    wallWidth = wallWidth * -1

r1 = float(input())

r2 = float(input())

x = float(input())
if(x < 0):
    x = x * -1
y = float(input())
if(y < 0):
    y = y * -1

if((x-(WallLength/2))**2 + (y-(WallLength/2))**2 < r1**2):
    print("Sobre las torres.")
elif((x-(WallLength/2))**2 + (y-(WallLength/2))**2 < r2**2):
    print("Sobre las paredes.")
elif((WallLength/2)-(wallWidth/2) <= x <= (WallLength/2)+(wallWidth/2) and 0 <= y <= (WallLength/2)):
    print("Sobre las paredes.")
elif((WallLength/2)-(wallWidth/2) <= y <= (WallLength/2)+(wallWidth/2) and 0 <= x <= (WallLength/2)):
    print("Sobre las paredes.")
elif(x <= (WallLength/2)-(wallWidth/2) and y <= (WallLength/2)-(wallWidth/2)):
    print("Dentro del castillo.")
else:
    print("Fuera del castillo.")


POLÍGONO:
n = int(input())
res = 0
sum = 0
ladon = n + n - 1
for i in range(n-1):
    res = res +1
    sum = sum + res
resultado = ladon * ladon
resultado = resultado - (sum * 4)
print(resultado)

ALFÍL:

PIRÁMIDE:
def Comparador(x,y,z):
    if (x+z)>(y+z):
        return x
    else:
        return y

niveles = int(input())
i = 0
listanivel = []
for i in range(niveles):
    a = 0
    cadena = input()
    c = cadena.split(" ")
    listanum = []
    for a in range(len(c)):
        listanum.append(int(c[a]))
    listanivel.append(listanum)
level = niveles-1
while level != -1:
    i = 0
    listcom = []
    if level != 0:
        for i in range(len(listanivel[level-1])):
            x = listanivel[level][i]
            y = listanivel[level][i+1]
            z = listanivel[level-1][i]
            listanivel[level-1][i] += Comparador(x=x,y=y,z=z)
    level -= 1
print(listanivel[0][0])
"""
#Manipulación de archivos
#27/10/2022
"""
archivo = open("text.txt", "w")
archivo.write("Hola mundo")
archivo.write("Hola mundo")
archivo.write("Hola mundo")
"""
