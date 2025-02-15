#include <stdio.h>

int sumArray(int *arr, int n) 
{
    int suma = 0;
    for (int i = 0; i < n; i++) 
    {
        suma += arr[i];
    }
    return suma;
}

void printArray(int *arr, int n) 
{
    for (int i = 0; i < n; i++) 
    {
        printf("%d\n", arr[i]); 
    }
}

void printArrays(int *arr1, int n1, int *arr2, int n2) 
{
    printArray(arr1, n1);
    printArray(arr2, n2);
}

void readArray(int *arr, int *pN) 
{
    scanf("%d", pN); 
    while (*pN<0 ||*pN>10)
    {
        scanf("%d",pN); 
    }

    for (int i = 0; i < *pN; i++) 
    {
        scanf("%d", &arr[i]); 
    }
}

void sortArrays(int **pp1, int *pN1, int **pp2, int *pN2) 
{
    int suma1 = sumArray(*pp1, *pN1);
    int suma2= sumArray(*pp2, *pN2);
    if (suma2 > suma1) 
    {
       int *vuelta = *pp1;
       *pp1 = *pp2;
       *pp2 = vuelta;
       int vuelta1 = *pN1;
       *pN1 = *pN2;
       *pN2 = vuelta1;
    }
}

int main(void) 
{
    int arr1[10]; 
    int arr2[10]; 
    int *p1, *p2;
    int n1, n2; 
    p1 = arr1;
    p2 = arr2;
    readArray(p1, &n1); 
    readArray(p2, &n2); 
    sortArrays(&p1, &n1, &p2, &n2); 
    printArrays(p1, n1, p2, n2); 
    return 0;
}