
"""
#Problema_1
print("Escribe dos número iguales y uno diferente")

n = float(input("Escribe el primer número: "))
u = float(input("Escribe el segundo número: "))
m = float(input("Escribe el tercer número: "))

if(n==u):
    print(m, "es el número diferente")
elif(n==m):
    print(u, "es el número diferente")
elif(m==u):
    print(n, "es el número diferente")


#Problema_2
a = int(input("Escribe el año que quieres saber si es bisiesto o no: "))

if(a / 4 == a // 4):
    print(a, "si es un año bisiesto")
else:
    print(a, "no es un año bisiesto")


#Problema_3
exp = int(input("Escribe la cantidad de experiencia: "))
niv = int(input("Escribe la cantidad de exp necesaria para subir de nivel: "))
expo = int(input("Escribe la experiencia que obtuviste al matar al monstruo: "))

if(exp + expo >= niv):
    print("Puedes subir nivel")
else:
    print("Aún falta experiencia para subir de nivel")


#Problema_4
print("Escribir números entre 0 y 9")
nm = 0
nme = 0
nmen = 0
a = int(input("Introduce el primer número: "))
b = int(input("Introduce el segundo número: "))
c = int(input("Introduce el tercer número: "))

if(a >= b) & (a >= c):
    nm = a
    if(b >= c):
        nme = b
        nmen = c
    print(nm*100 + nme*10 + nmen)

elif(b >= a) & (b >= c):
    nm = b
    if(a >= c):
        nme = a
        nmen = c
    print(nm*100 + nme*10 + nmen)

elif(c >= a) & (c >= b):
    nm = c
    if(b >= a):
        nme = b
        nmen = a
    print(nm*100 + nme*10 + nmen)


#Problema_5
cc = int(input("Escribir la capacidad de carga: "))
p1 = int(input("Escribir el peso del primer tesoro: "))
v1 = int(input("Escribe el valor del primer tesoro: "))
p2 = int(input("Escribir el peso del segundo tesoro: "))
v2 = int(input("Escribe el valor del segundo tesoro: "))

if(cc >= p1 + p2):
    print(v1 + v2, "es el valor máximo que puedes cargar")
elif(cc < p1 and cc < p2):
    print("No se puede cargar ningún tesoro")
else:
    if( v1 > v2):
        print(v1, "es el valor máximo que puedes cargar")
    elif( v2 > v1):
        print(v2, "es el valor máximo que puedes cargar")


#Problema_6
b = 0
a = int(input("Escribir el año: "))
m = int(input("Escribir el número del mes: "))

if(a / 4 == a // 4):
    b = 1
else:
    b = 0

if( m == 1 or m == 3 or m == 5 or m == 7 or m == 8 or m == 10 or m == 12):
    print("El més tendrá tendrá 31 días")
elif(m == 4 or m == 6 or m == 9 or m == 11):
    print("El més tendrá tendrá 30 días")
else:
    if(m == 2 and b == 0):
        print("El més tendrá 28 días")
    elif(m == 2 and b == 1):
        print("El més tendrá 29 días")

"""
#Problema_7
a = int(input("Escribir el primer número: "))
b = int(input("Escribir el segundo número: "))

number = b - a
i = 2
toggle = 0

while i < number:
    if(number%i == 0):
        toggle = 1
        p = 0
        break
    else:
        i = i+1
if toggle == 0:
    p = 1

if(a > b):
    print("El ciclo será infinito")
elif(a == b):
    print("El ciclo será finito")
elif(a < b and p == 1):
    print("El ciclo será infinito")
elif(a < b and p == 0):
    print("El ciclo será finito")
