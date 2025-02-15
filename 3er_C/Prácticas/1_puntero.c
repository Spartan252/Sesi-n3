#include <stdio.h>

int main(){

    //  puntero == &entero
    //  *puntero == n
    int entero = 6;
    int * puntero = &entero;
    printf("%d\n", entero);
    printf("%p\n", &entero);
    printf("%p\n", puntero);
    printf("%p\n", &puntero);
    printf("%d\n", *puntero);

    *puntero = 7;
    printf("\n%d\n", entero);
    printf("%p\n", &entero);
    printf("%p\n", puntero);
    printf("%p\n", &puntero);
    printf("%d\n", *puntero);

    int entero2 = 3;
    puntero = &entero2;
    printf("\n%d\n", entero2);
    printf("%p\n", &entero2);
    printf("%p\n", puntero);
    printf("%p\n", &puntero);
    printf("%d\n", *puntero);


    //
    //tamaño de apuntadores son iguales
    char * pc1;
    short * pc2;
    int * pc3;
    double * pc4;
    long double * pc5;
    printf("\n%d\n", sizeof(pc1));
    printf("%d\n", sizeof(pc2));
    printf("%d\n", sizeof(pc3));
    printf("%d\n", sizeof(pc4));
    printf("%d\n", sizeof(pc5));
    //sin declrarar variables
    printf("\n%d\n", sizeof(char *));
    printf("%d\n", sizeof(short *));
    printf("%d\n", sizeof(int *));
    printf("%d\n", sizeof(double *));
    printf("%d\n", sizeof(long double *));
    //direcciones de los apuntadores
    printf("%p\n", &pc1);
    printf("%p\n", &pc2);
    printf("%p\n", &pc3);
    printf("%p\n", &pc4);
    printf("%p\n", &pc5);

}