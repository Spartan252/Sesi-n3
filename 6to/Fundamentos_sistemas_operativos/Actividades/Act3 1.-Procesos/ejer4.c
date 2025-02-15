#include <stdio.h>
#include <stdlib.h>

int main() {
    char command[256];

    while (1) {  
        printf("Introduce el comando (o 'exit' para salir): ");
        fgets(command, 256, stdin); 
        command[strcspn(command, "\n")] = 0; 

        if (strcmp(command, "exit") == 0) {  // si es "exit", salir
            break;
        }

        system(command); 
    }

    return 0;
}