
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "FloodFill.c"


char matrix[ROWS][COLS] = {
        "222222220000000000000000000000",
        "200000022222200000000000000000",
        "200000000000220000000000000000",
        "200000000000022000000000000000",
        "200000000000002000000000000000",
        "200000000000002000000000000000",
        "220000000000022000000000000000",
        "022222000022220000000000000000",
        "000002222220000000000000000000",
        "000000000000000000000000000000",
        "000000000000000000000000000000",
        "000000000000000000000000000000",
        "000000000000000000000333333000",
        "000000000000000000033300003330",
        "000000000000000003330000000033",
        "000000000000000033000000000003",
        "000000000000000030000000000003",
        "000000000000000033000000000003",
        "000000000000000003333300000033",
        "000000000000000000000333333333",
    };

int main() {
        printf("\n\nn-------------------Pilas, Colas y Recursión-------------------\n");
    printf("Matriz:\n");
    for (int i = 0; i < ROWS; ++i) {
        for (int j = 0; j < COLS; ++j) {
            printf("%c ", matrix[i][j]);
        }
        printf("\n");
    }

    int numDeReemplazo;
    int x, y;
    printf("Ingrese el num de reemplazo: ");
    scanf(" %d", &numDeReemplazo);

    printf("Ingrese la coordenada x del pixel: ");
    scanf("%d", &y);

    printf("Ingrese la coordenada y del pixel: ");
    scanf("%d", &x);

    int choice;
    printf("\nElija el método de implementación que desea usar:\n");
    printf("1. recursiveFloodFill\n");
    printf("2. stackFloodFill\n");
    printf("3. queueFloodFill\n");
    printf("0. Salir\n");
    printf("Ingrese su elección: ");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            floodFillRecursive(matrix, x, y, matrix[x][y], numDeReemplazo);
            break;
        case 2:
            floodFillIterativeStack(matrix, x, y, matrix[x][y], numDeReemplazo);
            break;
        case 3:
            floodFillIterativeQueue(matrix, x, y, matrix[x][y], numDeReemplazo);
            break;
        case 0:
            break;
        default:
            printf("Opción no válida. Intente nuevamente.\n");
    }

    return 0;
}
