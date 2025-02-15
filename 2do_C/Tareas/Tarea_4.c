#include <stdio.h>


void promedio() {
    int x;
    unsigned short calif[4];
    float suma;
    float prom;
    char puntuación;

    printf("---------------------CALIFICACIONES----------------------\n");
    printf("Escribe las 4 calificaciones para recibir su promedio\n");

    for (x = 0; x <= 3; x++){
    printf("calif_%i: ", x+1);
    scanf("%hu", &calif[x]);
    }

    suma = calif[0]+calif[1]+calif[2]+calif[3];
    prom = suma/4;

    printf("El promedio es: %.1f \n",prom);

    if(prom >= 90)
        puntuación = 'A';
        else if(prom >= 80)
            puntuación = 'B';
        else if(prom >= 70)
            puntuación = 'C';
        else if(prom >= 60)
            puntuación = 'D';
        else
            puntuación = 'E';

    printf("Su puntiación es: %c \n", puntuación);
}


void calculadora() {
    int oper;
    int x;
    unsigned short num[2];
    float operación;

    printf("---------------------CALCULADORA----------------------\n");
    printf("Escoge el tipo de operación que deseas realizar escribiendo el número que la representa: \n");
    printf("1. Suma \n");
    printf("2. Resta \n");
    printf("3. Multiplicación \n");
    printf("4. División \n");
    printf("Operación a realizar: ");
    scanf("%i", &oper);

    for (x = 0; x <= 1; x++)
    {
    printf("número_%i: ", x+1);
    scanf("%hu", &num[x]);
    }

    if(oper == 1)
        operación = num[0] + num[1];
    else if(oper == 2)
        operación = num[0] - num[1];
    else if(oper == 3)
        operación = num[0] * num[1];
    else if(oper == 4)
        operación = (float)num[0] / num[1];

    printf("Resultado = %.1f \n",operación);
}


void cadena() {
    int cant;
    unsigned short num[10];
    int x;
    int y = 0;

    printf("---------------------CADENA----------------------\n");
    printf("Cantidad de números que desea guardar menor o igaul a 10: ");
    scanf("%i", &cant);

    for (x = 0; x < cant; x++){
        printf("número_%i: ", x+1);
        scanf("%hu", &num[x]);
    }

    for (x = 0; x < 10; x++){
        if (num[x] >= y) 
        y = num[x];
    }
    printf("Número mayor = %i \n", y);
    }


void pirámide() {
    int lin;
    int x;
    int y;

    printf("---------------------ÁRBOL----------------------\n");
    printf("Escribe cuantos renglones de * desea tener: ");
    scanf("%i", &lin);

    for (x = 0; x <= lin; x++){
        for(y = 0; y <= x - 1; y++){
            printf("*");
        }
    printf("\n");
    }
}


int main() {
    //promedio();
    //calculadora();
    cadena();
    //pirámide();
}