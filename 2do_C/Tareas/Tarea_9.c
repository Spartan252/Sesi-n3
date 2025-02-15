#include <stdio.h>
#include <math.h>

void ejercicio(){

    typedef struct{
    int x;
    int y;
    }puntos;

    typedef puntos point_p;

    puntos p1;
    puntos p2;
    puntos p3;

    point_p *point_p1;
    point_p *point_p2;
    point_p *point_p3;
    
    int opcion;

    printf("\n----------Ejercicio----------\n");
    printf("\nPuntos en el plano \n");

    printf("\nOperaciones:\n");
    printf("\n1) Calcular la distancia entre dos puntos");
    printf("\n2) Dados 3 puntos que representan las vertices de un triángulo, calcular su área");
    printf("\n\nEscribe el número de la operación que desea realizar: ");
    scanf("%i",&opcion);

    if(opcion == 1){
    
        printf("\n--Distancia entre dos puntos--\n");

        printf("\nPunto 1\n");
        printf("x_1: ");
        scanf("%i",&p1.x);
        printf("y_1: ");
        scanf("%i",&p1.y);
        point_p1 = &p1;

        printf("\nPunto 2\n");
        printf("x_2: ");
        scanf("%i",&p2.x);
        printf("y_2: ");
        scanf("%i",&p2.y);
        point_p2 = &p2;

        float distancia = sqrt((pow(point_p2->x - point_p1->x,2))+(pow(point_p2->y - point_p1->y,2)));

        printf("\nDistancia = %.2f",distancia);
    }

    if(opcion == 2){

        printf("\n--Área de triángulo--\n");

        printf("\nPunto 1\n");
        printf("x_1: ");
        scanf("%i",&p1.x);
        printf("y_1: ");
        scanf("%i",&p1.y);
        point_p1 = &p1;

        printf("\nPunto 2\n");
        printf("x_2: ");
        scanf("%i",&p2.x);
        printf("y_2: ");
        scanf("%i",&p2.y);
        point_p2 = &p2;

        printf("\nPunto 3\n");
        printf("x_3: ");
        scanf("%i",&p3.x);
        printf("y_2: ");
        scanf("%i",&p3.y);
        point_p3 = &p3;

        float distancia_1 = sqrt((pow(point_p2->x - point_p1->x,2))+(pow(point_p2->y - point_p1->y,2)));

        float distancia_2 = sqrt((pow(point_p3->x - point_p2->x,2))+(pow(point_p3->y - point_p2->y,2)));

        float distancia_3 = sqrt((pow(point_p1->x - point_p3->x,2))+(pow(point_p1->y - point_p3->y,2)));

    float s = (distancia_1+distancia_2+distancia_3)/2;
    printf("\nÁrea del triángulo: %.2f\n", sqrt(s*(s-distancia_1)*(s-distancia_2)*(s-distancia_3)));
    }
}

int main(){
    ejercicio();
}