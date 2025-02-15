

def heapify(arr, n, i):
    # Find largest among root and children
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    if l < n and arr[l] > arr[largest]:
        largest = l

    if r < n and arr[r] > arr[largest]:
        largest = r

    # Swap and continue heapifying if root is not largest
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)


def buildMaxHeap(arr):
    n = len(arr)

    # Build max heap
    for i in range(n//2, -1, -1):
        heapify(arr, n, i)


def heapSort(arr):
    n = len(arr)

    buildMaxHeap(arr)
    # Heap sort
    for i in range(n-1, 0, -1):
        # Swap
        arr[i], arr[0] = arr[0], arr[i]

        # Heapify root element
        heapify(arr, i, 0)



C1 = [7,0,5,9,1]
C2 = [1,1,-20,17,12]
C3 = [7,9,8,23,119,44,-20,14]
C4 = [ ]
C5 = [1]
C6 = [9,9,9,9]
heapSort(C1)
heapSort(C2)
heapSort(C3)
heapSort(C4)
heapSort(C5)
heapSort(C6)

print("\nSorted array is")
for i in range(len(C1)):
    print("%d " % C1[i], end='')

print("\nSorted array is")
for i in range(len(C2)):
    print("%d " % C2[i], end='')

print("\nSorted array is")
for i in range(len(C3)):
    print("%d " % C3[i], end='')

print("\nSorted array is")
for i in range(len(C4)):
    print("%d " % C4[i], end='')

print("\nSorted array is")
for i in range(len(C5)):
    print("%d " % C5[i], end='')

print("\nSorted array is")
for i in range(len(C6)):
    print("%d " % C6[i], end='')