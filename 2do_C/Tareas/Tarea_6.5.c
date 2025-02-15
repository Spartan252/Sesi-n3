#include <stdio.h>
#include <math.h>


void Media_Mediana_Moda() {

    int n;

    printf("\n\n----------------Media-Mediana-Moda----------------\n\n");

    printf("Ingrese el número de elementos con el que desea trabajar: ");
    scanf("%i",&n);
    
    int numeros[n];
    int num_ord;

    //ORGANIZADOR DE ARREGLO
    for (int i = 0; i < n; i++){
        printf("Número_%i: ", i+1);
        scanf("%i", &numeros[i]);
    }

    for (int i = 0; i < n-1; i++) {
        
        for (int j = 0; j < n-i-1; j++) {
            
            if (numeros[j] > numeros[j+1]) {         
                num_ord = numeros[j];
                numeros[j] = numeros[j+1];
                numeros[j+1] = num_ord;
            }
        }
    }

    
    //MEDIA
    float suma;
    
    for (int i = 0; i < n; i++){
        suma = suma + numeros[i];
    }
    
    float media = suma/n;
    printf("\nLa media de los números es: %.2f \n",media);


  //MEDIANA
    if(n % 2 == 0){

        int div = (n/2);
        
        float mediana = ((float)numeros[div-1] + (float)numeros[div]) / 2;
        printf("\nLa mediana de los números es: %.2f \n",mediana);
    }
    
    else{
        int div = (n/2);
        float mediana = numeros[div];
        printf("\nLa mediana de los números es: %.2f \n",mediana);
    }

    
    //MODA
    int cuenta_max = 1;
    int moda;
    int contador;
    
    for(int i=0; i<n; i++) {
        contador = 0;
        for(int j=0; j<n; j++) {
        if(numeros[j] == numeros[i]) {
            contador++;
        }
        }
        
        if(contador > cuenta_max) {
        cuenta_max = contador;
        moda = numeros[i];
        }
    }
    
    if(moda == 0)
        printf("\nNo hay moda\n");
    else
        printf("\nLa moda de los números es: %i \n",moda);


  //DESVIACIÓN ESTANDAR DE LOS DATOS
    int distancia[n];
    int sumas = 0;
    int num;

    for(int i=0; i<n; i++) {
        num = pow((numeros[i] - media),2);
        distancia[i] = num;
    }
    for (int i = 0; i < n; i++){
        sumas = sumas + distancia[i];
    }
    float division = (float)sumas/(float)n;
    float raiz = pow(division, 0.5);

    printf("\nLa desviación estandar de los números es: %.2f \n",raiz);

    
    //VALOR MÁXIMO Y MÍNIMO
    printf("\nEl valor máximo es: %i \n",numeros[n-1]);
    printf("\nEl valor mínimo es: %i \n",numeros[0]);
}


int main() {

    Media_Mediana_Moda();

    return 0;
}