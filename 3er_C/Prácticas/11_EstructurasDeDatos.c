#include <stdio.h>
#include <stdlib.h>


typedef struct{
    float precio;
    int existencias;
    char nombre[31];
} producto;

int main(){

    int cantidad;
    printf("Escribe la cantidad de productos a ingresar: ");
    scanf("%d",&cantidad);
    producto * pp= (producto*) malloc(cantidad*sizeof(producto));
    
    for(int i = 0; i <cantidad; i++){
        printf("Nombre del producto: ");
        scanf("%s", &pp[i].nombre);
        printf("Precio: ");
        scanf("%f", &pp[i].precio);
        printf("Existencias: ");
        scanf("%d", &pp[i].existencias);
    
    }
    
    for(int i = 0; i <cantidad; i++){
    printf("%s\t%.2f\t%d\n", pp[i].nombre, pp[i].precio,pp[i].existencias);
    }
    free(pp);
    return 0;
}
