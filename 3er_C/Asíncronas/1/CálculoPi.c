#include <stdio.h>
#include <pthread.h>
#include <time.h>
#define N_TERMS 50000000000 

double pi = 0.0; 

void *CalculoPI(void *arg) 
{
    for (long long i = 0; i < N_TERMS; i++) 
    {
        double term = 1.0 / (2 * i + 1);
        if (i % 2 == 0) 
        {
            pi += term;
        } 
        else 
        {
            pi -= term;
        }
    }
    pi *= 4.0;
    return NULL;
}

int main() 
{
    clock_t start = clock();
    pthread_t thread;
    pthread_create(&thread, NULL, CalculoPI, NULL);
    pthread_join(thread, NULL);
    printf("%.10f\n", pi);
    
    clock_t stop = clock();
    int ms = 1000 * (stop - start) / CLOCKS_PER_SEC;
    printf("%d ms\n", ms);

    return 0;
}