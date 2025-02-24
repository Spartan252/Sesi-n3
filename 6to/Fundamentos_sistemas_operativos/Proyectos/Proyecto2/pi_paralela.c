#include <stdio.h>
#include <math.h>
#include <pthread.h>
#include <sys/time.h>

#define NUM_THREADS 4 //hilos

//variables globales
long n; //número de trapecios
double h; //incremento
double suma_global = 0.0; //acumulador para la suma
pthread_mutex_t mutex; //mutex

//función f(x) = sqrt(1-x**2)
double f(double x) {
    return sqrt(1 - x * x);
}

//función para cada hilo
void *calcular_parcial(void *arg) {
    int id = *(int *)arg;
    double suma_local = 0.0;

    //rango de trabajo de cada hilo
    long inicio = id * (n / NUM_THREADS);
    long fin = (id + 1) * (n / NUM_THREADS);

    //suma parcial
    for (long i = inicio; i < fin; i++) {
        double x = (i + 0.5) * h; //punto medio del intervalo
        suma_local += f(x);
    }

    //mutex
    pthread_mutex_lock(&mutex);
    suma_global += suma_local;
    pthread_mutex_unlock(&mutex);

    pthread_exit(NULL);
}

int main() {
    struct timeval inicio, fin;
    pthread_t hilos[NUM_THREADS];
    int id_hilos[NUM_THREADS];

    printf("Ingrese el número de trapecios: ");
    scanf("%ld", &n);

    h = 1.0 / n; //incremento

    gettimeofday(&inicio, NULL);

    pthread_mutex_init(&mutex, NULL); //inicia mutex

    //inicio hilos
    for (int i = 0; i < NUM_THREADS; i++) {
        id_hilos[i] = i;
        pthread_create(&hilos[i], NULL, calcular_parcial, (void *)&id_hilos[i]);
    }

    //fin hilos
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(hilos[i], NULL);
    }

    pthread_mutex_destroy(&mutex); //acaba mutex

    gettimeofday(&fin, NULL);

    double pi_aproximado = 4.0 * h * suma_global;  //calculo pi

    double tiempo = (fin.tv_sec - inicio.tv_sec) + (fin.tv_usec - inicio.tv_usec) / 1e6; //cálculo del tiempo

    printf("Aproximación de PI con %ld trapecios y %d hilos: %.10f\n", n, NUM_THREADS, pi_aproximado);
    printf("Tiempo de ejecución: %.6f segundos\n", tiempo);

    return 0;
}