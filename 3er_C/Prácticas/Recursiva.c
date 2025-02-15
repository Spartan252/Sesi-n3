#include <stdio.h>

// suma valores en arreglo
long sumaArreglo(int arr[], int size, int i) {
    if (i == size-1) {
        return arr[i];
    } else {
        return arr[i] + sumaArreglo(arr, size, i+1);
    }
}

// buscar elemento en arreglo
int buscarElemento(int arr[], int size, int elemento) {
    if (size <= 0) {
        printf("No hay elemento %d\n",elemento);
        return 0;
    } 
    else if (arr[size - 1] == elemento) {
    return 1;
    }
    else {
    return buscarElemento(arr, size - 1, elemento);
    }
}

// frecuencia de elemento en arreglo
int frecuenciaElemento(int arr[], int size, int elemento) {
    if (size <= 0) {
        return 0;
    } else if (arr[size - 1] == elemento) {
        return 1 + frecuenciaElemento(arr, size - 1, elemento);
    } else {
        return frecuenciaElemento(arr, size - 1, elemento);
    }
}

// encontrar valor mínimo en arreglo
int valorMinimo(int arr[], int size) {
    if (size == 1) {
        return arr[0];
    } else {
        int minRestante = valorMinimo(arr, size - 1);
        return (arr[size - 1] < minRestante) ? arr[size - 1] : minRestante;
    }
}

// Función auxiliar para verificar si una cadena es palíndroma
int esPalindromaAux(char arr[], int inicio, int fin) {
    if (inicio >= fin) {
        return 1;
    } else if (arr[inicio] != arr[fin]) {
        return 0;
    } else {
        return esPalindromaAux(arr, inicio + 1, fin - 1);
    }
}

// Función para determinar si una cadena es palíndroma
int esPalindroma(char arr[]) {
    int longitud = 0;
    while (arr[longitud] != '\0') {
        longitud++;
    }
    return esPalindromaAux(arr, 0, longitud - 1);
}

int main() {
    int arreglo[] = {3, 7, 2, 8, 5, 1, 2, 9, 2, 6, 3};
    int tamano = sizeof(arreglo) / sizeof(arreglo[0]);

    // Suma de valores del arreglo
    printf("Suma de los valores del arreglo: %d\n", sumaArreglo(arreglo, tamano, 0));

    // Búsqueda de un elemento en el arreglo
    int elementoABuscar = 2;
    printf("¿El elemento %d está en el arreglo? %s\n", elementoABuscar, buscarElemento(arreglo, tamano, elementoABuscar) ? "Sí" : "No");

    // Frecuencia de un elemento en el arreglo
    int elementoAFrecuencia = 2;
    printf("Frecuencia del elemento %d en el arreglo: %d\n", elementoAFrecuencia, frecuenciaElemento(arreglo, tamano, elementoAFrecuencia));

    // Valor mínimo en el arreglo
    printf("Valor mínimo en el arreglo: %d\n", valorMinimo(arreglo, tamano));

    // Verificar si una cadena es palíndroma
    char cadena[] = "anitalavalatina";
    printf("¿La cadena es palíndroma? %s\n", esPalindroma(cadena) ? "Sí" : "No");

    return 0;
}
