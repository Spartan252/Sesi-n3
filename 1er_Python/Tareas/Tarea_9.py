

#A - Bien 
"""
n_data = int(input())


for x in range(n_data):
    z = ""
    x += 1
    data = input()

    pal = data.split(" ")
    pal.reverse()

    for y in range(len(pal)):
        z = z + pal[y] + " "
    print("Case #" + str(x) + ": " + z)
"""

#B - Bien
"""
par_pal = int(input())

while par_pal != 0:
    pal_1 = input()
    pal_2 = input()
    
    if(sorted(pal_1) == sorted(pal_2)):
        print("SI")
    else:
        print("NO")

    par_pal -= 1
"""

#C
"""
n_cas = int(input())
for i in range(n_cas):
    esp = input().split(" ")
    a = int(esp[0])
    b = int(esp[1])
    lis = []
    for x in range(a):
        m = input()
        for y in range(b):
            n = m[y] 
            if n == "1":
                lis.append("0001")
            elif n == "2":
                lis.append("0010")
            elif n == "3":
                lis.append("0011")
            elif n == "4":
                lis.append("0100")
            elif n == "5":
                lis.append("0101")
            elif n == "6":
                lis.append("0110")
            elif n == "7":
                lis.append("0111")
            elif n == "8":
                lis.append("1000")
            elif n == "9":
                lis.append("1001")
            elif n == "A":
                lis.append("1010")
            elif n == "B":
                lis.append("1011")
            elif n == "C":
                lis.append("1100")
            elif n == "D":
                lis.append("1101")
            elif n == "E":
                lis.append("1110")
            elif n == "F":
                lis.append("1111")
print(lis)
"""

#D - BIEN

"""
ent = int(input())
lista = []
lista2 = []
operacion = ""
for i in range(ent):
    cadena = input()
    a = cadena.split(" ")
    lista.append(a)

for i in range(len(lista)):
    if (int(lista[i][0]) * int(lista[i][1]) + int(lista[i][2]) - int(lista[i][3])) == int(lista[i][4]):
        operacion = "("+ str(lista[i][0])+ "*" + str(lista[i][1]) + ")+"+str(lista[i][2])+"-"+str(lista[i][3])+"="+str(lista[i][4])
    elif (int(lista[i][0]) * int(lista[i][1]) - int(lista[i][2]) + int(lista[i][3])) == int(lista[i][4]):
        operacion = "("+ str(lista[i][0])+ "*" + str(lista[i][1]) + ")-"+str(lista[i][2])+"+"+str(lista[i][3])+"="+str(lista[i][4])
    elif (int(lista[i][0]) - int(lista[i][1]) * int(lista[i][2]) + int(lista[i][3]))  == int(lista[i][4]):
        operacion =  str(lista[i][0])+ "-(" + str(lista[i][1]) + "*"+str(lista[i][2])+")+"+str(lista[i][3])+"="+str(lista[i][4])
    elif (int(lista[i][0]) + int(lista[i][1]) * int(lista[i][2]) - int(lista[i][3])) == int(lista[i][4]):
        operacion =  str(lista[i][0])+ "+(" + str(lista[i][1]) + "*"+str(lista[i][2])+")-"+str(lista[i][3])+"="+str(lista[i][4])
    elif (int(lista[i][0]) + int(lista[i][1]) - int(lista[i][2]) * int(lista[i][3])) == int(lista[i][4]):
        operacion = str(lista[i][0])+ "+" + str(lista[i][1]) + "-("+str(lista[i][2])+"*"+str(lista[i][3])+")="+str(lista[i][4])
    elif (int(lista[i][0]) - int(lista[i][1]) + int(lista[i][2]) * int(lista[i][3]))  == int(lista[i][4]):
        operacion = str(lista[i][0])+ "-" + str(lista[i][1]) + "+("+str(lista[i][2])+"*"+str(lista[i][3])+")="+str(lista[i][4])
    lista2.append(operacion)

for i in range(len(lista2)):
    print(lista2[i])
"""



#E - BIEN
"""
n_casos = int(input())

for x in range(n_casos):
    oracion = input().upper()

    a = 0
    e = 0 
    i = 0
    o = 0
    u = 0

    y = sorted(str(oracion))
    for z in range(len(oracion)):
        if(oracion[z] == "A"):
            a += 1
        elif(oracion[z] == "E"):
            e += 1
        elif(oracion[z] == "I"):
            i += 1
        elif(oracion[z] == "O"):
            o += 1
        elif(oracion[z] == "U"):
            u += 1
    print(str(a) + " " + str(e) + " " + str(i) + " " + str(o) + " " + str(u))
"""

#F - BIEN
"""
n_casos = int(input())
for x in range(n_casos):
    m_n = input()
    sec_lo = m_n.split(" ")
    secuencias = int(sec_lo[0])
    longitud = int(sec_lo[-1])
    cad = []
    cadf = []
    cadfinal = ""
    for y in range(secuencias):
        cad.append(input())
    for a in range(longitud):
        l = []
        for b in range(secuencias):
            l.append(cad[b][a])
        A = l.count("A")
        C = l.count("C")
        G = l.count("G")
        T = l.count("T")
        if A >= C and A >= G and A >= T:
            cadf.append("A")
        if C > A and C >= G and C >= T:
            cadf.append("C")
        if G > A and G > C and G >= T:
            cadf.append("G")
        if T > A and T > G and T > C:
            cadf.append("T")
    for Z in range(len(cadf)):
        cadfinal = cadfinal + cadf[Z]
    print(cadfinal)
"""


#G - BIEN
"""
pwd = []
scd = []
con = False
while not con:
    entrada = input()
    if entrada == "end":
        con = True
        break
    pwd.append(entrada)

for i in range(len(pwd)):
    if pwd.count(pwd[i]) > 1 and scd.count(pwd[i])== 0:
        scd.append(pwd[i])
for i in range(len(scd)):
    print(scd[i])
"""

""" MAL
pswrds = []

while True:
    entrada = input()

    if(entrada == "end"):

        for x in range((len(pswrds) - 1)):
            z = sorted(pswrds)

            if(z[x] == z[x+1] and z[x-1] != z[x]):
                print(z[x])
        break

    pswrds.append(entrada)
"""


#H - BIEN
"""
entrada = int(input())
cadenas = []

for i in range(entrada):
    str1 = ""
    for a in range(i+1):
        str1 += str(a+1)
    cadenas.append(str1)
    for a in range(len(cadenas[i])-1):
        cadenas[i] += str(len(cadenas)-(a+1))
for i in range(len(cadenas)):
    print(cadenas[i])
"""

""" MAL
alt = int(input())
z = 0

for x in range(alt):
    pir = []

    for y in range(x+1):
        pir.insert(0, y+1)
    pir.insert(0, pir[:0:-1])
    print(pir[0])
""" 
