#include <stdio.h>
#include <stdlib.h>
#include "PriorityQueue.c"
#include "PriorityQueue.h"



void printInt(Type pi) {                 //Imprimir
    int *num = (int *)pi;
    printf("%d ", *num);
}

int main() {
    PriorityQueue pq = priorityqueue_create(NULL, compareInt, 17);                  //Se crea el pq

    int arrnum[] = {35, 84, 17, 122, 59, 191, 76, 29, 103, 50, 162, 8, 95, 178, 44, 68};       //16 num
    int num = sizeof(arrnum) / sizeof(arrnum[0]);                                        //num de elementos

    printf("Elementos a insertar a la cola: ");
    for (int i = 0; i < num; ++i) {                                                 //imprimimos todos los elementos
        printInt(&arrnum[i]);
    }

    for (int i = 0; i < num; ++i) {                                                 ////Metemos todos los elementos
        priorityqueue_offer(pq, &arrnum[i]);
    }

    for (int i = 0; i < 6; i++) {            //extraemos unos elementos
        Type pp = priorityqueue_peek(pq);               //Elemento conmayor prioridad
        printf("\nPeek:   ");
        printInt(pp);
        printf("\n");
        Type ext = priorityqueue_poll(pq);
        printf("\nExtraido:   ");
        printInt(ext);
    }

    printf("\nNum no extraidos en la parte anterior: \n");       //Imprime los elementos restantes
    while (priorityqueue_size(pq) > 0) {
        Type x = priorityqueue_poll(pq);
        printInt(x);
        printf("\n");
    }

    priorityqueue_destroy(pq);

    return 0;
}
