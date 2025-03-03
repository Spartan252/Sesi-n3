class Color:
    RED = 1
    BLACK = 2


class Node:
    def __init__(self, key, parent=None, color=Color.RED):
        self.key = key
        self.parent = parent
        self.left = None
        self.right = None
        self.color = color

    def is_red(self):
        return self.color == Color.RED

    def is_black(self):
        return self.color == Color.BLACK

class RBTree:
    def __init__(self):
        self.TNULL = Node(0)
        self.TNULL.color = Color.BLACK
        self.root = self.TNULL

    def left_rotate(self, node_x):
        node_y = node_x.right
        node_x.right = node_y.left

        if node_y.left != self.TNULL:
            node_y.left.parent = node_x

        node_y.parent = node_x.parent

        if node_x.parent == self.TNULL:
            self.root = node_y
        elif node_x == node_x.parent.left:
            node_x.parent.left = node_y
        else:
            node_x.parent.right = node_y

        node_y.left = node_x
        node_x.parent = node_y

    def right_rotate(self, node_x):
        node_y = node_x.left
        node_x.left = node_y.right

        if node_y.right != self.TNULL:
            node_y.right.parent = node_x

        node_y.parent = node_x.parent

        if node_x.parent == self.TNULL:
            self.root = node_y
        elif node_x == node_x.parent.right:
            node_x.parent.right = node_y
        else:
            node_x.parent.left = node_y

        node_y.right = node_x
        node_x.parent = node_y

    def rb_insert_fixup(self, node_z):
        while node_z.parent and node_z.parent.is_red():
            if node_z.parent == node_z.parent.parent.left:
                node_y = node_z.parent.parent.right

                if node_y and node_y.is_black():
                    if node_z == node_z.parent.right:
                        node_z = node_z.parent
                        self.left_rotate(node_z)

                    if node_z.parent:
                        node_z.parent.color = Color.BLACK
                    if node_z.parent.parent:
                        node_z.parent.parent.color = Color.RED
                    self.right_rotate(node_z.parent.parent)
                elif node_y:
                    node_z.parent.color = Color.BLACK
                    node_y.color = Color.BLACK
                    if node_z.parent.parent:
                        node_z.parent.parent.color = Color.RED
                    node_z = node_z.parent.parent
            else:
                node_y = node_z.parent.parent.left

                if node_y and node_y.is_black():
                    if node_z == node_z.parent.left:
                        node_z = node_z.parent
                        self.right_rotate(node_z)

                    if node_z.parent:
                        node_z.parent.color = Color.BLACK
                    if node_z.parent.parent:
                        node_z.parent.parent.color = Color.RED
                    self.left_rotate(node_z.parent.parent)
                elif node_y:
                    node_z.parent.color = Color.BLACK
                    node_y.color = Color.BLACK
                    if node_z.parent.parent:
                        node_z.parent.parent.color = Color.RED
                    node_z = node_z.parent.parent

        self.root.color = Color.BLACK


    def rb_transplant(self, u, v):
        if u.parent == self.TNULL:
            self.root = v
        elif u == u.parent.left:
            u.parent.left = v
        else:
            u.parent.right = v
        v.parent = u.parent

    def rb_delete_fixup(self, x):
        while x != self.root and x.is_black():
            if x == x.parent.left:
                w = x.parent.right
                if w.is_red():
                    w.color = Color.BLACK
                    x.parent.color = Color.RED
                    self.left_rotate(x.parent)
                    w = x.parent.right

                if w.left.is_black() and w.right.is_black():
                    w.color = Color.RED
                    x = x.parent
                else:
                    if w.right.is_black():
                        w.left.color = Color.BLACK
                        w.color = Color.RED
                        self.right_rotate(w)
                        w = x.parent.right

                    w.color = x.parent.color
                    x.parent.color = Color.BLACK
                    w.right.color = Color.BLACK
                    self.left_rotate(x.parent)
                    x = self.root
            else:
                w = x.parent.left
                if w.is_red():
                    w.color = Color.BLACK
                    x.parent.color = Color.RED
                    self.right_rotate(x.parent)
                    w = x.parent.left

                if w.right.is_black() and w.left.is_black():
                    w.color = Color.RED
                    x = x.parent
                else:
                    if w.left.is_black():
                        w.right.color = Color.BLACK
                        w.color = Color.RED
                        self.left_rotate(w)
                        w = x.parent.left

                    w.color = x.parent.color
                    x.parent.color = Color.BLACK
                    w.left.color = Color.BLACK
                    self.right_rotate(x.parent)
                    x = self.root
        x.color = Color.BLACK

    def rb_delete_node(self, z):
        y = z
        y_original_color = y.color
        if z.left == self.TNULL:
            x = z.right
            self.rb_transplant(z, z.right)
        elif z.right == self.TNULL:
            x = z.left
            self.rb_transplant(z, z.left)
        else:
            y = self.minimum(z.right)
            y_original_color = y.color
            x = y.right
            if y.parent == z:
                x.parent = y
            else:
                self.rb_transplant(y, y.right)
                y.right = z.right
                y.right.parent = y
            self.rb_transplant(z, y)
            y.left = z.left
            y.left.parent = y
            y.color = z.color
        if y_original_color == Color.BLACK:
            self.rb_delete_fixup(x)

    def minimum(self, node):
        while node.left != self.TNULL:
            node = node.left
        return node

    def insert(self, key):
        node_new = Node(key)
        node_pointer = self.root
        node_parent = None

        while node_pointer != self.TNULL:
            node_parent = node_pointer

            if node_new.key < node_pointer.key:
                node_pointer = node_pointer.left
            else:
                node_pointer = node_pointer.right

        node_new.parent = node_parent

        if node_parent == None:  # Update this condition
            self.root = node_new
        elif node_new.key < node_parent.key:
            node_parent.left = node_new
        else:
            node_parent.right = node_new

        node_new.left = self.TNULL
        node_new.right = self.TNULL
        node_new.color = Color.RED

        self.rb_insert_fixup(node_new)
        self.root.color = Color.BLACK

    def delete(self, key):
        node_to_delete = self.search(key)
        if node_to_delete != self.TNULL:
            self.rb_delete_node(node_to_delete)

    def search(self, key):
        current_node = self.root
        while current_node != self.TNULL and key != current_node.key:
            if key < current_node.key:
                current_node = current_node.left
            else:
                current_node = current_node.right
        return current_node

    def print_tree(self):
        self._print_tree_recursive(self.root, 0)

    def _print_tree_recursive(self, node, level):
        if node != self.TNULL:
            self._print_tree_recursive(node.right, level + 1)
            print("   " * level + str(node.key) + ("(R)" if node.color == Color.RED else "(B)"))
            self._print_tree_recursive(node.left, level + 1)


