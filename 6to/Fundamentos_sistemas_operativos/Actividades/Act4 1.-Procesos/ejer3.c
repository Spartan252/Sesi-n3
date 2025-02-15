#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

/*
    3.- Desarrolla un programa donde un proceso padre crea un hijo, el padre tendrá una duración de 1 segundo y 
    el hijo una duración de 20 segundos.

    Ejecuta el proceso padre en segundo plano y antes de que el padre termine observa qué procesos hay.

        $ ./ejer3 &
        $ ps -o pid,stat,comm --forest
*/


int main() {
    pid_t pid = fork();
    
    if (pid == 0) {
        printf("Soy el hijo con PID %d y mi padre tiene PID %d\n", getpid(), getppid());
        sleep(20);
        printf("El hijo (PID %d) ha terminado.\n", getpid());
    } 
    else {
        printf("Soy el padre con PID %d y mi hijo tiene PID %d\n", getpid(), pid);
        sleep(1);
        printf("El padre (PID %d) ha terminado.\n", getpid());
    }
    
    return 0;
}