

#A
"""
alfabeto = "abcdefghijklmnopqrstuvwxyz"
listablero = []
listares=[]
mensaje = input()
clave = input()

def Criptograma():
    cadena = alfabeto
    for i in range(26):
        listablero.append(cadena)
        cadena = cadena[1:]+cadena[0]
    return 0

Criptograma()

clvext= ""
if len(mensaje)%len(clave)==0:
    clavext = claveint(len(mensaje)/len(clave))
else:
    clavext = claveint(len(mensaje)/len(clave))
    clavext += clave[:len(mensaje)%len(clave)]

def Resultados():
    for i in range(len(mensaje)):
        columna = listablero[0].find(mensaje[i])
        for a in range(26):
            if clavext[i] == listablero[a][0]:
                fila = a
        listares.append([fila,columna])
    return 0

Resultados()

for i in range(len(listares)):
    print(listablero[listares[i][0]][listares[i][1]],end="")
"""

#_________________________________________________________________________________________
#B
"""
n_calif = int(input())
while n_calif != 0:

    cal = int(input())

    if cal >= 38 and (((cal // 5)*5 + 5) - cal) <= 2:
        print(((cal // 5)*5 + 5))
    
    elif cal < 37:
        print(cal)
    
    else:
        print(cal)
    
    n_calif = n_calif - 1
"""

#_________________________________________________________________________________________
#C Bien
"""
import time

x = 4
while x > 0:
    time.sleep(1)
    x -= 1
    print(x)
if x == 0:
    print("hola")
"""
"""
while True:
    try:
        num_1 = int(input())
        num_2 = int(input())
    except:
        break
    
    if num_1 == "0" or num_1 == "":
        break

    if(num_1 + num_2 > 1 and num_1 + num_2 <= 100):
        if((num_1 + num_2) // 2 == (num_1 + num_2)/2):
            print("pacusticos")
        elif((num_1 + num_2) // 2 != (num_1 + num_2)/2):
            print("impacusticos")
    else:
        print("")
"""
#_________________________________________________________________________________________
#D





#_________________________________________________________________________________________
#E
""" Bien
chup = input()
data = chup.split(" ")
alt_c = float(data[0])
dist_p = float(data[1])
vel_p = float(data[2])
vel_c = float(data[3])

tmp = (alt_c / (0.5 * 9.81))**0.5

r = (dist_p + (tmp*(vel_c - vel_p))) / vel_p

x=3
for i in range(len(str(r))):
    if str(r)[i]!=".":
        x+=1
    else:
        break
if int(str(r)[x])>5 and r>0:
    r+=0.01
if int(str(r)[x])>5 and r<0:
    r-=0.01
print(str(r)[0:x])
"""
""" MAL
chup = input()
data = chup.split(" ")
alt_c = float(data[0])
dist_p = float(data[1])
vel_p = float(data[2])
vel_c = float(data[3])

tmp = (alt_c * 2 / 9.81)**0.5

r = (dist_p + (tmp*(vel_c - vel_p))) / vel_p

x=1
if str(r)[0] == "-":
    r *= -1
    y=1

while True:
    if str(r)[x] == ".":
        if str(r)[x+3] >= str(5):
            r += 0.01
            if y==1:
                r *= -1
                print(str(r)[0:x+4:])
            else:
                print(str(r)[0:x+3:])
        else:
            print(str(r)[0:x+3:])
        break
    else:
        x += 1
"""


#_________________________________________________________________________________________
#F
"""
inp = input()

bandera = False
c1,c2,c3,c4,co = 0,0,0,0,0

while len(inp)>0:
    if inp[0]=="1":
        c1 += 1
    elif inp[0]=="2":
        c2 += 1
    elif inp[0]=="3":
        c3 += 1
    elif inp[0]=="4":
        c4 += 1
    else:
        co += 1
    inp = inp[1:]
print(c1,c2,c3,c4,co)
"""

#_________________________________________________________________________________________
#G
"""
juegos = int(input())
listares = []

def Recibir():
    listloc=[]
    for i in range(juegos):
        a = input()
        b = a.split("-")
        listloc.append(b)
    return listloc

def Resultado(celdas:int,rondas:int):
    listacelda = [False]*celdas
    for i in range(rondas):
        for a in range(celdas):
            numi = i+1
            numa = a+1
            if (numa*numi)-1 <= len(listacelda)-1:
                if listacelda[(numa*numi)-1]:
                    listacelda[(numa*numi)-1] = False
                else:
                    listacelda[(numa*numi)-1] = True
            else:
                break
    contador = 0
    for i in range(len(listacelda)):
        if listacelda[i]:
            contador+=1
    return contador
        
listasgen = Recibir()
for i in range(juegos):
    listares.append(Resultado(int(listasgen[i][0]),int(listasgen[i][1])))

for i in range(len(listares)):
    print(listares[i])
"""
#_________________________________________________________________________________________
#H Bien
"""
grad_pol = int(input())

print(grad_pol // 2 + 1)
"""

