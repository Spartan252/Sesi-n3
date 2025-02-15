#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/*  1.-Escribir un programa que cree un hijo. El hijo debe escribir: "Soy el hijo" diez veces.
    El padre debe escribir: "Soy el padre" diez veces. Ambos procesos deberán mostrar concurrentemente sus líneas en pantalla 
    y entre cada linea que escriban deben hacer una pausa de un segundo. 
    El padre debe esperar a que termine el hijo y mostrar el mensaje: "Mi proceso hijo ya ha terminado".
*/

int main() 
{
    int p = fork();
    if(p==0){
        for(int i=0;i<10;i++){
            printf("Soy el hijo\n");
            sleep(1);
        }
    }
    else {
        for(int i=0; i<10; i++){
            printf("Soy el padre\n");
            sleep(1);
        }
        wait(NULL);
        printf("Mi proceso hijo ya ha terminado\n");
    }
    return 0;
}
