#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/*  3.- Desarrolla un programa que reciba como argumento desde la línea de comandos un valor de entrada n cuyo significado
    sera un número de procesos a crear, de manera que cuando ejecutes tu programa este será el proceso padre que creará 
    solamente n procesos hijos a un nivel, cada proceso hijo mostrará su número que será de 1 hasta n. El proceso padre
    deberá esperar a que  todos los hijos terminen para al finalizar mostrar en pantalla el mensaje "Fin". 
    
    Por ejemplo:
    $ ./programa 5
    Proceso hijo 1
    Proceso hijo 2
    Proceso hijo 3
    Proceso hijo 4
    Proceso hijo 5
    Fin
*/


int main(int argc, char *argv[]) 
{
    int n = atoi(argv[1]);
    
    for (int i = 1; i <= n; i++) {
        int p = fork();
        
        if (p == 0) {
            printf("Proceso hijo %d\n", i);
            exit(0);
        }
    }

    for (int i = 1; i <= n; i++) {
        wait(NULL);
    }
    
    printf("Fin\n");
    return 0;
}
