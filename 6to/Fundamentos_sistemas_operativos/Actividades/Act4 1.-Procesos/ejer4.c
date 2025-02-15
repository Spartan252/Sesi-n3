#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

/*
    4.- (Retador) Desarrolla un programa que al ejecutarse cree dos procesos hijos y cada uno de los hijos 
    creará 3 nuevos procesos hijos. De esta manera habrá un proceso padre, dos procesos hijos y seis procesos nieto. 
    Los hijos y los nietos deberán tener al final la instrucción sleep(20), 
    pero el padre después de ejecutar la instrucción sleep(5) deberá terminar a todos los hijos y nietos.
*/


int main() {
    pid_t hijos[2];
    pid_t nietos[6];
    int i, j;

    for (i = 0; i < 2; i++) {
        hijos[i] = fork();
        if (hijos[i] == 0) {
            for (j = 0; j < 3; j++) {
                nietos[i * 3 + j] = fork();
                if (nietos[i * 3 + j] == 0) {
                    sleep(20);
                    exit(0);
                }
            }
            sleep(20);
            exit(0);
        }
    }

    sleep(5);

    for (i = 0; i < 2; i++) {
        if (hijos[i] > 0) {
            kill(hijos[i], SIGKILL);
        }
        for (j = 0; j < 3; j++) {
            if (nietos[i * 3 + j] > 0) {
                kill(nietos[i * 3 + j], SIGKILL);
            }
        }
    }

    printf("Padre: Todos los hijos y nietos terminados\n");

    return 0;
}