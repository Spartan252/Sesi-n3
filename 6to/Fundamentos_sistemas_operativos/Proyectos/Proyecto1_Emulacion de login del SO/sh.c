#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

#define MAX_LENGTH 256
#define MAX_ARGS 64


void execute_command(char *command, pid_t ppid) {  //Se ejecutan los comandos
    char *args[MAX_ARGS];
    int background = 0;
    int arg_count = 0;
    
    //Separa el comando en sus argumentos
    char *token = strtok(command, " \t\n");
    while(token && arg_count < MAX_ARGS - 1) {
        if(strcmp(token, "&") == 0) {       //Se debe de ejecutar de fondo por el amperson
            background = 1;
            break;
        }
        args[arg_count++] = token;
        token = strtok(NULL, " \t\n");
    }
    args[arg_count] = NULL;
    
    if(arg_count == 0) return;
    
    // -
    if(strcmp(args[0], "exit") == 0) {              //Se cierra sesión
        exit(0);
    } else if(strcmp(args[0], "shutdown") == 0) {   //Se manda señal para kill
        kill(ppid, SIGUSR1);
        exit(0);
    }
    
    //Ejecuta comandos externos
    pid_t pid = fork();
    if(pid < 0) {
        perror("Fork failed");
    } else if(pid == 0) {
        //Proceso hijo ejecuta el comando
        execvp(args[0], args);
        perror("Command execution failed");
        exit(1);
    } else {
        //Proceso padre espera si no es background
        if(!background) {
            wait(NULL);
        }
    }
}

int main(int argc, char *argv[]) {
    pid_t ppid = atoi(argv[1]);     //Pid recibido

    char *username = (argc > 1) ? argv[1] : "unknown";
    char command[MAX_LENGTH];
    
    printf("Shell started for user: %s\n", username);
    
    //Loop del sheel
    while(1) {
        printf("sh > ");
        fflush(stdout);
        
        if(!fgets(command, sizeof(command), stdin)) break;
        
        execute_command(command, ppid);
    }
    
    return 0;
}