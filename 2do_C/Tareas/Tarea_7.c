#include <stdio.h>

////
int compare_matrix(char string_1[], char string_2[]){
    for(int i=0; ;i++){
        if(string_1[i]=='\0' && string_2[i]=='\0')
            return 1;
        if(string_1[i]=='\0' && string_2[i]!='\0' || string_1[i]!='\0' && string_2[i]=='\0')
            return 0;
    }
}

void ejercicio_1(){
    char string_1[20];
    char string_2[20];
    printf("\n\n----------COMPARADOR DE TAMAÑO----------\n\n");
    
    printf("\nEscribe la cadena 1: ");
    scanf("%s",string_1);
    printf("\nEscribe la cadena 2: ");
    scanf("%s",string_2);
    printf("\nLas cadenas %s tienen el mismo tamaño\n",compare_matrix(string_1,string_2)?"si":"no");
}


////
void string_copy(char out[],char in[],int n){
    int i = 0;
    while(i<n && in[i]!='\0'){
        out[i] = in[i];
        i++;
    }
    out[i] = '\0';
}

void ejercicio_2(){
    char string_1[20];
    char string_2[20];
    int n_chars;

    printf("\n\n----------COPIAR ARREGLO----------\n\n");
    
    printf("\nIngresa la palabra de la cadena 1: ");
    scanf("%s",string_1);
    printf("\nCuántos caracteres quieres copiar?: ");
    scanf("%i",&n_chars);
    string_copy(string_2, string_1,n_chars);
    printf("\nAhora, la cadena 2 tiene: %s\n",string_2);
}


void print_matrix(int c, int f, int m[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            printf("%i\t",m[i][j]);
        }
        printf("\n");
    }
}


////
void ejercicio_3(){
    
    int n;
    int posicion;

    printf("\n\n----------NÚMERO MAYOR----------\n\n");

    printf("Ingrese el número de elementos con el que desea trabajar: ");
    scanf("%i",&n);
    
    int numeros[n];
    
    for (int i = 0; i < n; i++){
        printf("\nNúmero_%i: ", i+1);
        scanf("%i", &numeros[i]);
    }

    int num_mayor = numeros[0];
    
    for (int i = 1; i < n; i++){
        if(numeros[i] > num_mayor)
            num_mayor = numeros[i];
    }
    for (int i = 0; i < n; i++){
        if(num_mayor == numeros[i])
            posicion = i;
    }

    printf("\nEl número mayor es: %i y se encuentra en la posición: %i del arreglo\n", num_mayor, posicion);
    }


////
void matrix_sum(int c, int f, int m1[c][f], int m2[c][f], int result[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            result[i][j] = m1[i][j] + m2[i][j];
        }
    }
}

void matrix_res(int c, int f, int m1[c][f], int m2[c][f], int result[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            result[i][j] = m1[i][j] - m2[i][j];
        }
    }
}

void matrix_mul(int c, int f, int m1[c][f], int m2[c][f], int result[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            result[i][j] = m1[i][j] * m2[i][j];
        }
    }
}

void matrix_esc(int c, int f, int m1[c][f], int esc, int result[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            result[i][j] = m1[i][j] * esc;
        }
    }
}

void matrix_tran(int c, int f, int m1[c][f], int m2[c][f], int result[c][f]){
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            result[i][j] = m1[i][j] * m2[i][j];
        }
    }
}


