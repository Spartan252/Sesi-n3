"""
y = 0
while(y==0):
    edad = input("Introduce tu edad: ")
    if(edad.isnumeric() == False):
        print("Escribe un valor numérico")
        continue
    elif(int(edad) < 18): 
        print("No eres mayor de edad ")
        continue
    else:
        y = 1 
print("Eres mayor de edad")
"""

"""
#Problema1
y = 0
while(y==0):
    edad = input("Introduce tu edad: ")
    if(edad.isnumeric() == False):
        print("Escribe un valor numérico")
        continue
    elif(int(edad) < 18): 
        print("No eres mayor de edad ")
        continue
    else:
        y = 1 
print("Eres mayor de edad")


#Problema2
y = 0
while(y==0):
    num = input("Introduce un número: ")
    if(num.isnumeric() == False):
        print("Escribe un valor numérico positivo")
        continue
    else:
        y = 1
print(num, "es positivo")


#Problema3
y = 0
while(y == 0):
    num = input("Introduce un número: ")
    if(num.isnumeric() == False):
        print("Escribe un valor numérico")
        continue
    elif(int(num)//2 != int(num)/2 or int(num)//3 != int(num)/3):
        print("El número no es par o no es múltiplo de 3")
        continue
    else:
        y = 1
print("El número es par y es múltiplo de 3")


#Problema4
edad_1 = int(input("Intruduce la primera edad: "))
edad_2 = int(input("Intruduce la segunda edad: "))
while(edad_1 < 18 or edad_2 < 18):
    print("Alguna de las edades es menor de edad")
    edad_1 = int(input("Intruduce la primera edad: "))
    edad_2 = int(input("Intruduce la segunda edad: "))
else:
    if(edad_1 >= 18 and edad_2 >= 18):
        print("Ambos son mayor de edad")


#Problema5
num_a = int(input("Introduce un número: "))
num_b = int(input("Introduce el siguiente número: "))
while(num_a != num_b - 1):
    print(num_a, "y", num_b, "no están en orden ascendente consecutivo")
    num_a = int(input("Introduce un número: "))
    num_b = int(input("Introduce el siguiente número: "))
else:
    print(num_a, "y", num_b, "están en orden ascendente consecutivo")


#Problema6
edad_1 = int(input("Intruduce la primera edad: "))
edad_2 = int(input("Intruduce la segunda edad: "))
edad_3 = int(input("Intruduce la tercera edad: "))
while(edad_1 < 18 and edad_2 < 18 and edad_3 < 18):
    print("Todas las edades son menor de edad")
    edad_1 = int(input("Intruduce la primera edad: "))
    edad_2 = int(input("Intruduce la segunda edad: "))
    edad_3 = int(input("Intruduce la tercera edad: "))
else:
    if(edad_1 >= 18 or edad_2 >= 18 or edad_3 >=18):
        print("Hay al menos una edad mayor de edad")

#Problema7
num_a = int(input("Introduce un número: "))
num_b = int(input("Introduce el siguiente número: "))
num_c = int(input("Introduce el siguiente número: "))
while(num_a > num_b or num_b > num_c or num_a > num_c):
    print(num_a, ",", num_b, "y", num_c, "no están en orden ascendente")
    num_a = int(input("Introduce un número: "))
    num_b = int(input("Introduce el siguiente número: "))
    num_c = int(input("Introduce el siguiente número: "))
else:
    print(num_a, ",", num_b, "y", num_c, "están en orden ascendente")


#Problema8
pal = input("Introduce una palabra: ")
while(len(pal) < 8):
    print(pal, "tiene menos de 8 letras")
    pal = input("Introduce una palabra: ")
else:
    print(pal, "tiene mas de 8 letras")



#Problema9
pal = str(input("Introduce una palabra: "))
lar = len(pal) - 1
while(pal[lar] != "n" and pal[lar] != "s" and pal[lar] != "a" and pal[lar] != "e" and pal[lar] != "i" and pal[lar] != "o" and pal[lar] != "u"):
    print(pal, "no termina con n, s o vocal.")
    pal = input("Introduce una palabra: ")
else:
    print(pal, "si termina con n, s o vocal.")

"""
#Problema10
pal = str(input("Introduce una frase: "))
lar = len(pal)-1
while(pal[lar] != "."):
    print(pal, "no termina con .")
    pal = str(input("Introduce una frase: "))
else:
    print(pal, "si termina con .")

"""
#Problema1 V1
edad = int(input("Introduce tu edad: "))
while(edad<18):
    print("No eres mayor de edad")
    edad = int(input("Introduce tu edad: "))
else:
    print("Eres mayor de edad")


#Problema1 V2
edad = input("Introduce tu edad: ")
while(edad.isnumeric() == False):
    print("Escribe un valor numérico")
    edad = input("Introduce tu edad: ")
if(edad.isnumeric() == True):
    while(int(edad) < 18):
        print("No eres mayor de edad")
        edad = input("Introduce tu edad: ")
        while(edad.isnumeric() == False):
            print("Escribe un valor numérico")
            edad = input("Introduce tu edad: ")
    else:
        print("Eres mayor de edad")

#Problema1 V3
y = 0
while(y==0):
    edad = input("Introduce tu edad: ")
    if(edad.isnumeric() == False):
        print("Escribe un valor numérico")
        continue
    elif(int(edad) < 18): 
        print("No eres mayor de edad ")
        continue
    else:
        y = 1 
print("Eres mayor de edad")

#Problema3
y = 0
while(y == 0):
    num = input("Introduce un número: ")
    if(num.isnumeric() == False):
        print("Escribe un valor numérico")
        continue
    elif(int(num)//2 != int(num)/2 or int(num)//3 != int(num)/3):
        print("El número no es par o no es múltiplo de 3")
        continue
    else:
        y = 1
print("El número es par y es múltiplo de 3")
"""
