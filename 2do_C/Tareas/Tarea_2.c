#include <stdio.h>

//Ejercicio 1

/* 
int main(void) 
{
    unsigned short numeros[10];
    int x;
    int y;
    float suma = 0;
    float promedio;

    printf("Escribe 10 números para sacar su promedio: \n");

    for (x = 0; x < 10; x++)
    {
        printf("número_%i: ", x+1);
        scanf("%hu\n", &numeros[x]);
    }
    
    for (x = 0; x < 10; x++)
    {
        printf("%hu\n", numeros[x]);
    }

    for(y = 0; y < 10; y++)
    {
    suma = suma + numeros[y];
    }

    promedio = suma/10;
    printf("El promedio de los números es: %f",promedio);

    return 0;
}
*/


//Ejercicio 2

int main(void) 
{
    int x;
    int y;
    long factorial = 1;

    printf("Escribe un número menor o igual a 64 para obtener su factorial: ");
    scanf("%i", &x);

    for(y = 1; y < x+1; y++)
    {
        factorial = factorial * y;
    }

    printf("El factorial de %i es: %lu\n", x, factorial);

    printf("tamaño de long: %lu bytes",sizeof(factorial));
    return 0;
}
