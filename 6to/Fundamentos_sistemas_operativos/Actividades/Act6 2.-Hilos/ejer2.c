#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <math.h>
#include <sys/time.h>
#include <pthread.h>


#define ITERS 1000000000
#define NTHREADS 4

typedef struct{
    int thread_number;
    double x;
} Thread_Args;

void *func_log(void *arg){
    Thread_Args *args = (Thread_Args *) arg;
    int thread_number = args->thread_number;
    double x = args->x;


    double *result = malloc(sizeof(double)); 
    double  sum = 0.0;
    int start = thread_number * (ITERS / NTHREADS);
    int n = start + 1;
    int end = (thread_number + 1) * (ITERS / NTHREADS);



    for(;n<end;n++)
                sum = sum + pow(-1,n+1) * pow(x,n) / n;



    *result = sum;

    return result;
}


int main(){
    double x = 0.0;
    printf("Escribe el valor de n a usar: ");
    scanf("%lf",&x);
        long long start_ts;
        long long stop_ts;
        long long elapsed_time;
    struct timeval ts;

    pthread_t tid[NTHREADS];

    for(int i = 0; i <NTHREADS;i++){
        Thread_Args *args = (Thread_Args *) malloc(sizeof(Thread_Args));
        args->thread_number = i;
        args->x = x;
        pthread_create(&tid[i],NULL,func_log,args);
    }

    double *t_result;
    double sum = 0.0;
    int resultado;

    gettimeofday(&ts, NULL);
    start_ts = ts.tv_sec;

    for (int i = 0; i < NTHREADS; i++)
    {
        pthread_join(tid[i],(void **) &t_result);
        sum += *t_result;
    }

    gettimeofday(&ts, NULL);
        stop_ts = ts.tv_sec;
    elapsed_time = stop_ts - start_ts;
    printf("Resultado = %.4lf\n",sum);
        printf("------------------------------\n");
        printf("TIEMPO TOTAL, %lld segundos\n",elapsed_time);

    return 0;
}