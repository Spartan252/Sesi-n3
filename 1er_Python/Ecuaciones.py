def gauss_jordan(A, b):
    n = len(A)
    for i in range(n):
        pivot = A[i][i]
        if pivot == 0:
            return None
        for j in range(i, n):
            A[i][j] /= pivot
        b[i] /= pivot

        for k in range(n):
            if k != i:
                factor = A[k][i]
                for j in range(i, n):
                    A[k][j] -= factor * A[i][j]
                b[k] -= factor * b[i]

    return b

A = [
    [2, -1, 1, 3],
    [-3, 2, 1, 5],
    [-2, 1, 2, 9],
    [-1, 1, 2, 4]
    ]

b = [8, -11, -3, 2]

solucion = gauss_jordan(A, b)

if solucion is None:
    print("El sistema no tiene solución única.")
else:
    print("Solución:")
    for i, x in enumerate(solucion):
        print(f"x{i+1} =", x)