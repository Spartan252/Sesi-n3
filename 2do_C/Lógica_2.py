from tkinter import *
from _tkinter import *
from random import *
from tkinter import ttk


# Diego Orozco Alvarado - Santiago Elí Jiménez Aguilar - Regina Plascencia Gómez #
C_Relacion=[]
def conjunto_a_Lista (lista_temporal):
    global C_Relacion
    #print(Organizador_lista.get())#para comprobar en consola el orden de inicio al organizar 
    Conjunto_listbox.delete(0,END)
    Conjunto_listbox.insert(0,"Conjunto: "+str(lista_temporal))
    Conjunto_Relacion_listbox.delete(0,END)
    C_Relacion=Producto_cartesiano(lista_temporal)
    Conjunto_Relacion_listbox.insert(0,"AxA: "+str(C_Relacion))

    
#--------------- Convertidor de strings a conjuntos ---------------------------
def String_a_Conjunto(answer):
    contenido=""
    bandera=0
    Conjunto=[]
    for i in answer:
        if i !="," or bandera==1:
            contenido+=i
        if i =="{":
            bandera=1
        if i =="}":
            bandera=0
        if i=="," and  bandera ==0:
            Conjunto.append(contenido)
            contenido=""
    Conjunto.append(contenido)
    contenido=""
    conjunto_a_Lista (Conjunto)


#-----------------------------------------------------------------


def agregar_random_al_conjunto ():
    lista_temporal=[]
    lista_temporal=sample(range(int(Entrada_elemMin_conjunto.get()),int(Entrada_elemMax_conjunto.get())), int(Entrada_lenMin_conjunto.get()))
    print("Conjunto_random: "+str(lista_temporal))
    conjunto_a_Lista(lista_temporal)

def Producto_cartesiano(lista_temporal):
    temporal={(elemento1, elemento2) for elemento1 in lista_temporal for elemento2 in lista_temporal}
    print("El producto cartesiano es: "+str(temporal))
    return temporal


def Mayor_que():
    Mayor = []
    temporal = 0
    for x in C_Relacion:
        for y in x:
            if y < temporal:
                Mayor.append(x)
            temporal = y
        temporal = 0
    print(Mayor)

def Menor():
    Menor = []
    temporal = 51
    for x in C_Relacion:
        for y in x:
            if y > temporal:
                Menor.append(x)
            temporal = y
        temporal = 51
    print(Menor)
    
def Igual():
    Igual = []
    temporal = 0
    for x in C_Relacion:
        for y in x:
            if y == temporal:
                Igual.append(x)
            temporal = y
        temporal = 0
    print(Igual)
    
