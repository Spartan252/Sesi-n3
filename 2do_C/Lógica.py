from tkinter import *
from _tkinter import *
from random import *
from tkinter import ttk
Lista_Conjuntos=[]
def conjunto_a_Lista ():
    #print(Organizador_lista.get())#para comprobar en consola el orden de inicio al organizar 
    ConjuntosLista.delete(0,END)
    for i in range(len(Lista_Conjuntos)):
        #print(Lista_Conjuntos[i]) # para saber en consola en valor agregado a la listbox (conjuntosLista) en tkinter
        ConjuntosLista.insert(Organizador_lista.get(), str(i+1)+": "+str(Lista_Conjuntos[i]))

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
    return Conjunto


#-----------------------------------------------------------------

def agregar_al_conjunto (conjunto):
    Lista_Conjuntos.append(String_a_Conjunto(conjunto))
    print("los conjuntos son: "+ str(Lista_Conjuntos))#para mostrar todos los conjuntos en consola
    conjunto_a_Lista()


def agregar_random_al_conjunto ():
    for i in range((int)(Entrada.get())):#conjuntos
        randoms=["0","1","2","3","4","5","6","7","8","9",'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
        subconjuntos_random=randint(int(Entrada_lenMin_conjunto.get()),int(Entrada_lenMax_conjunto.get()))
        bandera=1
        while bandera != 0:
            lista_temporal=[]
            for i in range(0,subconjuntos_random):#subconjuntos
                if i!=0:
                    lista_temporal.append(",")
                Len_random=randint(int(Entrada_elemMin_conjunto.get()),int(Entrada_elemMax_conjunto.get()))
                for i in range(0,Len_random):#largo
                    random=randint(0,len(randoms)-1)# cualquier caracter dentro de la lista "randoms"
                    #print(random,randoms[random])# muestra en consola el caracter elegido
                    lista_temporal.append(randoms[random])
            lista_temporal=String_a_Conjunto(lista_temporal)
            #print(lista_temporal)
            for i in lista_temporal:
                if lista_temporal.count(i) > 1:
                    print ("salio: '"+str(i)+"' El elemento ya exciste (reintentando)")
                    bandera=1
                else:
                    bandera=0
            if len(lista_temporal)< int(Entrada_lenMin_conjunto.get()):
                bandera=1
            print(lista_temporal)
        Lista_Conjuntos.append(lista_temporal)
            
    #print("los conjuntos son: "+str(Lista_Conjuntos))#para mostrar todos los conjuntos en consola
    conjunto_a_Lista()



def imprimir_Conjunto(accion,conjunto):
    Conjunto_por_accion.delete(0,END)
    Conjunto_por_accion.insert(1," "+str(accion)+str(conjunto)+" ")



def Intersección(A,B):
    conjunto_temporal=[]
    for a in Lista_Conjuntos[int(A)-1]:
        for b in Lista_Conjuntos[int(B)-1]:
            if a==b:
                conjunto_temporal.append(a)
    print("La intersección es: " + str(conjunto_temporal))
    imprimir_Conjunto("La intersección es: ",conjunto_temporal)
    return conjunto_temporal

def Unión(A,B):
    conjunto_temporal=[]
    for a in Lista_Conjuntos[int(A)-1]:
        conjunto_temporal.append(a)
    for b in Lista_Conjuntos[int(B)-1]:
        conjunto_temporal.append(b)
        for a in Lista_Conjuntos[int(A)-1]:
            if b == a:
                conjunto_temporal.remove(a)
    print("La unión es: " + str(conjunto_temporal))
    imprimir_Conjunto("La unión es: ",conjunto_temporal)
    return conjunto_temporal

def Diferencia(A,B):
    conjunto_temporal=[]
    for a in Lista_Conjuntos[int(A)-1]:
        conjunto_temporal.append(a)
        for b in Lista_Conjuntos[int(B)-1]:
            if b==a:
                conjunto_temporal.remove(a)
    print("La diferencia es: " + str(conjunto_temporal))
    imprimir_Conjunto("La diferencia es: ",conjunto_temporal)
    return conjunto_temporal

def Diferencia_simétrica(A,B):
    conjunto_temporal= []
    conjunto_union = Unión(A,B)
    conjunto_interseccion = Intersección(A,B)
    for a in conjunto_union:
        conjunto_temporal.append(a)
        for b in conjunto_interseccion:
            if b==a:
                conjunto_temporal.remove(a)
    print("La diferencia simétrica es: " + str(conjunto_temporal))
    imprimir_Conjunto("La diferencia simétrica es: ",conjunto_temporal)
    return conjunto_temporal


def Complemento(A):
    universo= []
    temporal= []
    for x in Lista_Conjuntos:
        universo.append(x)
    universo.remove(Lista_Conjuntos[int(A)-1])
    for i in range(len(universo)):
        for a in range(len(universo[i])):
            temporal.append(universo[i][a])
    print("El complemento es: " + str(temporal))
    imprimir_Conjunto("El complemento es: ",temporal)
    return temporal

def Producto_cartesiano(A,B):
    temporal={(elemento1, elemento2) for elemento1 in Lista_Conjuntos[int(A)-1] for elemento2 in Lista_Conjuntos[int(B)-1]}
    print("El producto cartesiano es: "+str(temporal))
    imprimir_Conjunto("El producto cartesiano es: ",temporal)
    return temporal


def Conjunto_potencia(A):
    resultado = [[]]
    for elemento in Lista_Conjuntos[int(A)-1]:
        temp = []
        for i in range(len(resultado)):
            temp += [resultado[i] + [elemento]]
        resultado += temp
    print("El conjunto potencia es: "+str(resultado))
    imprimir_Conjunto("El conjunto potencia es: ",resultado)
    return resultado

def Cardinalidad(A):
    temporal=len(Lista_Conjuntos[int(A)-1])
    print("La cardinalidad de A es: ",temporal)
    imprimir_Conjunto("La cardinalidad es: ",temporal)
    return temporal

def Contención(A, B):
    temporal="Verdadero"
    for elemento in Lista_Conjuntos[int(A)-1]:
        if elemento not in Lista_Conjuntos[int(B)-1]:
            temporal="Falso"
    print("La contención es: ",temporal)
    imprimir_Conjunto("La contención es: ",temporal)
    return temporal



def Seleccion_Accion(event):
    accion = Boton_Accion.get()
    print("La selección fue:"+ str(accion))
#["A∩B", "AuB", "A-B", "B-A", "A∆B", "A^c", "B^c", "AxB", "BxA", "AxA", "BxB","P(A)","P(B)","|A|","|B|","A⊆B","B⊆A"]
    if accion=="A∩B":
        Intersección(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="AuB":
        Unión(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="A-B":
        Diferencia(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="B-A":
        Diferencia(Entrada_Numero_Conjunto_B.get(),Entrada_Numero_Conjunto_A.get())
    if accion=="A∆B":
        Diferencia_simétrica(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="A^c":
        Complemento(Entrada_Numero_Conjunto_A.get())
    if accion=="B^c":
        Complemento(Entrada_Numero_Conjunto_B.get())
    if accion=="AxB":
        Producto_cartesiano(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="BxA":
        Producto_cartesiano(Entrada_Numero_Conjunto_B.get(),Entrada_Numero_Conjunto_A.get())
    if accion=="AxA":
        Producto_cartesiano(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_A.get())
    if accion=="BxB":
        Producto_cartesiano(Entrada_Numero_Conjunto_B.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="P(A)":
        Conjunto_potencia(Entrada_Numero_Conjunto_A.get())
    if accion=="P(B)":
        Conjunto_potencia(Entrada_Numero_Conjunto_B.get())
    if accion=="|A|":
        Cardinalidad(Entrada_Numero_Conjunto_A.get())
    if accion=="|B|":
        Cardinalidad(Entrada_Numero_Conjunto_B.get())
    if accion=="A⊆B":
        Contención(Entrada_Numero_Conjunto_A.get(),Entrada_Numero_Conjunto_B.get())
    if accion=="B⊆A":
        Contención(Entrada_Numero_Conjunto_B.get(),Entrada_Numero_Conjunto_A.get())
#---------------- Configuracion de la Ventana Principal -------------------------
VentanaPrincipal= Tk()
VentanaPrincipal.geometry("855x370")
VentanaPrincipal.title("Conjuntos")

#---------------------Pista para introducir el conjunto-------------------------------
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Ejemplo= 1,2,a,A,{b,c},2B --> solo se admite parentecis tipo llaves''{ }''", justify="right",font=('Arial',8,'italic'))
LabelGeneral.place(x=80,y=30)

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
boton_Agregar=Button(VentanaPrincipal, text="Agregar",command=lambda:agregar_al_conjunto (Entrada_Conjuntos.get()),width=8, cursor="hand2",font=('Arial',9,'bold'), relief="raised",borderwidth=2)
boton_Agregar.place(x=325, y=51)


#------- Conjuntos A B --------------------------------------------------------------
Validacion_Entrada_Numero = lambda text: text.isdecimal()
    # A
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="| Número del conjunto A | ",justify="right")
LabelGeneral.place(x=25,y=260)
Entrada_Numero_Conjunto_A= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=20)
Entrada_Numero_Conjunto_A.insert(END, "0")
Entrada_Numero_Conjunto_A.place(x=38,y=280)
    # B
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="| Número del conjunto B | ",justify="right")
LabelGeneral.place(x=265,y=260)
Entrada_Numero_Conjunto_B= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=20)
Entrada_Numero_Conjunto_B.insert(END, "0")
Entrada_Numero_Conjunto_B.place(x=278,y=280)

#------- Accion ------------------------------------------------------------------
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Acción ",justify="right")
LabelGeneral.place(x=200,y=260)
Boton_Accion=ttk.Combobox( state="readonly",
    values=["A∩B", "AuB", "A-B", "B-A", "A∆B", "A^c", "B^c", "AxB", "BxA", "AxA", "BxB","P(A)","P(B)","|A|","|B|","A⊆B","B⊆A"],width=4)
Boton_Accion.place(x=196,y=280)
Boton_Accion.bind("<<ComboboxSelected>>", Seleccion_Accion)



#------- Conjuntos Randomizados ------------------------------------------------------
marco=Label(VentanaPrincipal ,width=57,height=10,relief="sunken",borderwidth=2 )
marco.place(x=20,y=92)
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Número de conjuntos a randomizar: ",justify="right")
LabelGeneral.place(x=25,y=211)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("Generador "),justify="right",font=('Arial',10,'bold'))
LabelGeneral.place(x=25, y=97)

Entrada= Entry(validate="key",font=('Arial',11),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=5)
Entrada.insert(END, "0")
Entrada.place(x=245,y=211)

#------- Conj. Botones Random-------------------------------------------------
boton_probar=Button(VentanaPrincipal, text="Generar",width=13, cursor="hand2",font=('Arial',10), relief="raised",borderwidth=2,command=lambda:agregar_random_al_conjunto ())
boton_probar.place(x=300,y=211)#---------------------------------boton Randomizador de conjuntos

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Longitud del conjunto: ",justify="right")
LabelGeneral.place(x=45,y=162)
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="[a, b, c] = 3",justify="right",font=('Arial',11,'italic'))
LabelGeneral.place(x=315,y=162)
Entrada_lenMin_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_lenMin_conjunto.insert(END, "0")
Entrada_lenMin_conjunto.place(x=215,y=165)
Entrada_lenMax_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_lenMax_conjunto.insert(END, "5")
Entrada_lenMax_conjunto.place(x=265,y=165)

LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Caracteres por elemento: ",justify="right")
LabelGeneral.place(x=45,y=189)
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="[ac, bd, ca] = 2",justify="right",font=('Arial',11,'italic'))
LabelGeneral.place(x=315,y=189)
Entrada_elemMin_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_elemMin_conjunto.insert(END, "1")
Entrada_elemMin_conjunto.place(x=215,y=189)
Entrada_elemMax_conjunto= Entry(validate="key",font=('Arial',10),validatecommand=(VentanaPrincipal.register(Validacion_Entrada_Numero), "%S"),width=3)
Entrada_elemMax_conjunto.insert(END, "3")
Entrada_elemMax_conjunto.place(x=265,y=189)


LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Característica de los conjuntos a randomizar: ",justify="right")
LabelGeneral.place(x=25,y=125)
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text="Min.      Max.   ",justify="right")
LabelGeneral.place(x=215,y=145)



#----------------------- Conjunto de la accion-------------------------------------

scrollbarx_Conjunto_por_accion= Scrollbar(VentanaPrincipal, orient=HORIZONTAL)
Conjunto_por_accion= Listbox(VentanaPrincipal,width=44,height=1, xscrollcommand=scrollbarx_Conjunto_por_accion.set)
Conjunto_por_accion.place(x=25,y=310)
scrollbarx_Conjunto_por_accion.config(command=Conjunto_por_accion.xview)
scrollbarx_Conjunto_por_accion.place(x=25,y=330, width=270)

#---------------- Lista de Conjuntos/universo-------------------------------------------------
color_fondo_universo="Gray"
marco=Label(VentanaPrincipal ,width=48,height=21,relief="sunken",borderwidth=8 , bg=color_fondo_universo)#fondo
marco.place(x=483, y=20)
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=str("Universo "),justify="right",font=('Times New Roman',15,'bold'), bg=color_fondo_universo)
LabelGeneral.place(x=610, y=28)
scrollbarx_ConjuntosLista= Scrollbar(VentanaPrincipal, orient=HORIZONTAL)
scrollbary_ConjuntosLista= Scrollbar(VentanaPrincipal, orient=VERTICAL)
ConjuntosLista= Listbox(VentanaPrincipal,width=50,height=14 ,xscrollcommand=scrollbarx_ConjuntosLista.set,yscrollcommand=scrollbary_ConjuntosLista.set)
ConjuntosLista.place(x=500,y=75)
scrollbarx_ConjuntosLista.config(command=ConjuntosLista.xview)
scrollbarx_ConjuntosLista.place(x=500,y=303, width=304)#scrollbar para eje x
scrollbary_ConjuntosLista.config(command=ConjuntosLista.yview)
scrollbary_ConjuntosLista.place(x=804,y=75, height=228)#scrollbar para eje y

#---------------- Organizador de la Lista de Conjuntos-------------------------------
LabelGeneral=Label(VentanaPrincipal)
LabelGeneral.config(text=" Acomodo: ",justify="right", bg=color_fondo_universo)
LabelGeneral.place(x=520,y=52)

Organizador_lista=StringVar()
Organizador_lista.set(END)  
Boton_Organizador_lista= Radiobutton(VentanaPrincipal, text="1º a Último", variable=Organizador_lista, value=END,command=conjunto_a_Lista, bg=color_fondo_universo)
Boton_Organizador_lista.place(x=600,y=50)#--boton opcion 1-> Último
Boton_Organizador2_lista= Radiobutton(VentanaPrincipal, text="Último a 1º ", variable=Organizador_lista, value="0",command=conjunto_a_Lista, bg=color_fondo_universo)
Boton_Organizador2_lista.place(x=700,y=50)#--boton Último-> 1 




VentanaPrincipal.mainloop()