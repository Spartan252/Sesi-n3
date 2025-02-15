

def ins_sort(A, d, left):
    print("Delta: "+str(d))
    for p in range(left+d, len(A), d):
        pivot = A[p]
        i = p - d
        while (i >= left and A[i] > pivot):
            A[i + d] = A[i]
            i = i - d
        A[i + d] = pivot
    print(A)

def shell_sort(input):
    delta_max = 1
    while (delta_max*3+1 < len(input)):
        delta_max = delta_max * 3 + 1
    while (delta_max >= 1):
        for i in range(0, delta_max):
            ins_sort(input, delta_max, i)
        delta_max = int((delta_max - 1) / 3)
    return input

test = [18, 5, 3, 2, 9, 0]
print("Sorting array: "+ str(test))
shell_sort(test)
print("Result: "+str(test))
test = ['A','S','O','R','T','I','N','G','E','X','A','M','P','L','E']
print("\nSorting array: "+ str(test))
shell_sort(test)
print("Result: "+str(test))
