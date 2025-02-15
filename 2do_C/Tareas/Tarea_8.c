#include <stdio.h>
#include <ctype.h>    //isdigit(password[x])
#include <string.h>  //fgets(texto, 100, stdin);
#include <ctype.h>   //toupper(letra)

void ejercicio_1(){

    char password[20];
    int larg = 0;
    int may = 0;
    int min = 0;
    int punt = 0;
    int num = 0;
    int seguridad = 0; //0 = debil  1 = fuerte

    printf("\n\n----------VERIFICAR CONTRASEÑA----------\n\n");

    printf("Ingrese la contraseña que desea verificar: ");
    scanf("%s",password);

    while(password[larg]!='\0')
        larg++;

    for(int x=0;x<larg;x++){
        int may = 0;
        int min = 0;
        int num = 0;
        if(isupper(password[x]))
            may = 1;
        if(islower(password[x]))
            min = 1;
        if(isdigit(password[x]))
            num = 1;
        if(may != 1 && min != 1 && num != 1)
            punt = 1;
    }

    for(int x=0;x<larg;x++){
        if(isupper(password[x]))
        may = 1;
    }

    for(int x=0;x<larg;x++){
        if(islower(password[x]))
        min = 1;
    }

    for(int x=0;x<larg;x++){
        if(isdigit(password[x]))
        num = 1;
    }
    
    printf("\n8 o más elementos: %c", larg >= 8 ? 'T' : 'F');
    printf("\nMayúscula: %c", may == 1 ? 'T' : 'F');
    printf("\nMinúscula: %c", min == 1 ? 'T' : 'F');
    printf("\nSigno de puntuación: %c", punt == 1 ? 'T' : 'F');
    printf("\nDígito: %c", num == 1 ? 'T' : 'F');
    
    if(larg >= 8 && may == 1 && min == 1 && punt == 1 && num == 1)
        printf("\n\nNivel de seguridad: Fuerte");
    
    else{
        int x = 1;
        printf("\n\nNivel de seguridad: Debil");
        printf("\n\nSe recomienda agregar lo siguiente a la contraseña:");
        if(larg < 8){
            printf("\n%i) 8 elementos a la contraseña",x);
            x++;
        }
        if(may != 1){
            printf("\n%i) Mayúscula",x);
            x++;
        }
        if(min != 1){
            printf("\n%i) Minúscula",x);
            x++;
        }
        if(punt != 1){
            printf("\n%i) Signo de puntuación",x);
            x++;
        }
        if(num != 1){
            printf("\n%i) Número",x);
        }
    }
}



void ejercicio_2(){

    char texto[100];
    int j = 0;

    printf("\n\n----------ELIMINAR ESPACIOS----------\n\n");

    printf("Ingrese el texto a quitar espacios: ");
    scanf("%[^\n]s",texto);

    if ((strlen(texto) > 0) && (texto[strlen(texto) - 1] == '\n')){
        texto[strlen(texto) - 1] = '\0';
    }

    for(int i=0;i<strlen(texto);i++) {
            if (texto[i] != ' ') {
                texto[j++] = texto[i];
            }
    }
    texto[j] = '\0';

    printf("\nTexto sin espacios: %s",texto);
}



void unir(char nom_com[3][20],char nom[60]){
    strcpy(nom,nom_com[0]);
    for(int i=1; i<3; i++){
        strcat(nom,nom_com[i]);
    }
}

void ejercicio_3(){
    char nom[3][20];
    char nom_com[60];
    printf("\n\n----------UNIR NOMBRE----------\n\n");
    printf("Ingrese un nombre: ");
    scanf("%s",nom[0]);
    printf("Primer apellido: ");
    scanf("%s",nom[1]);
    printf("Segundo apellido: ");
    scanf("%s",nom[2]);
    unir(nom,nom_com);
    printf("\nEl nombre junto es: %s\n",nom_com);
}



void ejercicio_4(){
    char texto[100];
    char letra;

    printf("\n\n----------CAMBIAR LETRA A MAYÚSCULA----------\n\n");

    printf("\nEjemplo: Hola, ¿como estas?,a");
        printf("\n\nIngrese el texto y la letra que desea cambiar a mayúscula en base al ejemplo: ");
    fgets(texto, 100, stdin);

    if ((strlen(texto) > 0) && (texto[strlen(texto) - 1] == '\n')){
        texto[strlen(texto) - 1] = '\0';
    }
    
    for(int i=0;i<strlen(texto);i++){
        if(texto[i]==',')
        letra = texto[i+1];
    }

    for(int i=0;i<strlen(texto);i++){
        if(texto[i] == letra)
        texto[i] = toupper(letra);
        if(texto[i] ==',')
        texto[i] = '\0';
    }

    printf("\nTexto cambiado: %s",texto);
}


int main(){
    //ejercicio_1();
    //ejercicio_2();
    //ejercicio_3();
    ejercicio_4();
}