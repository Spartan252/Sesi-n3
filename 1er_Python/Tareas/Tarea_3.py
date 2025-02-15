
"""
# Problema_1 – Si el número a es menor que b está en orden ascendente, si no, es descendente
# 2 variables de número entero ---> a, b
a = int(input("Introduce un número: "))
b = int(input("Introduce otro número: "))
if(a < b):
    print(a, "y", b, "están en orden ascendente")
else:
    print(a, "y", b, "están en orden descendente")


# Problema_2 - si el número n dividido entre 9 es igual a la división entera del número n entre 9 entonces es divisible entre 9, si no, no lo es
# 1 variable de número entero y 1 variable alfanumérica---> n, m
n = int(input("Introduce un número: "))
m = n / 9 
if(int(m) == m):
    print(n,"es divisible entre 9")
else:
    print(n, "no es divisible entre 9")


# Problema_3 - Si el número n dividido entre a es igual al resultado entero de esta operación entonces n es múltiplo de a, si no, no lo es
# 2 variables de número entero y una variable alfanumérica ---> n, a, m
n = int(input("Introduce el número múltiplo: "))
a = int(input("Introduce otro número: "))
m = n / a 
if(int(m) == m):
    print(n, "es múltiplo de", a)
else:
    print(n, "no es múltiplo de", a)


#Problema_4 - si la operación z es diferente a 0 entonces tiene solución real, si no, no
# 3 variables de número entero y 1 variable alfanumérica ---> a, b, c, z
a = int(input("Introduce a: "))
b = int(input("Introduce b: "))
c = int(input("Introduce c: "))
z = ((b ** 2 - 4 * a * c))
if(z != 0):
    print("Tiene solución real")
else:
    print("No tiene solución real")


#Problema_5 - si a es mayor que b y b mayor que c, entonces están en orden descendente, si no, no lo están
# 3 variables de número entero ---> a, b, c
a = int(input("Introduce a: "))
b = int(input("Introduce b: ")) 
c = int(input("Introduce c: ")) 
if(a>b>c):
    print(a, ",", b, "y", c, "están en orden descendente")
else:
    print(a, ",", b, "y", c, "no están en orden descendente")


#Problema_6 - si la división entera de n entre 2 por 2 es igual a n entero, n es entero, si no, no
# 1 variable de número entero ---> n
n = int(input("Introduce un número: "))
if(n//2*2 == int(n)):
    print(n, "es par")
else:
    print(n, "no es par")


#Problema_7 - si x o y es igual a 0, entonces están sobre un eje, si no, no
# 2 variables de número entero ---> x, y
x = int(input("Introduce punto X: "))
y = int(input("Introduce punto Y: "))
if (x == 0):
    print(x, "está en el eje X")
elif (y == 0):
    print(y, "está en el eje Y")
else:
    print("El punto no está en el eje X o Y")


#Problema_8 - si la multiplicación del resultado entero de la raíz cuadrada de n por sí mismo es igual a n, entonces n tiene raíz cuadrada entera, si no, no
# 2 variables de número entero ---> n, r
n = int(input("Introduce un número: "))
r = int(n**.5)
if(n == (r * r)):
    print(n, "tiene raíz cuadrada entera")
else:
    print(n, "no tiene raíz cuadrada entera")


#Problema_9 - si c al cuadrado es igual a a cuadrada más b cuadrada entonces sí se puede, si no, no
# 3 variables de número entero y 2 variables alfanuméricas ---> a, b, c, f, g
a = int(input("Introduce el cateto a: "))
b = int(input("Introduce el cateto b: "))
c = int(input("Introduce la hipotenusa: "))
f = c**2
g = a**2 + b**2
if(f == g):
    print("Si se puede formar un triángulo rectángulo")
else:
    print("No se puede formar un triángulo rectángulo")


#Problema_10 - si la raíz cuadrada de x al cuadrado más y al cuadrado es igual a r, entonces, está sobre la circunferencia, si no, no
# 3 variables de número entero y 1 variable alfanumérica ---> x, y, r, c
x = int(input("Introduce X: "))
y = int(input("Introduce Y: "))
r = int(input("Introduce el radio: "))
c = (x**2 + y**2)**.5
if( c == r):
    print("Está sobre la circunferencia")
else:
    print("No está sobre la circunferencia")


#Problema_11 - si r es mayor a 0, es positivo, si r es igual a 0, es igual a cero, si no, es negativo
# 1 variable de número decimal ---> r
r = float(input("Introduce el número: "))
if(r > 0):
    print(r, "es positivo")
elif(r == 0):
    print(r, "es igual a 0")
else:
    print(r, "es negativo")


#Problema_12 - si e es menor a 18, es menor de edad, si e es menor a 60 y mayor o igual a 18, es adulto, si no, tercera edad
# 1 variable de número entero ---> e
e = int(input("Introduce la edad: "))
if(e < 18):
    print("Es menor de edad")
elif(60 > e >= 18):
    print("Es adulto")
else:
    print("Es de tercera edad")


#Problema_13 - si a es menor que b y a es menor que c, a es menor, si b es menor que a y b es menor que c, b es menor, si no, c es menor
# 3 variables de número entero ---> a, b, c
a = int(input("Introduce el primer número: "))
b = int(input("Introduce el segundo número: "))
c = int(input("Introduce el tercer número: "))
if(a < b) & (a < c):
    print(a, "es el número menor")
if(b < a) & (b < c):
    print(b, "es el número menor")
else:
    print(c, "es el número menor")


#Problema_14 - si a es mayor que b y a es mayor que c, a es mayor, si b es mayor que a y b es mayor que c, b es mayor, si no, c es mayor
# 3 variables de número entero ---> a, b, c
a = int(input("Introduce el primer número: "))
b = int(input("Introduce el segundo número: "))
c = int(input("Introduce el tercer número: "))
if(a > b) & (a > c):
    print(a, "es el número mayor")
if(b > a) & (b > c):
    print(b, "es el número mayor")
else:
    print(c, "es el número mayor")


#Problema_15 - si el lado a + b es mayor que c y a + c es mayor que b y b + c es mayor que a si se puede, si no, no
# 3 variables de número decimal ---> a, b, c
a = float(input("Introduce el primer lado: "))
b = float(input("Introduce el segundo lado: "))
c = float(input("Introduce el tercer lado: "))
if(a + b > c and a + c > b and b + c > a):
    print("Si pueden ser las medidas de un triángulo")
else:
    print("No pueden ser las medidas de un triángulo")
"""


