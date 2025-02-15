#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/*
    2.- Desarrolla un programa donde un proceso padre crea un hijo, el padre tendrá una duración de 20 segundos 
    y el hijo una duración de 1 segundo.

    Ejecuta el proceso padre en segundo plano y antes de que el padre termine observa qué procesos hay.

    $ ./ejer2 &
    $ ps -o pid,stat,comm --forest
*/

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Error al crear proceso hijo");
        return 1;
    }

    if (pid == 0) { 
        // hijo
        printf("Soy el hijo con PID %d y mi padre tiene PID %d\n", getpid(), getppid());
        sleep(1); // hijo dura 1 seg
        printf("El hijo (PID %d) ha terminado.\n", getpid());
        exit(0);
    } else { 
        // padre
        printf("Soy el padre con PID %d y mi hijo tiene PID %d\n", getpid(), pid);
        sleep(20); // padre dura 20 seg antes de terminar
        printf("El padre (PID %d) ha terminado.\n", getpid());
    }

    return 0;
}
