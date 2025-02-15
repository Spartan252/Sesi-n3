import random
import tkinter

def ListadoLectura(archivo:str):
    listaloc = []
    fichero = fichero = open(archivo,"r")
    bandera = False
    while not bandera:
        linea = fichero.readline()
        if not linea:
            bandera = True
            break
        listaloc.append(linea.strip("\n")) 
    return listaloc
listaFortuna = ListadoLectura("Fortuna.txt")
listaArcaComunal = ListadoLectura("Arca_Comunal.txt")
listaCalles = ListadoLectura("Propiedades.txt")


ventana = tkinter.Tk()
ventana.title("MonoPython")
ventana.geometry("500x500")
ventana.configure(background="black")
img_tablero = tkinter.PhotoImage(file = "mboard.png" )
label1 = tkinter.Label(ventana, image=img_tablero)
label1.pack()
#Botones
img_dado = tkinter.PhotoImage(file = "Doradados.png" )
botondados = tkinter.Button(ventana,text="DADOS",image=img_dado,command=Tirarlosdados)
botondados.pack()
botondados.place(x=300,y=300)

ventana.mainloop()