void ejercicio_4(){
    int c1,f1,c2,f2, oper, esc;

    printf("\n\n----------------CALCULADORA DE MATRICES-----------------\n\n");
    printf("Escoge el tipo de operación que deseas realizar escribiendo el número que la representa: \n");
    printf("1. Suma \n");
    printf("2. Resta \n");
    printf("3. Producto punto \n");
    printf("4. Producto de un escalar por una matriz \n");
    printf("5. Transpuesta de una matriz \n");
    printf("Operación a realizar: ");
    scanf("%i", &oper);

    if(oper == 4){
        printf("Escribe el escalar: ");
        scanf("%i",&esc);

        printf("\nColumnas matriz 1?\n");
        scanf("%i",&c1);
        printf("Filas?\n");
        scanf("%i",&f1);
        int matrix[c1][f1];

        printf("Escribe los números que quieras:\n");
        for(int i=0;i<f1;i++){
            for(int j=0;j<c1;j++){
                scanf("%i",&matrix[i][j]);
            }
        }

        int result[c1][f1];
        matrix_esc(c1, f1, matrix, esc,result);
        printf("Matriz 1:\n");
        print_matrix(c1,f1, matrix);
        printf("\nEscalar: %i\n",esc);
        printf("\nEscalar:\n");
        print_matrix(c1,f1, result);
    }

    else{
        printf("\nColumnas matriz 1?\n");
        scanf("%i",&c1);
        printf("Filas?\n");
        scanf("%i",&f1);
        int matrix[c1][f1];

        printf("Escribe los números que quieras:\n");
        for(int i=0;i<f1;i++){
            for(int j=0;j<c1;j++){
                scanf("%i",&matrix[i][j]);
            }
        }

        printf("\nColumnas matriz 2?\n");
        scanf("%i",&c2);
        printf("Filas?\n");
        scanf("%i",&f2);
        int matrix2[c2][f2];
    
        printf("Escribe los números que quieras:\n");
        for(int i=0;i<f2;i++){
            for(int j=0;j<c2;j++){
                scanf("%i",&matrix2[i][j]);
            }
        }



        if(c1!=c2 || f1!=f2)
            printf("La operación no puede realizarse.\n");
        else{
        
            if(oper == 1){
                int result[c1][f1];
                matrix_sum(c1, f1, matrix, matrix2,result);
                printf("Matriz 1:\n");
                print_matrix(c1,f1, matrix);
                printf("\nMatriz 2:\n");
                print_matrix(c1,f1, matrix2);
                printf("\nSuma:\n");
                print_matrix(c1,f1, result);
            }
            
            else if(oper == 2){
                int result[c1][f1];
                matrix_res(c1, f1, matrix, matrix2,result);
                printf("Matriz 1:\n");
                print_matrix(c1,f1, matrix);
                printf("\nMatriz 2:\n");
                print_matrix(c1,f1, matrix2);
                printf("\nResta:\n");
                print_matrix(c1,f1, result);
            }
            
            else if(oper == 3){
                int result[c1][f1];
                matrix_mul(c1, f1, matrix, matrix2,result);
                printf("Matriz 1:\n");
                print_matrix(c1,f1, matrix);
                printf("\nMatriz 2:\n");
                print_matrix(c1,f1, matrix2);
                printf("\nProducto punto:\n");
                print_matrix(c1,f1, result);
                }
                
            else if(oper == 5){
                int result[c1][f1];
                matrix_tran(c1, f1, matrix, matrix2,result);
                printf("Matriz 1:\n");
                print_matrix(c1,f1, matrix);
                printf("\nMatriz 2:\n");
                print_matrix(c1,f1, matrix2);
                printf("\nProducto punto:\n");
                print_matrix(c1,f1, result);
            } 

        }
    }
}



void suma_diagonal(int c, int f, int m1[c][f]){
    int num;
    for(int i=0;i<c;i++){
        for(int j=0;j<f;j++){
            if(i == j)
                num += m1[i][i];
        }
    }
    printf("\nSuma diagonal: %i\n", num);
}

void ejercicio_5(){
    int c1,f1,c2,f2;
    
    printf("\n\n----------------SUMA DIAGONAL-----------------\n\n");
    printf("\nNúmero de columnas y filas de la matriz\n");
        scanf("%i",&c1);
        f1 = c1;
        int matrix[c1][f1];
    
        printf("Escribe los números que quieras:\n");
        for(int i=0;i<f1;i++){
            for(int j=0;j<c1;j++){
                scanf("%i",&matrix[i][j]);
            }
        }

    printf("\nMatriz:\n");
    print_matrix(c1,f1, matrix);
    suma_diagonal(c1,f1, matrix);
}


void ejercicio_6(){
    int c1,f1,c2,f2, x = 1, res;
    printf("\n\n----------------COMPARADORA DE MATRICES-----------------\n\n");
    printf("\nColumnas de las matrices?\n");
    scanf("%i",&c1);
    printf("Filas?\n");
    scanf("%i",&f1);
    int matrix[c1][f1];
    c2 = c1;
    f2 = f1;
    int matrix_2[c2][f2];

    printf("\nEscribe los números de la matriz 1:\n");
    for(int i=0;i<f1;i++){
        for(int j=0;j<c1;j++){
            scanf("%i",&matrix[i][j]);
        }
    }

    printf("\nEscribe los números de la matriz 2:\n");
    for(int i=0;i<f2;i++){
        for(int j=0;j<c2;j++){
            scanf("%i",&matrix_2[i][j]);
        }
    }

    for(int i=0;i<f2;i++){
        for(int j=0;j<c2;j++){
            if(matrix[i][j] != matrix_2[i][j])
                x = 0;
        }
    }
    if(x == 0)
        printf("\nLas matrices no son iguales\n");
    else
        printf("\nLas matrices son iguales\n");
}


int main(){
    ejercicio_1();
    ejercicio_2();
    ejercicio_3();
    ejercicio_4();
    ejercicio_5();
    ejercicio_6();
}