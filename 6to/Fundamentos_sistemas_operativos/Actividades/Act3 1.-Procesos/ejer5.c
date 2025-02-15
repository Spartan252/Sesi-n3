#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main() {
    char command[256];

    while (1) {  
        printf("Introduce el comando (o 'exit' para salir): ");
        fgets(command, 256, stdin); 
        command[strcspn(command, "\n")] = 0;

        if (strcmp(command, "exit") == 0) {  // si es exit salir
            break;
        }

        if (fork() == 0) {  // proceso hijo
            execlp(command, command, (char *)NULL);  
            perror("execlp failed"); 
            exit(1);
        } else { // proceso padre
            wait(NULL); 
        }
    }

    return 0;
}