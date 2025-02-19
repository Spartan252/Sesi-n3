#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM_TER 6 //Numero de terminales

void start_getty() {            //Para iniciar procesos getty en la terminal xterm
    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        exit(1);

    } else if (pid == 0) {
        char pid_str[16];
        snprintf(pid_str, sizeof(pid_str), "%d", getpid()); //convierte el pid_str en una cadena de caracteres

        char *args[] = {"xterm", "-fn", "xft:Monospace:size=18", "-e", "./getty", pid_str, NULL};   // Se ejecuta xterm con getty y se le pasa el pid
        execvp("xterm", args);

        // If execvp() fails
        perror("execvp failed");
        exit(1);
    }
}

int main() {
    pid_t pids[NUM_TER];
    int i;

    // Se crean las 6 terminales
    for (i = 0; i < NUM_TER; i++) {
        start_getty();
    }

    return 0;
}