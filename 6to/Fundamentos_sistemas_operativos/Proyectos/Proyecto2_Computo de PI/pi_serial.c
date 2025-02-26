#include <stdio.h>
#include <math.h>
#include <sys/time.h>

//función f(x) = sqrt(1-x**2)
double f(double x) {
    return sqrt(1 - x * x);
}

//regla del trapecio
double calcular_pi(long n) {
    double a = 0.0, b = 1.0; //intervalo 0 - 1
    double h = (b - a) / n;  //ancho de intervalo
    double suma = 0.5 * (f(a) + f(b)); //cálculo puntos extremos

    //calculo de valores intermedios
    for (long i = 1; i < n; i++) {
        double x = a + i * h;
        suma += f(x);
    }

    return 4.0 * h * suma; //obtenemos PI
}

int main() {
    long n;
    struct timeval inicio, fin;

    printf("Ingrese el número de trapecios: ");
    scanf("%ld", &n);

    gettimeofday(&inicio, NULL);
    double pi_aprox = calcular_pi(n);
    gettimeofday(&fin, NULL);

    double tiempo = (fin.tv_sec - inicio.tv_sec) + (fin.tv_usec - inicio.tv_usec) / 1e6; //cálculo del tiempo

    printf("Aproximación de PI con %ld trapecios: %.10f\n", n, pi_aprox);
    printf("Tiempo de ejecución: %.6f segundos\n", tiempo);

    return 0;
}