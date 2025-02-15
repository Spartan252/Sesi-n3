from tkinter import *
from tkinter.constants import * 



#---------------------------------------------------separa la entrada de {} ------------------------------------------------------------------

global answer
answer=[]
def CaS(answer):
    x = 0
    pal = (answer)
    arg = ""
    argum = []
    lar = int(len(pal))

    for x in range(lar):
        if(pal[x] == "{"):
            while (pal[x] != "}"):
                arg = str(arg) + pal[x]
                x = x+1
            #print(arg)
        else:
            x = x+1
    argum=arg.split("{")
    argum.pop(-1)
    #print("a"+str(argum))
    answer=pal
    arg="".join(answer)
    print(answer)
    return arg
#---------------------------------------------------separa la entrada en () ------------------------------------------------------------------

def SEntrada(answer):
    x = 0
    pal = CaS(answer)
    arg = ""
    lar = int(len(pal))

    for x in range(lar-1):
        if(pal[x] == "("):

            while (pal[x-1] != ")"):
                arg = str(arg) + pal[x]
                x = x+1
            arg = str(arg) +"<&>"
    else:
        x = x+1
        argum=arg.split("<&>")
    argum.pop(-1)
    print("b"+str(argum))
    answer=Ctabla(CaS(answer),argum)
    

def SEntrada2(answer):
    x = 0
    pal = CaS(answer)
    arg = ""
    lar = int(len(pal))

    for x in range(lar-1):
        if(pal[x] == "("):
            while (pal[x-1] != ")"):
                arg = str(arg) + pal[x]
                x = x+1
            arg = str(arg) +"<&>"
        arg = str(arg) + pal[x]
    else:
        x = x+1
        argum=arg.split("<&>")
    argum.pop(-1)
    print("b"+str(argum))
    answer=Ctabla(CaS(answer),argum)
    



#---------------------------------------------------crea la tabla ------------------------------------------------------------------
FV = [True, False]
def Ctabla(pal,argum):
    Entrada=pal

    renglon=[]
    TablaV=[]
    if (Entrada.count("p")>0):
        renglon.append("|  p  |")
    if (Entrada.count("q")>0):
        renglon.append("|  q  |")
    if (Entrada.count("R")>0):
        renglon.append("|  r  |")
    if (Entrada.count("not p")>0):
        renglon.append("| ~p  ")
    if (Entrada.count("not q")>0):
        renglon.append("| ~q  |")
    if (Entrada.count("not R")>0):
        renglon.append("| ~r  |")
    for x in argum:
        renglon.append(str("| "+x+" |"))
    renglon.append(str("| "+Entrada+"| "))
    print(renglon)
    TablaV.append(renglon)
    renglon=[]
    for R in FV:
        
        for p in FV:
            for q in FV:
                if (Entrada.count("p")>0):
                    renglon.append(p)
                if (Entrada.count("q")>0):
                    renglon.append(q)
                if (Entrada.count("R")>0):
                    renglon.append(R)
                if (Entrada.count("not p")>0):
                    renglon.append(not p)
                if (Entrada.count("not q")>0):
                    renglon.append(not q)
                if (Entrada.count("not R")>0):
                    renglon.append(not R)
                for x in argum:
                    renglon.append(eval(x))
                renglon.append(eval(Entrada))
                print(renglon)
                TablaV.append(renglon)
                renglon=[]
                #print(p, q, r,not p,not q,not r,"  evaluando ", eval(Entrada), sep = '\t')
    tabla(TablaV)
    print(TablaV)
    print()
    answer=[]
#---------------------------------------------------ayuda a dar forma a la ventana ------------------------------------------------------------------
def SEntradaI(answer2,answer3):
    x=True
    for R in FV:
        for p in FV:
            for q in FV:
                if eval(str(answer2))!=eval(str(answer3)):
                    x= False
    marcoIR=Label(Ventana)
    marcoIR.config( text=str(x),bd=20,bg="light grey",justify="right")
    marcoIR.place(x=320,y=430)

Ventana = Tk()

Ventana.title("Tabla V F")

label = Label(Ventana, text="           ",height=2,)
label.grid(column=1,row=1) 
label = Label(Ventana, text="           ")
label.grid(column=3,row=2) 
label = Label(Ventana, text="           ")
label.grid(column=2,row=3) 
label = Label(Ventana, text="           ")
label.grid(column=4,row=4)  
label = Label(Ventana, text="           ")
label.grid(column=7,row=2000)  

marcoI3=Label(Ventana)
marcoI3.config(text="☰" ,bd=20)
marcoI3.place(x=440,y=330)

