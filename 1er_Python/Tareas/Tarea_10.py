
#A - BIEN
"""
x1 = int(input()) 
y1 = int(input()) 

x2 = int(input()) 
y2 = int(input()) 

x3 = int(input()) 
y3 = int(input()) 

x4 = int(input()) 
y4 = int(input()) 

list_x = [] 
list_y = [] 

for a in range(x4+1): 
    list_x.append(0) 

for b in range(y4+1): 
    list_y.append(0) 

for c in range(len(list_x)): 
    if c >= x3: 
        list_x[c] += 1 

    if c >= x2: 
        list_x[c] += 1 

for d in range(len(list_y)): 
    if d >= y3: 
        list_y[d] += 1 

    if d >= y2: 
        list_y[d] += 1 

fx = list_x.count(2) 
fy = list_y.count(2) 

if x3 >= x2 and y2 >= y3: 
    fx += 2 
    fy += 2 

if fx != 0 or fy != 0: 
    print(True) 

else: 
    print(False)
"""

#B - BIEN
"""
num = 1
while not num == 0:
    num = int(input())
    if num == 0:
        break
    elif(num / 11 == num //11):
        print("SI")
    else:
        print("NO")
"""


#C - BIEN
"""
n_datos = int(input()) 
num = input() 

lis_num = num.split(" ") 
lis_num = [int(x) for x in lis_num] 

ord_num = list(lis_num) 
ord_num.sort() 

a = 0 
lis = []

for i in range(n_datos): 

    if lis_num[i] != ord_num[i]: 
        a += 1 
        lis.append(i+1) 

if lis_num == ord_num: 
    print("Ordenada") 

elif a > 2: 
    print("Desordenada") 

else: 
    print("Casi ordenada: intercambiar "+str(lis[0])+" y "+str(lis[1]))
"""

#D
"""
from collections import Counter 

n_entradas = input()

modelos = input()

carros = modelos.split(" ") 

car_comun = (Counter(carros).most_common()[-0][-0]) 
print(car_comun)
"""

#E



#F



#G



#H
