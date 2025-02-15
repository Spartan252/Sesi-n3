#include <math.h>
#include <stdio.h>

void Convertidor() {

    float kilo;
    float milla;
    float euro;
    float dolar;

    printf("---------kilómetros a millas - euros a dólares-----------\n");
    printf("Escriba los kilómetros a convertir: ");
    scanf("%f", &kilo);

    milla = kilo * 0.621371;
    printf("%.2f kilómetros equivalen a %f millas \n", kilo, milla);

    printf("Escriba los euros a convertir: ");
    scanf("%f", &euro);

    dolar = euro * 1.08;
    printf("%.2f euros equivalen a %.2f dolares \n", euro, dolar);
}

void area_rectangulo() {

    float base;
    float altura;
    float area;

    printf("-----------------Área de un rectángulo-------------------\n");
    printf("Escriba la base del rectángulo: ");
    scanf("%f", &base);
    printf("Escriba la altura del rectángulo: ");
    scanf("%f", &altura);

    area = base * altura;

    printf("El área del rectángulo es %.2f \n", area);
    }

void relacion() {

    float A;
    float B;

    printf("-------------------Relación de números-------------------\n");
    printf("Escribe el primer número: ");
    scanf("%f", &A);
    printf("Escribe el segundo número: ");
    scanf("%f", &B);

    if (A > B) {
        printf("1\n");
    } else if (A < B) {
        printf("-1\n");
    } else if (A == B) {
        printf("0\n");
    }
}

void Calculadora_r() {

    float radio;
    float area;
    float perimetro;
    float pi = 3.14159265358979323846;

    printf("----------Área y perímetro de una circunferencia----------\n");
    printf("Escriba el radio de la circunferencia: ");
    scanf("%f", &radio);

    area = pi * pow(radio, 2);
    perimetro = (2 * pi) * radio;

    printf("El área es de %f y el perímetro es de %f \n", area, perimetro);
}

void Calculadora_t() {

    int opc;
    float seg;
    float min;
    float hora;
    int tiempo;

    printf("-----------------Convertir tiempos-----------------\n");
    printf("Escriba 1 o 2 dependiendo de lo que desea obtener:\n");
    printf("1 = La cantidad de segundos en un tiempo dado en horas, minutos y "
            "segundos \n");
    printf("2 = La cantidad de horas, minutos y segundos de un tiempo dado en "
            "segundos \n");
    printf("Operación a realizar: ");
    scanf("%i", &opc);

    if (opc == 1) {
        printf("Horas: ");
        scanf("%f", &hora);
        printf("Minutos: ");
        scanf("%f", &min);
        printf("Segundos: ");
        scanf("%f", &seg);

    tiempo = (hora * 3600) + (min * 60) + seg;
    printf("Hay %i segundos\n", tiempo);
    }

    else if (opc == 2) {
        printf("Cantidad de segundos: ");
        scanf("%f", &seg);

        hora = (int)seg / 3600;
        min = (int)seg / 60;

        printf("Horas: %.1f\n", hora);
        printf("Minutos: %.1f\n", min);
        printf("Segundos: %.1f\n", seg);
    }
}

void dibujar() {

    float base;
    float altura;
    int x;
    int y;

    printf("-----------------Dibujo rectángulo-----------------\n");

    printf("Base: ");
    scanf("%f", &base);

    printf("Altura: ");
    scanf("%f", &altura);
    printf("\n");

    for (y = 0; y < altura; y++) {

        for (x = 0; x < base; x++) {
            printf("*");
        }
        printf("\n");
    }
}

int main() {

    Convertidor();
    area_rectangulo();
    relacion();
    Calculadora_r();
    Calculadora_t();
    dibujar();

    return 0;
}