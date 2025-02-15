#include <stdio.h>
#include "Set.h"
#include "Set.c"


int compareInts(Type t1, Type t2) {
    int *i1 = (int*) t1;
    int *i2 = (int*) t2;
    return *i1 - *i2;
}

void printInt(Type t) {
    int *pI = (int *) t;
    printf("%d ", *pI);
}

int main(void) {
	Set s = set_create(compareInts, printInt, NULL);
    //12 nodos a incluir
	int n1=5;
	int n2=1;
	int n3=8;
	int n4=11;
	int n5=46;
	int n6=23;
	int n7=21;
	int n8=154;
	int n9=20;
	int n10=43;
	int n11=73;
	int n12=9;

    //Inserción de elementos
	printf("Inserción de elementos\n");

	//Raiz
	set_add(s, &n6);
	set_print(s);

	//Demás elementos
	set_add(s, &n5);
	set_print(s);

	set_add(s, &n7);
	set_print(s);

	set_add(s, &n4);
	set_print(s);

	set_add(s, &n8);
	set_print(s);

	set_add(s, &n3);
	set_print(s);

	set_add(s, &n9);
	set_print(s);

	set_add(s, &n2);
	set_print(s);

	set_add(s, &n10);
	set_print(s);

	set_add(s, &n1);
	set_print(s);

	set_add(s, &n11);
	set_print(s);

	set_add(s, &n12);
	set_print(s);

    //Eliminación de elementos
	printf("\n\nEliminación de elementos\n");

	//Raiz
	set_remove(s, &n6);
	set_print(s);
    
    //Otros elementos
    set_remove(s, &n11);
	set_print(s);

    set_remove(s, &n1);
	set_print(s);

    set_remove(s, &n9);
	set_print(s);

    set_remove(s, &n12);
	set_print(s);

    //Volvemos a añadir el n6
	set_add(s, &n6);
	set_print(s);

    set_add(s, &n6);    //Para ver que no se pone dos veces
	set_print(s);

	set_destroy(s);
    printf("\n\nSet destruido\n");

	return 0;
}
