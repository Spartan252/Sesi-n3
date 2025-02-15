#include <stdio.h>
#include <stdlib.h>

void imprimirM(double ** m, int r, int c)
{
    for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
            printf("%f\t", m[i][j]);
        printf("\n");
    }
}

void llenarM(double ** m, int r, int c)
{
    int k = 1;
    for(int i = 0; i < r; i++)
    for(int j = 0; j < c; j++)
    m[i][j] = k++;
}

double ** transpuestaM(double ** m, int r, int c)
{
    double ** tM = (double **) malloc(c * sizeof(double *));
    for(int i = 0; i < c; i++)
    {
    tM[i] = (double *) malloc(r * sizeof(double));
    for(int j = 0; j < r; j++)
        tM[i][j] = m[j][i];
    }
    return tM;
}

void liberarM(double ** m, int r, int c)
{
    for(int i = 0; i < r; i++)
        free(m[i]);
    free(m);
}

int main()
{
    int r, c;
    printf("Escribe un entero positivo para la cantidad de renglones: ");
    scanf("%d", &r);
    printf("Escribe un entero positivo para la cantidad de columnas: ");
    scanf("%d", &c);
    double ** m = (double ** ) malloc(r * sizeof(double *));
    for(int i = 0; i < r; i++)
    //m[i] = (double *) malloc(c * sizeof(double));
    m[i] = (double *) calloc(c, sizeof(double));
    llenarM(m, r, c);
    imprimirM(m, r, c);
    double ** tM = transpuestaM(m, r, c);
    imprimirM(tM, c, r);
    liberarM(m, r, c);
    liberarM(tM, c, r);
    return 0;
}