#include <stdio.h>
#include <stdlib.h>

int main(){

    int cantidadEstaturas;
    printf("Escribe la cantidad de estaturas a ingresar: ");
    scanf("%d", &cantidadEstaturas);
    float *estaturas = (float*)malloc(cantidadEstaturas * sizeof(float));

    for(int i = 0; i<cantidadEstaturas;i++)
        scanf("%f", estaturas + i);

    int cantidadExtra;
    printf("Escribe la cantidad extra de estaturas: ");
    scanf("%d", &cantidadExtra);

    float * tmpEstaturas = (float*)realloc(estaturas, (cantidadEstaturas + cantidadExtra));

    if(tmpEstaturas == NULL){
        printf("No se pudo reservar memoria\n");
        free(estaturas);
    }
    else{
        estaturas = tmpEstaturas;
        cantidadEstaturas += cantidadExtra;
    }

    for(int i = cantidadEstaturas - cantidadExtra; i<cantidadEstaturas;i++)
        scanf("%f", estaturas + i);

    int minEstatura = estaturas[0], maxEstatura = estaturas[0], sumEstaturas;

    for(int i = 0; i<cantidadEstaturas;i++){
        printf("Estatura_%d: %2.f\n",i+1, estaturas[i]);

        if(estaturas[i] < minEstatura)
            minEstatura = estaturas[i];

        if(estaturas[i] > maxEstatura)
            maxEstatura = estaturas[i];
        
        sumEstaturas += estaturas[i];
    }
    
    printf("\nminEstatura: %2.f\n", minEstatura);
    printf("maxEstatura: %2.f\n", maxEstatura);
    printf("promEstaturas: %2.f\n", sumEstaturas/cantidadEstaturas);
    
    

    free(estaturas);

    return 0;
}



