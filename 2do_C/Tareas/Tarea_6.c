#include <stdio.h>
#include <string.h>
#include <math.h>


void Invertidor() {

    char palabra[] = "mundo";

    printf("\n\n----------Invertidor de palabras----------\n\n");
    
    int n = strlen(palabra);
    
    for (int i = n; i >= 0; i--){
        printf("%c", palabra[i]);
    }
}




void Num_mayor() {

    int n;
    int pos;

    printf("\n\n----------Número mayor----------\n\n");

        printf("Ingrese el número de elementos que desea escribir: ");
    scanf("%i",&n);
    
    int numeros[n];
    
    for (int i = 0; i < n; i++){
        printf("Número_%i: ", i+1);
        scanf("%i", &numeros[i]);
    }

    int num_mayor = numeros[0];
    
    for (int i = 1; i < n; i++){
        if(numeros[i] > num_mayor)
            num_mayor = numeros[i];
    }
    for (int i = 0; i < n; i++){
        if(num_mayor == numeros[i])
            pos = i;
    }

    printf("El número mayor es: %i en la posición: %i del arreglo",num_mayor, pos);
}




void Potencias() {

    int numeros[2];

    printf("\n\n----------Potencias----------\n\n");

    printf("Escribe el número base y después su potencia\n");
    printf("Base: ");
    scanf("%i",&numeros[0]);
    printf("Potencia: ");
    scanf("%i",&numeros[1]);
    
    int num = pow(numeros[0],numeros[1]);

    printf("Resultado: %i", num);

}


int main() {

    Invertidor();
    Num_mayor();
    Potencias();

    return 0;
}