#---------------------------------------------------imprime en tk la tabla ------------------------------------------------------------------
#print (TablaV)
def tabla(TablaV):
    print(TablaV)
    label = Label(Ventana,width=1000,height=14)
    label.place(x=150, y=100) 
    for y in range(len(TablaV)):
        for x in range(len(TablaV[y])):
            label = Label(Ventana, text=str(TablaV[y][x]),font=('Arial',15,'bold'))
            label.grid(column=x+7,row=y+10)
            print(len(TablaV))
#---------------------------------------------------funciones para los botones ------------------------------------------------------------------
def letrap(answer):
    answer.append("p ")
    input_text.set(CaS(answer))

def letraq(answer):
    answer.append("q ")
    input_text.set(CaS(answer))

def letrar(answer):
    answer.append("R ")
    input_text.set(CaS(answer))

def noo(answer):
    answer.append("not ")
    input_text.set(CaS(answer))

def y(answer):
    answer.append("and ")
    input_text.set(CaS(answer))

def o(answer):
    answer.append("or ")
    input_text.set(CaS(answer))

def abr(answer):
    answer.append("( ")
    input_text.set(CaS(answer))

def cier(answer):
    answer.append(") ")
    input_text.set(CaS(answer))

def flecha1(answer):
    answer.append("<= ")
    input_text.set(CaS(answer))

def flecha2(answer):
    answer.append("== ")
    input_text.set(CaS(answer))

def borrar(answer):
        answer.pop(-1)
        input_text.set(CaS(answer))

#--------------------------------------------botones para igualdad
def letrapI(answer):
    answer.append("p ")
    input_textI.set(CaS(answer))

def letraqI(answer):
    answer.append("q ")
    input_textI.set(CaS(answer))

def letrarI(answer):
    answer.append("R ")
    input_textI.set(CaS(answer))

def nooI(answer):
    answer.append("not ")
    input_textI.set(CaS(answer))

def yI(answer):
    answer.append("and ")
    input_textI.set(CaS(answer))

def oI(answer):
    answer.append("or ")
    input_textI.set(CaS(answer))

def abrI(answer):
    answer.append("( ")
    input_textI.set(CaS(answer))

def cierI(answer):
    answer.append(") ")
    input_textI.set(CaS(answer))

def flecha1I(answer):
    answer.append("<= ")
    input_textI.set(CaS(answer))

def flecha2I(answer):
    answer.append("== ")
    input_textI.set(CaS(answer))

def borrarI(answer):
    answer.pop(-1)
    input_textI.set(CaS(answer))

def letrapI2(answer2):
    answer2.append("p ")
    input_textI2.set(CaS(answer2))

def letraqI2(answer2):
    answer2.append("q ")
    input_textI2.set(CaS(answer2))

def letrarI2(answer2):
    answer2.append("R ")
    input_textI2.set(CaS(answer2))

def nooI2(answer2):
    answer2.append("not ")
    input_textI2.set(CaS(answer2))

def yI2(answer2):
    answer2.append("and ")
    input_textI2.set(CaS(answer2))

def oI2(answer2):
    answer2.append("or ")
    input_textI2.set(CaS(answer2))

def abrI2(answer2):
    answer2.append("( ")
    input_textI2.set(CaS(answer2))

def cierI2(answer2):
    answer2.append(") ")
    input_textI2.set(CaS(answer2))

def flecha1I2(answer2):
    answer2.append("<= ")
    input_textI2.set(CaS(answer2))

def flecha2I2(answer2):
    answer2.append("== ")
    input_textI2.set(CaS(answer2))

def borrarI2(answer2):
    answer2.pop(-1)
    input_textI2.set(CaS(answer2))


input_text=StringVar()
marco=Label(Ventana)

marco.config(width=100, textvariable=input_text,bd=20,bg="light grey",justify="right")


bp=Button(Ventana, text="p",width=1, command=lambda:letrap(answer))
bq=Button(Ventana, text="q",width=1, command=lambda:letraq(answer))
br=Button(Ventana, text="r",width=1, command=lambda:letrar(answer))
bno=Button(Ventana, text="~",width=1, command=lambda:noo(answer))
by=Button(Ventana, text="^",width=1, command=lambda:y(answer))
bo=Button(Ventana, text="v",width=1, command=lambda:o(answer))
b1=Button(Ventana, text="(",width=1, command=lambda:abr(answer))
b2=Button(Ventana, text=")",width=1, command=lambda:cier(answer))
bf1=Button(Ventana, text="⇒",width=1, command=lambda:flecha1(answer))
bf2=Button(Ventana, text="⇔",width=1, command=lambda:flecha2(answer))
bborrar=Button(Ventana, text="❌",width=5, command=lambda:borrar(answer))
bL=Button(Ventana, text="Calcular",width=10, command=lambda:SEntrada(answer))
#eval(answer)


input_textI=StringVar()
input_textI2=StringVar()

marco.place(x=20,y=30)

