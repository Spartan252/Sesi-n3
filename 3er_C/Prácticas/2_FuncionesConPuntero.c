#include <stdio.h>
#include <math.h>


// Implemente una función swap capaz de intercambiar 
// el valor entre dos números enteros de 32 bits a, b recibidos.
void swap(int * a, int * b){
    int dummy = *a;
    *a = *b;
    *b = dummy;
}

//Implementa una función length que devuelva el tamaño de una cadena de texto
// (arreglo de caracteres) usando sólo operadores con apuntadores.
int length(char * str){
    int i;
    for(i = 0; *str != '\0'; i++, str++);
    return i;
}

//Implemente una función toUnit que reciba un vector 2d V y lo haga unitario.
typedef struct {
    float x, y;
} Vec2;

void toUnit(Vec2 * pv){
    float m = sqrt(pv->x * pv->x + pv->y * pv->y);
    pv->x /= m;
    (*pv).y /= m;
}

int main(){
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int * p = arr; //p = &arr[0]

    for(int i = 0; i<10; i++, p++)
        printf("%p\t%d\n", p, *p);
        //printf("%p\t%d\n", p, p[0]);
    p = arr;

    for(int i = 0; i<10; i++)
        printf("%p\t%d\n", p + i, *(p + i));
        //printf("%p\t%d\n", p + i, p[i]);
    


    //ejercicios

    //swap
    int x = 0, y = 2;
    printf("%d\t%d\n", x, y);
    swap(&x, &y);
    printf("%d\t%d\n", x, y);
    
    //length
    char s[1000] = "Hola, Pepe Luis.";
    printf("%d\n", length(s));

    //toUnit
    Vec2 v = {3, 2};
    toUnit(&v);
    printf("%f\t%f\n", v.x, v.y);
    return 0;
}


