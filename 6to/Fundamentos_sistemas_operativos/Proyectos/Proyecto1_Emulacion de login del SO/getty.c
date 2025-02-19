#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define PASSWD_FILE "passwd"

int sesion(const char *username, const char *password) {
    FILE *file = fopen(PASSWD_FILE, "r");
    if (!file) {
        perror("Failed to open passwd file");
        return 0;
    }

    // Se lee el archivo línea por línea buscando coincidencias
    char line[256];
    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = 0;
        char *stored_username = strtok(line, ":");
        char *stored_password = strtok(NULL, ":");

        //Se verifica que coincida
        if (stored_username && stored_password &&
            strcmp(username, stored_username) == 0 &&
            strcmp(password, stored_password) == 0) {
            fclose(file);
            return 1;
        }
    }

    fclose(file);
    return 0;
}

int main(int argc, char *argv[]) {
    char *pid_str = argv[1];        //pid recibido

    char username[256];
    char password[256];

    //El loop principal
    while (1) {
        printf("login: ");
        scanf("%s", username);      //Se obtiene el username y password a probar
        printf("password: ");
        scanf("%s", password);

        //Si la seción fue iniciada corectamente
        if (sesion(username, password)) {
            printf("Login successful!\nSi le atinaste\n");
            pid_t pid = fork();
            if (pid < 0) {
                perror("Fork failed");
                exit(1);
            } else if (pid == 0) {
                //Se ejecuta el sh
                char *args[] = {"sh", pid_str, NULL}; //pasa el pid
                execvp("./sh", args);

                // If execvp() fails
                perror("execvp failed");
                exit(1);
            } else {

                // se espera a que sh termine
                wait(NULL);
            }
        } else {
            printf("Login failed. Better luck next time.\n");
        }
    }

    return 0;
}