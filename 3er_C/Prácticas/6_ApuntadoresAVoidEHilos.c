#include <stdio.h>
#include <pthread.h>
#include <time.h>

// Declaración de matrices A, B y C
int A[N][N];
int B[N][N];
int C[N][N];


typedef struct
{
int p, q;
}pair;


void * imprimir(void *arg)
{
char * msg = (char * ) arg;
int i, len = strlen(msg);
for (i = 0; i < len; i++)
printf(" %c", msg[i]);
return NULL;
}


void * multiMatrix(void * arg)
{
    pair * p = (pair *) arg;
    int i, j, k;
    for(i=p->p; i<p->q; i++)
        for(j=0; j<N; j++){
            C[i][j] = 0;
            for(k=0; k<N; k++)
                C[i][j] += A[i][k] * B[k][j];
        }
    return NULL;
}


int main()
{
pthread_t h1;
pthread_t h2;
char * arg1 = "hola";
char * arg2 = "mundo";
pthread_create(&h1, NULL, imprimir, (void *) arg1);
pthread_create(&h2, NULL, imprimir, (void *) arg2);
pthread_join(h1 , NULL);
pthread_join(h2 , NULL);
printf("\nFin\n");

//identificadores de los hilos
pthread_t h1, h2, h3;
//límites para repartir el trabajo
pair p1, p2, p3, p4;
//(cada uno empieza donde el otro terminó)
p1.p=0;
p1.q=1/4;
p2.p=1/4;
p2.q=2*2/4;
p3.p=2*2/4; //p2.q
p3.q=3*3/4; //p3.p + N/4
p4.p=3*3/4; //p3.q
p4.q=1; //4*N/4
//tomamos el tiempo de inicio
clock_t start = clock();
pthread_create(&h1, NULL, multiMatrix, (void *)&p1);
pthread_create(&h2, NULL, multiMatrix, (void *)&p2);
pthread_create(&h3, NULL, multiMatrix, (void *)&p3);
//el hilo principal también ejecuta la función para multiplicar
multiMatrix((void *)&p4);
//esperamos a los otros hilos
pthread_join(h1, NULL);
pthread_join(h2, NULL);
pthread_join(h3, NULL);
//tomamos el tiempo de terminación
clock_t stop = clock();
int ms = 1000 * (stop - start)/CLOCKS_PER_SEC;
printf("%d ms", ms);


return 0;

}