def Divide_a():
    Div = []
    temporal = 0
    cont = 0
    for x in C_Relacion:
        for y in x:
            if temporal == 0:
                temporal = y
            if cont == 1:
                if (y // temporal) == (y / temporal):
                    Div.append(x)
                temporal = 0
                cont = 0
            cont =+ 1
        cont = 0
    print(Div)
    
def Suma_par():
    Par = []
    temporal = 0
    for x in C_Relacion:
        for y in x:
            temporal += y
        if temporal == ((temporal//2)*2):
            Par.append(x)
        temporal = 0
    print(Par)



def Seleccion_Accion():
    accion = Relacion.get()
    print("La selección fue:"+ str(accion))
    if accion=="Mayor que":
        Mayor_que()
    if accion=="Mayor":
        Mayor()
    if accion=="Igual":
        Igual()
    if accion=="Divide a":
        Divide_a()
    if accion=="Suma par":
        Suma_par()


VentanaPrincipal= Tk()
VentanaPrincipal.geometry("855x370")
VentanaPrincipal.title("Conjuntos")

#------- Conjunto Principal/del usuario ----------------------------------------------
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Conjunto: ",justify="right")
LabelGeneral.place(x=15,y=30)

#-------- Entrada de Conjuntos -------------------------------------------------------
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("{                                                                       } "),justify="right",font=('Arial',12,'bold'))
LabelGeneral.place(x=15, y=50)
Entrada_Conjuntos= Entry(font=('Arial',12,'bold'),width=30)
Entrada_Conjuntos.place(x=30, y=52) 

#----------------------- Ent.Conj. Boton Agregar-------------------------------------
boton_Agregar=Button(VentanaPrincipal, text="Modificar",command=lambda:String_a_Conjunto (Entrada_Conjuntos.get()),width=8, cursor="hand2",font=('Arial',9,'bold'), relief="raised",borderwidth=2)
boton_Agregar.place(x=325, y=51)


#------- Conjunto --------------------------------------------------------------
Validacion_Entrada_Numero = lambda text: text.isdecimal()

#------- Conjuntos Randomizados ------------------------------------------------------
marco=Label(VentanaPrincipal ,width=52,height=6,relief="sunken",borderwidth=2 )
marco.place(x=420,y=27) 

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("Generador "),justify="right",font=('Arial',10,'bold'))
LabelGeneral.place(x=425, y=32)



#------- Conj. Botones Random-------------------------------------------------
boton_probar=Button(VentanaPrincipal, text="Generar",width=13, cursor="hand2",font=('Arial',10), relief="raised",borderwidth=2,command=lambda:agregar_random_al_conjunto ())
boton_probar.place(x=660,y=65)#---------------------------------boton Randomizador de conjuntos

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Numeros validos: ",justify="right")
LabelGeneral.place(x=430,y=57)
Entrada_elemMin_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_elemMin_conjunto.insert(END, "0")
Entrada_elemMin_conjunto.place(x=565,y=57)
Entrada_elemMax_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_elemMax_conjunto.insert(END, "50")
Entrada_elemMax_conjunto.place(x=615,y=57)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Numero de elementos: ",justify="right")
LabelGeneral.place(x=430,y=87)
Entrada_lenMin_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_lenMin_conjunto.insert(END, "10")
Entrada_lenMin_conjunto.place(x=565,y=87)


LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Min.      Max.   ",justify="right")
LabelGeneral.place(x=565,y=35)


#----------------------- Conjunto-------------------------------------
 
scrollbarx_Conjunto_listbox= Scrollbar(VentanaPrincipal, orient=HORIZONTAL)
Conjunto_listbox= Listbox(VentanaPrincipal,width=60,height=1, xscrollcommand=scrollbarx_Conjunto_listbox.set)
Conjunto_listbox.place(x=25,y=80)
scrollbarx_Conjunto_listbox.config(command=Conjunto_listbox.xview)
scrollbarx_Conjunto_listbox.place(x=25,y=100, width=364)

scrollbarx_Conjunto_Relacion_listbox= Scrollbar(VentanaPrincipal, orient=HORIZONTAL)
Conjunto_Relacion_listbox= Listbox(VentanaPrincipal,width=127,height=1, xscrollcommand=scrollbarx_Conjunto_Relacion_listbox.set)
Conjunto_Relacion_listbox.place(x=25,y=130)
scrollbarx_Conjunto_Relacion_listbox.config(command=Conjunto_Relacion_listbox.xview)
scrollbarx_Conjunto_Relacion_listbox.place(x=25,y=150, width=765)

#---------------- Organizador de la Lista de Conjuntos-------------------------------
LabelGeneral=Label(VentanaPrincipal)

Relacion=StringVar()
Relacion.set(END)  
relacion_x=25
relacion_y=175
LabelGeneral.config(text="Relacion: ",justify="right")
LabelGeneral.place(x=relacion_x,y=relacion_y)
relacion_x+=75
Boton_Relacion= Radiobutton(VentanaPrincipal, text="Mayor que", variable=Relacion, value="Mayor que",command=Seleccion_Accion)
Boton_Relacion.place(x=relacion_x,y=relacion_y)#--boton opcion 1-> Último
relacion_x+=120
Boton_Relacion= Radiobutton(VentanaPrincipal, text="Mayor", variable=Relacion, value="Mayor",command=Seleccion_Accion)
Boton_Relacion.place(x=relacion_x,y=relacion_y)#--boton opcion 1-> Último
relacion_x+=100
Boton_Relacion2= Radiobutton(VentanaPrincipal, text="Igual", variable=Relacion, value="Igual",command=Seleccion_Accion)
Boton_Relacion2.place(x=relacion_x,y=relacion_y)#--boton Último-> 1 
relacion_x+=100
Boton_Relacion3= Radiobutton(VentanaPrincipal, text="Divide a", variable=Relacion, value="Divide a",command=Seleccion_Accion)
Boton_Relacion3.place(x=relacion_x,y=relacion_y)#--boton opcion 1-> Último
relacion_x+=100
Boton_Relacion4= Radiobutton(VentanaPrincipal, text="Suma par", variable=Relacion, value="Suma par",command=Seleccion_Accion)
Boton_Relacion4.place(x=relacion_x,y=relacion_y)#--boton Último-> 1 

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("Generador "),justify="right",font=('Arial',10,'bold'))
LabelGeneral.place(x=425, y=32)



#------- Conj. Propiedades de la relacion-------------------------------------------------
marco=Label(VentanaPrincipal ,width=52,height=6,relief="sunken",borderwidth=2 )
marco.place(x=25,y=215)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("Propiedades "),justify="right",font=('Arial',10,'bold'))
LabelGeneral.place(x=30, y=225)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Reflexiva: ",justify="right")
LabelGeneral.place(x=30,y=245)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Simétrica: ",justify="right")
LabelGeneral.place(x=30,y=265)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Transitiva: ",justify="right")
LabelGeneral.place(x=30,y=285)




VentanaPrincipal.mainloop()