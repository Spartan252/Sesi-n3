class NodoAVL:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None
        self.altura = 1

class ArbolAVL:
    def __init__(self):
        self.raiz = None

    def altura(self, nodo):
        if nodo is None:
            return 0
        return nodo.altura

    def rotar_derecha(self, y):
        x = y.izquierda
        T2 = x.derecha

        x.derecha = y
        y.izquierda = T2

        y.altura = max(self.altura(y.izquierda), self.altura(y.derecha)) + 1
        x.altura = max(self.altura(x.izquierda), self.altura(x.derecha)) + 1

        return x

    def rotar_izquierda(self, x):
        y = x.derecha
        T2 = y.izquierda

        y.izquierda = x
        x.derecha = T2

        x.altura = max(self.altura(x.izquierda), self.altura(x.derecha)) + 1
        y.altura = max(self.altura(y.izquierda), self.altura(y.derecha)) + 1

        return y

    def obtener_balance(self, nodo):
        if nodo is None:
            return 0
        return self.altura(nodo.izquierda) - self.altura(nodo.derecha)

    def insertar(self, nodo, valor):
        if nodo is None:
            return NodoAVL(valor)
        elif valor < nodo.valor:
            nodo.izquierda = self.insertar(nodo.izquierda, valor)
        else:
            nodo.derecha = self.insertar(nodo.derecha, valor)

        nodo.altura = 1 + max(self.altura(nodo.izquierda), self.altura(nodo.derecha))

        balance = self.obtener_balance(nodo)

        if balance > 1:
            if valor < nodo.izquierda.valor:
                return self.rotar_derecha(nodo)
            else:
                nodo.izquierda = self.rotar_izquierda(nodo.izquierda)
                return self.rotar_derecha(nodo)

        if balance < -1:
            if valor > nodo.derecha.valor:
                return self.rotar_izquierda(nodo)
            else:
                nodo.derecha = self.rotar_derecha(nodo.derecha)
                return self.rotar_izquierda(nodo)

        return nodo

    def insertar_valor(self, valor):
        self.raiz = self.insertar(self.raiz, valor)

    def imprimir_preorden(self, nodo):
        if nodo:
            print("{0} ".format(nodo.valor), end="")
            self.imprimir_preorden(nodo.izquierda)
            self.imprimir_preorden(nodo.derecha)

arbol = ArbolAVL()

# Insertar valores de ejemplo
valores = [10, 20, 30, 40, 50, 25]
for valor in valores:
    arbol.insertar_valor(valor)

# Imprimir árbol en preorden
print("Árbol AVL en preorden:")
arbol.imprimir_preorden(arbol.raiz)
