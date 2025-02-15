#include "FloodFill.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>



char buffer[ROWS* COLS + ROWS + 1];


// Estructura para la pila - nodo
struct Stack {
    int x;
    int y;
    struct Stack* next;
};

// Estructura para la cola - nodo
struct Queue {
    int x;
    int y;
    struct Queue* next;
};



// ****************************************************************

//Animación matriz
void display(char matrix[ROWS][COLS], char buffer[ROWS* COLS + ROWS + 1]) {
    int i, j, k = 0;
    for(i=0; i<ROWS; i++){
        for(j=0; j<COLS; j++)
            buffer[k++] = matrix[i][j];
        buffer[k++] = '\n';
    }
    buffer[k] = '\0';
    printf("%s", buffer);
}


void delay(int msLimit) {
    clock_t begin = clock();
    clock_t end, difference;
    do{
        end = clock();
        difference = (end - begin) * 1000 / CLOCKS_PER_SEC;
    }while(difference < msLimit);
}

// ****************************************************************

// Recursiva de Flood-fill
void floodFillRecursive(char matrix[ROWS][COLS], int x, int y, char colorOriginal, char colorReemplazo) {
    if (x < 0 || x >= ROWS || y < 0 || y >= COLS) {
        return; // Salir si estamos fuera de los límites de la matriz
    }

    if (matrix[x][y] != colorOriginal) {
        return; // Salir si el color no coincide con el colorOriginal
    }

    matrix[x][y] = colorReemplazo;
    delay(166);
    system("cls");
    display(matrix, buffer);

    // Llamadas recursivas a las posiciones adyacentes
    floodFillRecursive(matrix, x, y + 1, colorOriginal, colorReemplazo); // Al sur
    floodFillRecursive(matrix, x, y - 1, colorOriginal, colorReemplazo); // Al norte
    floodFillRecursive(matrix, x - 1, y, colorOriginal, colorReemplazo); // Al oeste
    floodFillRecursive(matrix, x + 1, y, colorOriginal, colorReemplazo); // Al este
}



// ****************************************************************

// Función para agregar elementos a la pila
struct Stack* pushToStack(struct Stack* stack, int x, int y) {
    struct Stack* temp = stack;
    stack = (struct Stack*)malloc(sizeof(struct Stack));
    stack->x = x;
    stack->y = y;
    stack->next = temp;
    return stack;
}

// Implementación iterativa del algoritmo de Flood-fill utilizando una pila
void floodFillIterativeStack(char matrix[ROWS][COLS], int startX, int startY, char colorOriginal, char colorReemplazo) {
    struct Stack* stack = NULL;
    stack = pushToStack(stack, startX, startY);

    printf("\nPila\n");

    while (stack != NULL) {
        int x = stack->x;
        int y = stack->y;
        struct Stack * auxStack = stack;
        stack = stack->next;
        free(auxStack);

        if (x < 0 || x >= ROWS || y < 0 || y >= COLS || matrix[x][y] != colorOriginal) {
            continue;
        }

        matrix[x][y] = colorReemplazo;
        delay(166);
        system("cls");
        display(matrix, buffer);

        // Agregar elementos a la pila usando la función
        stack = pushToStack(stack, x + 1, y);
        stack = pushToStack(stack, x - 1, y);
        stack = pushToStack(stack, x, y + 1);
        stack = pushToStack(stack, x, y - 1);
    }

}

// Función para liberar la memoria de la pila
void freeStack(struct Stack* stack) {
    while (stack != NULL) {
        struct Stack* temp = stack;
        stack = stack->next;
        free(temp);
    }
}


// ****************************************************************

void enqueue(struct Queue** queue, int x, int y) {
    struct Queue* newNode = (struct Queue*)malloc(sizeof(struct Queue));
    newNode->x = x;
    newNode->y = y;
    newNode->next = NULL;

    if (*queue == NULL) {
        *queue = newNode;
    } else {
        struct Queue* temp = *queue;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

struct Queue* dequeue(struct Queue* queue) {
    if (queue == NULL) {
        return NULL;
    }

    struct Queue* temp = queue;
    queue = queue->next;
    free(temp);
    return queue;
}



// Iterativa de Flood-fill utilizando una cola (BFS)
void floodFillIterativeQueue(char matrix[ROWS][COLS], int startX, int startY, char colorOriginal, char colorReemplazo) {
    struct Queue* queue = NULL;
    enqueue(&queue, startX, startY);

    printf("\nCola\n");

    while (queue != NULL) {
        int x = queue->x;
        int y = queue->y;
        queue = dequeue(queue);

        if (x < 0 || x >= ROWS || y < 0 || y >= COLS || matrix[x][y] != colorOriginal) {
            continue;
        }

        matrix[x][y] = colorReemplazo;
        delay(166);
        system("cls");
        display(matrix, buffer);

        // Agregar elementos a la cola
        enqueue(&queue, x, y + 1); // Al sur
        enqueue(&queue, x, y - 1); // Al norte
        enqueue(&queue, x - 1, y); // Al oeste
        enqueue(&queue, x + 1, y); // Al este
    }
}