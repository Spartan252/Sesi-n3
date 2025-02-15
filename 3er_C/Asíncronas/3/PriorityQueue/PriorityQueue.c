
#include <stdlib.h>
#include <stdio.h>
#include "PriorityQueue.h"

struct strPriorityQueue {
    Type *heapArray;
    int size;
    int capacity;
    DestroyFunc destructor;
    CompareFunc comparator;
};

typedef struct strPriorityQueue * PriorityQueue;

//__________________________________________________
int parentIndex(int index) {
    return (index - 1) / 2;
}

int leftChildIndex(int index) {
    return (2 * index) + 1;
}

int rightChildIndex(int index) {
    return (2 * index) + 2;
}

Bool isValidIndex(PriorityQueue q, int index) {
    return index >= 0 && index < q->size;
}

//__________________________________________________
PriorityQueue priorityqueue_create(DestroyFunc dF, CompareFunc cF, int capacity) {
    PriorityQueue pq = (PriorityQueue)malloc(sizeof(struct strPriorityQueue));      //crea un ejemplar 
    if (pq == NULL) {
        return NULL;
    }
    pq->heapArray = (Type *)malloc(capacity * sizeof(Type));    //reserva memoria para un arreglo con una capacidad inicial de capacity elementos tipo Type
    if (pq->heapArray == NULL) {
        free(pq);
        return NULL;
    }
    pq->size = 0;               //0 como el tamaño de la cola 
    pq->capacity = capacity;    //capacity como su capacidad
    pq->destructor = dF;        //dF como destructor
    pq->comparator = cF;        //cF como comparador
    return pq;
}

void priorityqueue_destroy(PriorityQueue pq) {
    if (pq == NULL)
        return;

    if (pq->destructor != NULL) {                       //libera la memoria de cada elemento del arreglo 
        for (int i = 0; i < pq->size; ++i) {
            pq->destructor(&(pq->heapArray[i]));
        }
    }

    free(pq->heapArray);                //libera la memoria del arreglo 
    free(pq);                           //libera la memoria del contenedor
}

int priorityqueue_size(PriorityQueue pq) { 
    if (pq == NULL)
        return -1;
    return pq->size;                            //devuelve el tamaño de la cola de prioridad
}

int compareInt(Type type_1, Type type_2) {       //Comparar
    int *int_1 = (int *)type_1;
    int *int_2 = (int *)type_2;
    return (*int_1 - *int_2);
}

void priorityqueue_offer(PriorityQueue pq, Type x) {
    if (pq == NULL) 
        return;

    if (pq->size >= pq->capacity) {         //aumenta la capacidad el doblesi es necesario
        pq->capacity *= 2;
        pq->heapArray = realloc(pq->heapArray, pq->capacity * sizeof(Type));
        if (pq->heapArray == NULL) {
            return;
        }
    }

    //agrega un elemento a la cola de prioridad, según su posición de acuerdo con las reglas del montículo binario mínimo 
    int ult_pos = pq->size;
    pq->heapArray[ult_pos] = x; // Almacenar la dirección del nuevo elemento
    pq->size++;

    int y = 1;
    while(y == 1){
        //ultp_pos es mayor a 0 (no es raiz) y se compara el elemento con su padre, se intercambia posición dependiendo si el padre es mayor
        if (ult_pos > 0 && compareInt(pq->heapArray[parentIndex(ult_pos)],pq->heapArray[ult_pos]) > 0) {
            Type temp = pq->heapArray[parentIndex(ult_pos)];
            pq->heapArray[parentIndex(ult_pos)] = pq->heapArray[ult_pos];
            pq->heapArray[ult_pos] = temp;

            ult_pos = parentIndex(ult_pos);
        }
        else
            y=0;
    }
}

Type priorityqueue_peek(PriorityQueue pq) {
    if (pq == NULL || pq->size == 0){
        return NULL;
    }
    return pq->heapArray[0];                //devuelve el elemento con mayor prioridad 
}

Type priorityqueue_poll(PriorityQueue pq) {
    if (pq == NULL || pq->size == 0){
        return NULL;
    }

    Type emp = pq->heapArray[0];           //elemento con mayor prioridad 
    pq->heapArray[0] = pq->heapArray[pq->size - 1]; //último elemento se hace la raíz
    pq->size--;                             //Decrementa el tamaño en uno

    // ajustes necesarios para que se cumplan las reglas del montículo binario mínimo 
    int x = 0;
    while (TRUE) {
        int izq = leftChildIndex(x);
        int der = rightChildIndex(x);
        int min = x;

        if (izq < pq->size && pq->comparator(&(pq->heapArray[izq]), &(pq->heapArray[x])) < 0) {
            min = izq;
        }
        if (der < pq->size && pq->comparator(&(pq->heapArray[der]), &(pq->heapArray[min])) < 0) {
            min = der;
        }

        if (min != x) {
            Type y = pq->heapArray[min];
            pq->heapArray[min] = pq->heapArray[x];
            pq->heapArray[x] = y;

            x = min;
        } 
        else 
            break;
    }
    return emp;                 //devuelve elemento con mayor prioridad 
}  
