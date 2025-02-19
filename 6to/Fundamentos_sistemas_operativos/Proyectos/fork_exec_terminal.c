#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();  // Create a child process

    if (pid < 0) {
        // Fork failed
        perror("Fork failed");
        exit(1);

    } else if (pid == 0) {
        // Child process
        printf("Child process: PID = %d\n", getpid());
        // Arguments for the "gnome-terminal" command
        char *args[] = {"gnome-terminal", "--", "python3", "-q", NULL};
        // Replace the child process with the "gnome-terminal" command
        execvp("gnome-terminal", args);
        // If execvp() fails
        perror("execvp failed");
        
        exit(1);
    } else {
        // Parent process
        printf("Parent process: PID = %d, Child PID = %d\n", getpid(), pid);
        // Wait for the child process to complete
        wait(NULL);
        printf("Child process finished.\n");
    }

    return 0;
}