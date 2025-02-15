
"""
#Problema1
nom = input("Esribe tu nombre: ")
print("Tu nombre tiene",len(nom), "carácteres")


#Prueba
x = len(str(1234))
print(x)


#Problema2
num = str(input("Introduce el número: "))
print("El número tiene", len(num), "dígitos")


#Problema3
pal = input("Escribe una palabra: ")
lar = len(pal)
print(lar)
num = int(input("Escribe un número no mayor al número de arriba: "))
num = num-1
print(pal [num])


#Problema4
pal = input("Escribe una palabra: ")
lar = len(pal)
print(lar)
num = int(input("Escribe un número no mayor al número de arriba: "))
print(pal [0 : num])


#Problema5
pal = input("Escribe una palabra: ")
lar = len(pal)
print(lar)
num = int(input("Escribe un número no mayor al número de arriba: "))
print(pal [len(pal)-num : ])


#Problema6
curp = input("Escribe tu CURP: ")
if(int(curp[4:6]) <= 22):
    print("Naciste el año", int(curp[4:6]) + 2000)
else:
    print("Naciste el año", int(curp[4:6]) + 1900)

print("Naciste el mes", curp[6:8])

print("Naciste el día", curp[8:10])

sex = str(curp[10])
if(sex == "M"):
    print("Eres mujer")
else:
    print("Eres hombre")


#Problema7
fec = input("Escribe la fecha en formato dd/mm/aaaa: ")

print(fec[3:5],"/",fec[0:2],"/",fec[6:10])


#Problema8
num = (input("Introduce el número: "))
mun = num[::-1]
print("La suma de", num, "mas su reflejo es", float(num)+float(mun))


#Problema9
ficha = input("Escribe los números de la ficha con el formato #:#: ")
lado_a = ficha[0]
lado_b = ficha[2]
if(int(lado_a) == int(lado_b)):
    print("La ficha", ficha, "si es una mula")
else:
    print("La ficha", ficha, "no es una mula")
"""

#Problema10
pal = str(input("Escribe una frase: "))
lar = int(len(pal))-1
may = pal[0].upper()
if(pal[0] == may and pal[lar] == "."):
    print("La frase está bien escrita")
else:
    print("La frase está mal escrita")