bq.place(x=20,y=100)#---------------------------------boton
bp.place(x=62,y=100)#---------------------------------boton
br.place(x=104,y=100)#---------------------------------boton
bno.place(x=20,y=127)#---------------------------------boton
by.place(x=62,y=127)#---------------------------------boton
bo.place(x=104,y=127)#---------------------------------boton
b1.place(x=62,y=154)#---------------------------------boton
b2.place(x=104,y=154)#---------------------------------boton
bf1.place(x=20,y=181)#---------------------------------boton
bf2.place(x=20,y=154)#---------------------------------boton
bborrar.place(x=66,y=181)#---------------------------------boton
bL.place(x=20,y=208)#---------------------------------boton


#---------------------------------------------------comprueba igualdades ------------------------------------------------------------------
global answer2
answer2=[]
bpI=Button(Ventana, text="p",width=1, command=lambda:letrapI(answer2))
bqI=Button(Ventana, text="q",width=1, command=lambda:letraqI(answer2))
brI=Button(Ventana, text="r",width=1, command=lambda:letrarI(answer2))
bnoI=Button(Ventana, text="~",width=1, command=lambda:nooI(answer2))
byI=Button(Ventana, text="^",width=1, command=lambda:yI(answer2))
boI=Button(Ventana, text="v",width=1, command=lambda:oI(answer2))
b1I=Button(Ventana, text="(",width=1, command=lambda:abrI(answer2))
b2I=Button(Ventana, text=")",width=1, command=lambda:cierI(answer2))
bf1I=Button(Ventana, text="⇒",width=1, command=lambda:flecha1I(answer2))
bf2I=Button(Ventana, text="⇔",width=1, command=lambda:flecha2I(answer2))
bborrarI=Button(Ventana, text="❌",width=5, command=lambda:borrarI(answer2))
bLI=Button(Ventana, text="Calcular",width=10,height=3, command=lambda:SEntradaI(answer2,answer3))
marcoI=Label(Ventana)
marcoI.config(width=40, textvariable=input_textI,bd=20,bg="light grey",justify="right")
marcoI.place(x=20,y=330)
bqI.place(x=20,y=400)#---------------------------------boton
bpI.place(x=62,y=400)#---------------------------------boton
brI.place(x=104,y=400)#---------------------------------boton
bnoI.place(x=20,y=427)#---------------------------------boton
byI.place(x=62,y=427)#---------------------------------boton
boI.place(x=104,y=427)#---------------------------------boton
b1I.place(x=62,y=454)#---------------------------------boton
b2I.place(x=104,y=454)#---------------------------------boton
bf1I.place(x=20,y=481)#---------------------------------boton
bf2I.place(x=20,y=454)#---------------------------------boton
bborrarI.place(x=66,y=481)#---------------------------------boton
bLI.place(x=180,y=428)#---------------------------------boton

global answer3
answer3=[]
bpI2=Button(Ventana, text="p",width=1, command=lambda:letrapI2(answer3))
bqI2=Button(Ventana, text="q",width=1, command=lambda:letraqI2(answer3))
brI2=Button(Ventana, text="r",width=1, command=lambda:letrarI2(answer3))
bnoI2=Button(Ventana, text="~",width=1, command=lambda:nooI2(answer3))
byI2=Button(Ventana, text="^",width=1, command=lambda:yI2(answer3))
boI2=Button(Ventana, text="v",width=1, command=lambda:oI2(answer3))
b1I2=Button(Ventana, text="(",width=1, command=lambda:abrI2(answer3))
b2I2=Button(Ventana, text=")",width=1, command=lambda:cierI2(answer3))
bf1I2=Button(Ventana, text="⇒",width=1, command=lambda:flecha1I2(answer3))
bf2I2=Button(Ventana, text="⇔",width=1, command=lambda:flecha2I2(answer3))
bborrarI2=Button(Ventana, text="❌",width=5, command=lambda:borrarI2(answer3))
marcoI2=Label(Ventana)
marcoI2.config(width=40, textvariable=input_textI2,bd=20,bg="light grey",justify="right")
marcoI2.place(x=520,y=330)

bqI2.place(x=520,y=400)#---------------------------------boton
bpI2.place(x=562,y=400)#---------------------------------boton
brI2.place(x=604,y=400)#---------------------------------boton
bnoI2.place(x=520,y=427)#---------------------------------boton
byI2.place(x=562,y=427)#---------------------------------boton
boI2.place(x=604,y=427)#---------------------------------boton
b1I2.place(x=562,y=454)#---------------------------------boton
b2I2.place(x=604,y=454)#---------------------------------boton
bf1I2.place(x=520,y=481)#---------------------------------boton
bf2I2.place(x=520,y=454)#---------------------------------boton
bborrarI2.place(x=566,y=481)#---------------------------------boton



#Table(Ventana)
Ventana.geometry("1010x700")
Ventana.mainloop()
