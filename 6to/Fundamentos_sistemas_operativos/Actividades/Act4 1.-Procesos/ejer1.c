#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>


/*
    1.- Desarrolla un programa donde un proceso padre crea un proceso hijo, al iniciar este proceso hijo, 
        deberá matar o terminar a su padre.
*/


int main() {
    pid_t pid = fork(); 

    if (pid < 0) {
        perror("Error al crear proceso hijo");
        return 1;
    }

    if (pid == 0) { 
        // hijo
        printf("Soy el hijo con PID %d, voy a matar a mi padre (PID %d)\n", getpid(), getppid());
        sleep(2); // ver si padre sigue vivo
        kill(getppid(), SIGKILL); 
        printf("He matado a mi padre\n");
        exit(0);
    } else { 
        // padre
        printf("Soy el padre con PID %d, mi hijo tiene PID %d\n", getpid(), pid);
        while (1) {
            sleep(1); 
        }
    }

    return 0;
}