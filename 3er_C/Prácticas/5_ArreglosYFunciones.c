#include <stdio.h>

/*
//Sintaxis para crear un arreglo en modo estático:
• Tipo Nombre[Tamaño];
• Tipo Nombre[] = { valor1, valor2, ... }
• Tipo Nombre[Tamaño] = { valor1, valor2, ... } // Llena con 0 lo sobrante

//Sintaxis para declarar un apuntador a un tipo:
• Tipo* Nombre;
• Tipo* Nombre = &variable;

//Sintaxis para crear un arreglo de apuntadores es:
• Tipo* Nombre[Tamaño];
• Tipo* Nombre[] = { &variable1, &variable2, ... }
• Tipo* Nombre[Tamaño] = { &variable1, &variable2, ... }
*/

void aumentarDatosAputados(int * arrP[], int N){
    int i;
    for(i = 0; i < N; i++)
        if(arrP[i] != 0)
            (*(arrP[i]))++;
}

void imprimirValores(int * arrP[], int N){
    int i;
    for(i = 0; i < N; i++)
        if(arrP[i] != 0)
            printf("%d\n", *(arrP[i]));
    printf("\n");
}

void aumentarDatosApuntados2(int ** arrP, int N)
{
    int i;
    for(i = 0; i < N; i++)
        if(arrP[i] != 0)
    arrP[i][0]++;
}






void saludar(){  // Imprime Hola
printf("Hola.\n");
}

void despedirse(){ // Imprime Adiós
printf("Adios.\n");
}

void imprimirDoble(int x){  // Imprime 2x
printf("%d\n", x * 2);
}

void imprimirTriple(int x){     // Imprime 3x
printf("%d\n", x * 3);
}

int sumar(int a, int b){ // Devuelve a + b
return a + b;
}

int restar(int a, int b){   // Devuelve a – b
return a - b;
}

void imprimirMUltiplo(int x, void (*funcion)(int)){
funcion(x);
}



int main(){
    //Arreglos
    int a = 1, b = 2;
    int* arrP[4] = {&a,&b};

    int c = 3;
    arrP[2] = &c;

    int *p = &b;


    imprimirValores(arrP, 4);

    aumentarDatosAputados(arrP, 4);

    imprimirValores(arrP, 4);

    aumentarDatosApuntados2(arrP, 4);

    imprimirValores(arrP, 4);

    //Funciones

    void (*funcion1)(void) = 0;
    funcion1 = saludar;
    funcion1();
    saludar();
    funcion1 = despedirse;
    funcion1();
    despedirse();


    void (*funcion2)(int) = 0;
    funcion2 = imprimirDoble;
    funcion2(5);
    funcion2 = imprimirTriple;
    funcion2(5);


    int (*funcion3)(int, int) = 0;
    funcion3 = sumar;
    printf("%d\n", funcion3(2, 3));
    funcion3 = restar;
    printf("%d\n", funcion3(2, 3));
    imprimirMUltiplo(10, imprimirDoble);
    imprimirMUltiplo(10, imprimirTriple);



    return 0;

}