if __name__ == "__main__":
    rbt = RBTree()
    rbt.insert(30)
    rbt.insert(20)
    rbt.insert(40)
    rbt.insert(10)
    rbt.insert(25)
    rbt.insert(50)
    rbt.insert(15)
    rbt.insert(9)

    print("Initial Red-Black Tree:")
    rbt.print_tree()

    rbt.delete(20)
    rbt.delete(25)

    print("\nRed-Black Tree:")
    rbt.print_tree()
#-----------------------------
    rbt1 = RBTree()
    rbt1.insert(1)
    rbt1.insert(2)
    rbt1.insert(3)
    rbt1.insert(4)
    rbt1.insert(5)
    rbt1.insert(6)
    rbt1.insert(7)
    rbt1.insert(8)

    print("Initial Red-Black Tree:")
    rbt1.print_tree()

    rbt1.delete(4)
    rbt1.delete(7)

    print("\nRed-Black Tree:")
    rbt1.print_tree()
#-----------------------------
    rbt2 = RBTree()
    rbt2.insert(234)
    rbt2.insert(345)
    rbt2.insert(234)
    rbt2.insert(546)
    rbt2.insert(757)
    rbt2.insert(123)
    rbt2.insert(111)
    rbt2.insert(643)

    print("Initial Red-Black Tree:")
    rbt2.print_tree()

    rbt2.delete(234)
    rbt2.delete(111)

    print("\nRed-Black Tree:")
    rbt2.print_tree()


