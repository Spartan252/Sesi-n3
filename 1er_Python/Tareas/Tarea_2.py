
"""
#Problema_1
# 1 variable de número entero --> edad
edad = int(input("Introduce tu edad: "))
print("Tu edad dentro de 10 años será: ", edad + 10, "años")


#Problema_2
# 1 variable de número entero --> num 
num = int(input("Introduce un número entero: "))
print("El siguiente número entero será: ", num+1)

#Problema_3
# 1 variable de número entero --> num 
num = int(input("Introduce un número entero: "))
print("El doble del número es: ", num*2)
print("La mitad del número es: ", num/2)

#Problema_4
# 2 variables de número entero ---> num_A, num_B
num_A = int(input("Introduce un número entero: "))
num_B = int(input("Introduce otro número entero: "))
print(" La suma de los dos números es: ", num_A + num_B)
print(" La resta de los dos números es: ", num_A - num_B)
print(" La multiplicación de los dos números es: ", num_A * num_B)
print(" La división de los dos números es: ", num_A / num_B)

#Problema_5
# 1 variable de número entero --> num 
num = int(input("Introduce un número entero mayor a 10: "))
print("El número entero tiene", int(num / 10), "decenas")

#Problema_6
# 2 variables de número entero --> num, num_2
num = int(input("Introduce un número entero mayor a 100: "))
num_2 = int(num / 100)
print("El número en las centenas es: ", num_2 - int(num_2 / 10)*10)

#Problema_7
# 2 variables de número entero --> num, num_par
num = int(input("Introduce un número entero: "))
num_par=num // 2 * 2 + 2
print("El siguiente número par es: ", num_par)

#Problema_8
# 1 variable alfanumérico --> pal
pal = (input("Introduce una palabra: "))
print("(", pal, ")") 

#Problema_9
# 2 variables alfanuméricas --> pal_A, pal_B
pal_A = (input("Introduce una palabra: "))
pal_B = (input("Introduce otra palabra: "))
print( pal_A + " " + pal_B ) 

#Problema_10
# 3 variables de número entero --> num, num_2, num_3
num = int(input("Introduce un número entero entre 100 y 999: "))
num_2 = int(num / 10)
num_3 = int(num / 100)
print("El número en las centenas es: ", num_3 - int(num_2 / 100)*10)
print("El número en las decenas es: ", num_2 - int(num_2 / 10)*10)
print("El número en las unidades es: ", num - int(num_2*10))

#Problema_11
# 1 variable alfanumérica --> pal
pal = (input("Introduce una palabra: "))
print("Minúsculas: ", pal.lower())
print("Mayúsculas: ", pal.upper())

#Problema_12
# 1 variable de número entero y 1 variable alfanumérica --> num, let
let = (input("Introduce una letra: "))
num = int(input("Introduce un número: "))
print(let * num)

#Problema_13
# 1 variable de número entero --> num 
num = int(input("Introduce un número: "))
print("La raíz cuadrada del número es: ", num ** .5)

#Problema_14
# 3 variables de número entero y 4 variables numéricas --> a, b, c, d, raiz, x_1, x_2
a = int(input("Introduce a: "))
b = int(input("Introduce b: ")) 
c = int(input("Introduce c: ")) 
d = b * b - 4 * a * c
raiz = d ** .5
x_1 = (-b + raiz) / (2 * a)
x_2 = (-b - raiz) / (2 * a)
print("X1= ", x_1)
print("X2= ", x_2)
"""

#Problema_15
# 2 variables de número entero --> a, b
x_1 = int(input("Introduce punto X1: "))
y_1 = int(input("Introduce punto Y1: "))
x_2 = int(input("Introduce punto X2: "))
y_2 = int(input("Introduce punto Y2: "))
dex = (x_1 - x_2)**2
dey = (y_1 - y_2)**2
det = (dex + dey)**.5
print("La distancia euclidiana es de: ", det)
print("El punto medio es: ", det / 2)

