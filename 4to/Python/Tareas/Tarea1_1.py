def isBalanced(expression):
    pila = []
    
    #Relaciones de partes de inicio y fin de cada uno
    mapping = {')':'(', '}':'{', ']':'['}

    for char in expression:
        if char in mapping: #fin
            top_element = pila.pop() if pila else '#'   #por si está vacía

            if mapping[char] != top_element:
                return False
        else:
            pila.append(char)
    return not pila

# Ej
print(isBalanced("({[]})"))  # True
print(isBalanced("({[])}"))  # False
print(isBalanced("({[]}"))   # False
print(isBalanced("({[]}))"))  # False
print(isBalanced("({[]})"))   # True
print(isBalanced("({[])}"))   # False
print(isBalanced("({[]}"))    # False
print(isBalanced("({[]})}"))  # False
print(isBalanced("("))        # False
print(isBalanced("{"))        # False
print(isBalanced("{}}"))      # False
print(isBalanced("{[()]}"))   # True
print(isBalanced("({}))"))    # False
print(isBalanced("{[]}"))     # True
print(isBalanced("(){[]}"))     # True
print(isBalanced("(){[()]}"))     # False
