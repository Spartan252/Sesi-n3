
class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, node, key):
        if key < node.key:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        else:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)

    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, node, key):
        if node is None or node.key == key:
            return node
        if key < node.key:
            return self._search_recursive(node.left, key)
        return self._search_recursive(node.right, key)

    def maximum(self, node):
        if node is None:
            return None
        while node.right is not None:
            node = node.right
        return node

    def type_maximum(self):
        max_node = self.maximum(self.root)
        if max_node is not None:
            return max_node.key
        return None

    def minimum(self, node):
        if node is None:
            return None
        while node.left is not None:
            node = node.left
        return node

    def type_minimum(self):
        min_node = self.minimum(self.root)
        if min_node is not None:
            return min_node.key
        return None

    def predecessor(self, node):
        if node is None:
            return None
        if node.left is not None:
            return self.maximum(node.left)
        current = self.root
        predecessor = None
        while current is not None:
            if node.key < current.key:
                current = current.left
            elif node.key > current.key:
                predecessor = current
                current = current.right
            else:
                break
        return predecessor

    def type_predecessor(self, key):
        node = self.search(key)
        if node is not None:
            predecessor_node = self.predecessor(node)
            if predecessor_node is not None:
                return predecessor_node.key
        return None

    def successor(self, node):
        if node is None:
            return None
        if node.right is not None:
            return self.minimum(node.right)
        current = self.root
        successor = None
        while current is not None:
            if node.key < current.key:
                successor = current
                current = current.left
            elif node.key > current.key:
                current = current.right
            else:
                break
        return successor

    def type_successor(self, key):
        node = self.search(key)
        if node is not None:
            successor_node = self.successor(node)
            if successor_node is not None:
                return successor_node.key
        return None

    def remove(self, node, key):
        if node is None:
            return None
        if node.key < key:
            node.right = self.remove(node.right, key)
        elif node.key > key:
            node.left = self.remove(node.left, key)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            else:
                successor = self.minimum(node.right)
                node.key = successor.key
                node.right = self.remove(node.right, successor.key)
        return node

    def print_tree(self):
        self._print_inorder(self.root)

    def _print_inorder(self, node):
        if node:
            self._print_inorder(node.left)
            print(node.key, end=" ")
            self._print_inorder(node.right)

    def remove_key(self, key):
        node = self.search(key)
        if node is not None:
            self.root = self.remove(self.root, key)

# Definir la clase Node y la clase BinarySearchTree como se proporciona en el código

# Crear un árbol binario de búsqueda
bst = BinarySearchTree()

# Insertar algunos nodos
bst.insert(50)
bst.insert(30)
bst.insert(20)
bst.insert(40)
bst.insert(70)
bst.insert(60)
bst.insert(80)

# Probar la búsqueda de nodos
print(bst.search(40).key)  # Salida: 40
print(bst.search(90))       # Salida: None

# Encontrar el máximo y el mínimo
print(bst.type_maximum())  # Salida: 80
print(bst.type_minimum())  # Salida: 20

# Encontrar el predecesor y el sucesor
print(bst.type_predecessor(30))  # Salida: 20
print(bst.type_successor(30))    # Salida: 40

# Eliminar un nodo
bst.remove_key(30)

# Verificar si el nodo se eliminó correctamente
print(bst.search(30))  # Salida: None

print("Contenido del árbol en orden ascendente:")
bst.print_tree()