#include <stdio.h>


void print1(int array[10]) {
    int i;
    for(i = 0; i < 10; i ++) printf("%d ", array[i]);
}

void print2(int array[], int N) {
    int i;
    for(i = 0; i < N; i ++) printf("%d ", array[i]);
}

void print3(int *array, int N){
    int i;
    for(i = 0; i < N; i ++) printf("%d ", array[i]);
}

void print4(int matrix[3][3]) {
    int r, c;
    for(r = 0; r < 3; r ++) {
        for(c = 0; c < 3; c ++) printf("%d\t", matrix[r][c]);
            printf("\n");
    }
}

void print5(int matrix[][3], int R) {
    int r, c;
    for(r = 0; r < R; r ++) {
        for(c = 0; c < 3; c ++) printf("%d\t", matrix[r][c]);
            printf("\n");
    }
}




int main(){
    int array[] = {5, 6, 7};
    print1(array);
    printf("\n");

    int array2[] = {5, 6, 7, 8, 9};
    print2(array2, 4);
    printf("\n");

    int array3[] = {5, 6, 7, 8, 9};
    print3(array3, 4);
    printf("\n");

    int* parray = array2;
    parray ++;
    print1(parray);
    printf("\n");
    print2(parray, 4);
    printf("\n");
    print3(parray, 4);
    printf("\n");

    int matrix[][3] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
    print4(matrix);
    print5(matrix, 2);


    //Ejercicios
    printf("\n");
    //char * str = "hola mundo palabras random";
    //printf("%d\n",lenght(str));


    //apuntadores dobles
    int i = 3;
    f1(&i);
    printf("%d\n",i);


    int* pI = &i;
    printf("%p\n",pI);
    f2(&pI);
    printf("%p\n",pI);
    printf("%d\n",i);

    pI--;
    f3(&pI);
    printf("%p\n",pI);
    printf("%d\n",i);


    return 0;
}

unsigned int lenght(char str[]){
    char * ptr = str;
    while(&ptr != '\0')
        ptr++;

    return ptr-str;
}

void f1(int* pI){
    (*pI)++;
}

void f2(int** ppI){
    (*ppI)++;
}

void f3(int** ppI){
    (**ppI)++;
}


