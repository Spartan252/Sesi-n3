
#include <stdio.h>

//Ejercicio 1

  //variables
float celsius;
float fahrenheit;
float kelvin;

  //Procedimiento

int main() 
{
    printf("Temperatura en grados celcius: ");
    scanf("%f", &celsius);

    fahrenheit = ((float)celsius * 9/5) + 32;
    kelvin = (float)celsius + 273.15;

    printf("La temperatura %fC equivale a %fF, y a %fK", celsius, fahrenheit, kelvin);
}


//------------------------------------------------------------------------------------

/*
#include <stdio.h>

//Ejercicio 2

  //variables
int n_articulos;
float pre_unidad;
float pre_ant_impuestos;
float impuestos;
float pre_total;

  //Procedimiento

int main() 
{
    printf("Cantidad de artículos: ");
    scanf("%i", &n_articulos);

    printf("Precio por unidad: ");
    scanf("%f", &pre_unidad);

  pre_ant_impuestos = n_articulos * pre_unidad;
  impuestos = pre_ant_impuestos * 0.25;
    pre_total = pre_ant_impuestos + impuestos;

    printf("Precio total de la cuenta antes de impuestos: %f \n", pre_ant_impuestos);
    printf("Impuestos totales: %f \n", impuestos);
    printf("Precio total incluyendo impuestos %f \n", pre_total);
}
*/