#include <stdio.h>
#include <stdlib.h>


typedef struct{
    unsigned char IP[4];
    unsigned short puerto;
}Socket;

//inicializar un arreglo de sockets pasado por referencia, reservando memoria para el arreglo de sockets
void initSockets0(Socket ** arr, int N){
    *arr = (Socket *) malloc(N * sizeof(Socket));
    for(int i = 0; i < N; i++){
        (*arr)[i].puerto = 80;
        //((*arr)+i)->puerto = 80;
        (*arr)[i].IP[0] = 127;
        (*arr)[i].IP[1] = 0;
        (*arr)[i].IP[2] = 0;
        (*arr)[i].IP[3] = 1;
    }
}

//inicializar un arreglo de apuntadores a sockets pasado por referencia, reservando memoria para el arreglo de apuntadores y para cada socket
void initSockets(Socket *** arr, int N){
    *arr = (Socket **) malloc(N * sizeof(Socket *));
    for(int i = 0; i < N; i++){
        (*arr)[i] = (Socket *) malloc(sizeof(Socket));
        (*arr)[i]->puerto = 80;
        (*arr)[i]->IP[0] = 127;
        (*arr)[i]->IP[1] = 0;
        (*arr)[i]->IP[2] = 0;
        (*arr)[i]->IP[3] = 1;
    }
}

//imprimir un socket pasado por referencia
void printSocket(Socket * pS){
printf("%d.%d.%d.%d:%d\n", pS->IP[0], pS->IP[1], pS->IP[2], pS->IP[3], pS->puerto);
}

//imprimir todos los sockets de un arreglo de sockets pasado por valor
void printSockets0(Socket arr[], int N){
    for(int i = 0; i < N; i++)
        printSocket(&arr[i]);
}

//imprimir todos los sockets de un arreglo de apuntadores a sockets pasado por valor
void printSockets(Socket * arr[], int N){
    for(int i = 0; i < N; i++)
        printSocket(arr[i]);
}


//-------------------------------------------------------

void initString(char ** target, char * source){
    int len=0;
    while(*(source + len) != '\0') len++;
    * target = (char*) malloc((len+1)*sizeof(char));
    for( ;len >= 0; len--){
        (*target)[len] =source[len];
    }
}

int main(){
    Socket * arr0 = NULL;
    initSockets0(&arr0, 20);
    printSockets0(arr0, 20);
    printf("\n");

    Socket ** arr1 = NULL;
    initSockets(&arr1, 10);
    printSockets(arr1, 10);


    char * target = NULL;
    initString(&target, "Texto de prueba123452352456465436436");
    puts(target);
    return 0;
}
