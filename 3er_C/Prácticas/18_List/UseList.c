#include <stdio.h>
#include <stdlib.h>
#include "List.c"

void print_list(List list) {
    Iterator it = list_begin(list);
    while (list_hasNext(it)) {
        Type data = list_data(it);
        printf("%d ", *(int*)data);  // Supongamos que estamos trabajando con enteros
        it = list_next(it);
    }
    printf("\n");
}

int main() {
    List myList = list_create(NULL);  // Utilizamos una función destructora para liberar memoria.

    int data1 = 10;
    int data2 = 20;
    int data3 = 30;

    list_add(myList, &data1);
    list_add(myList, &data2);
    list_add(myList, &data3);

    printf("Initial List: ");
    print_list(myList);

    // Modificar el segundo elemento
    int newData = 25;
    list_set(myList, &newData, 1);

    printf("List after modification: ");
    print_list(myList);

    // Eliminar el primer elemento
    list_remove(myList, 0);

    printf("List after removal: ");
    print_list(myList);

    // Acceder al elemento restante
    Type element = list_get(myList, 0);
    printf("Remaining element: %d\n", *(int*)element);

    list_destroy(myList);

    return 0;
}
