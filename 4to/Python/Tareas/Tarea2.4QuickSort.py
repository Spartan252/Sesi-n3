import random

def partition(A, left, right):
    pivot = A[right]
    i = left
    for j in range(left, right):
        if A[j] <= pivot:
            A[i], A[j] = A[j], A[i]
            i += 1
    A[i], A[right] = A[right], A[i]
    return i

def quick_sort(A, left, right):
    if left < right:
        index = partition(A, left, right)
        quick_sort(A, left, index-1)
        quick_sort(A, index+1, right)
    return A

def partition_qs(A, left, right, index):
    pivot = A[right]
    i = left
    for j in range(left, right):
        if A[j] <= pivot and j != index:
            A[i], A[j] = A[j], A[i]
            i += 1
    A[i], A[right] = A[right], A[i]

def select(arr, left, right, i):
    while True:
        if left == right:
            return arr[left]
        index = random.randint(left, right)
        partition_qs(arr, left, right, index)
        if i == index:
            return arr[i]
        elif i < index:
            right = index - 1
        else:
            left = index + 1

for i in range(1,20):
    print("\nTest #"+str(i))
    print("Original:")
    output = [random.randrange(0,10) for j in range(i*3)]
    print(output)
    expected = output.copy()
    expected.sort()
    quick_sort_test = quick_sort(output, 0, len(output)-1)
    print("Output quick_sort:")
    print(quick_sort_test)
    select_test = select(output, 0, len(output)-1, i)
    print("Output select: i = "+str(i))
    print(select_test)
    print("Expected:")
    print(expected)

    assert output == quick_sort_test, "Failed test"