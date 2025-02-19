#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdbool.h>
#include <stdint.h>
#include <time.h>

#define SIZE 2000
#define NUM_THREADS 8

int matrix[SIZE][SIZE];

// Función para verificar si un número es primo
bool is_prime(int num) {
    if (num < 2) return false;
    if (num % 2 == 0 && num != 2) return false;
    for (int i = 3; i * i <= num; i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}

// Función que ejecutarán los hilos
void* process_matrix(void* arg) {
    long thread_id = (long)arg;  // Using long instead of intptr_t for simplicity
    int rows_per_thread = SIZE / NUM_THREADS;
    int start_row = thread_id * rows_per_thread;
    int end_row = (thread_id == NUM_THREADS - 1) ? SIZE : start_row + rows_per_thread;
    
    for (int i = start_row; i < end_row; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (!is_prime(matrix[i][j])) {
                matrix[i][j] = 0;
            }
        }
    }
    return NULL;
}

// Función para imprimir los números no ceros
void printnonzeroes() {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (matrix[i][j] != 0) {
                printf("%d ", matrix[i][j]);
            }
        }
    }
    printf("\n");
}

int main() {
    srand(time(NULL));
    
    // Llenado de la matriz con números aleatorios en el rango dado
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            matrix[i][j] = 900000000 + rand() % 100000000;
        }
    }
    
    pthread_t threads[NUM_THREADS];
    
    // Creación de los hilos
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_create(&threads[i], NULL, process_matrix, (void*)(long)i);
    }
    
    // Espera a que todos los hilos terminen
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threads[i], NULL);
    }
    
    printnonzeroes();
    return 0;
}