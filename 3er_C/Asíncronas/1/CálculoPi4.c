#include <stdio.h>
#include <pthread.h>
#include <time.h>

typedef struct
{
long long int p, f;
double suma;
}thread_arg;



void * CalculoPI4(void *arg)
{
    thread_arg * pf = (thread_arg *) arg;
    double pi = 0.0;
    for (long long int i = pf->p; i < pf->f; i++) {
        if (i % 2 == 0) {
            pi += 1.0 / (2 * i + 1);
        } else {
            pi -= 1.0 / (2 * i + 1);
        }
    }
    pf->suma =+ pi*4;
    return NULL;
}


int main() {

    //4 Hilos
    printf("Cálculo de π con 4 hilos:\n\n");
    pthread_t h1, h2, h3, h4;
    thread_arg p1, p2, p3, p4;

    p1.p=0;
    p1.f=12500000000;
    p2.p=12500000000;
    p2.f=25000000000;
    p3.p=25000000000;
    p3.f=37500000000;
    p4.p=37500000000;
    p4.f=50000000000;

    clock_t start2 = clock();
    pthread_create(&h1, NULL, CalculoPI4, (void *)&p1);
    pthread_create(&h2, NULL, CalculoPI4, (void *)&p2);
    pthread_create(&h3, NULL, CalculoPI4, (void *)&p3);
    pthread_create(&h4, NULL, CalculoPI4, (void *)&p4);

    pthread_join(h1, NULL);
    pthread_join(h2, NULL);
    pthread_join(h3, NULL);
    pthread_join(h4, NULL);
    
    clock_t stop2 = clock();

    double pi = 0.0;
    pi = p1.suma + p2.suma + p3.suma + p4.suma;

    int ms2 = 1000 * (stop2 - start2)/CLOCKS_PER_SEC;

    printf("%.10f\n",pi);
    printf("%d ms", ms2);

return 0;
}