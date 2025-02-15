#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include "FloodFill.h"
#include "Stack.c"
#include "Queue.c"


//Animación______________________________________________________________________________________________________________
char m[ROWS][COLS];
char buffer[ROWS*COLS + ROWS + 1];

void display();
void delay(int msLimit);

void printMatrix(char matrix[ROWS][COLS]) {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            printf("%c", matrix[i][j]);
        }
        printf("\n");
    }
}

void display() {
	int i, j, k = 0;
	for(i=0; i<ROWS; i++)
	{
		for(j=0; j<COLS; j++)
			buffer[k++] = m[i][j];
		buffer[k++] = '\n';
	}

	buffer[k] = '\0';
	printf("%s", buffer);
}

void delay(int msLimit)
{
	clock_t begin = clock();

	clock_t end, difference;
	do
	{
		end = clock();
		difference = (end - begin) * 1000 / CLOCKS_PER_SEC;
	}while(difference < msLimit);
}
//----------------------------------------------------------------------------------------------------------------------------

//__Recursiva_________________________________________________________________________________________________________________
void recursiveFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo) {
    if (numOriginal == numDeReemplazo || matrix[x][y] != numOriginal) {
        return;
    }

    matrix[x][y] = numDeReemplazo;
    printMatrix(matrix);
    delay(166);
	//limpiamos la pantalla
	system("cls");
	//dibujamos la matriz
	display();

    if (x + 1 < ROWS) recursiveFloodFill(matrix, x + 1, y, numOriginal, numDeReemplazo);
    if (x - 1 >= 0) recursiveFloodFill(matrix, x - 1, y, numOriginal, numDeReemplazo);
    if (y + 1 < COLS) recursiveFloodFill(matrix, x, y + 1, numOriginal, numDeReemplazo);
    if (y - 1 >= 0) recursiveFloodFill(matrix, x, y - 1, numOriginal, numDeReemplazo);
}
//----------------------------------------------------------------------------------------------------------------------------
//__Stack_____________________________________________________________________________________________________________________
void stackFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo) {
    Stack stack = stack_create(NULL);
    if (stack == NULL) {
        return;
    }

    Pixel startPixel = {x, y};
    stack_push(stack, &startPixel);


    while (!stack_isEmpty(stack)) {
        Pixel *currentPixel = (Pixel *)stack_pop(stack);

        x = currentPixel->x;
        y = currentPixel->y;
        free(currentPixel);
        if (x < 0 || x >= ROWS || y < 0 || y >= COLS || matrix[x][y] != numOriginal) {
            continue;
        }

        matrix[x][y] = numDeReemplazo;
        printMatrix(matrix);
        delay(166);
        system("cls");
        display();

        Pixel nextPixels[] = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};

        for (int i = 0; i < 4; i++) {
            int nextX = nextPixels[i].x;
            int nextY = nextPixels[i].y;

            if (nextX >= 0 && nextX < ROWS && nextY >= 0 && nextY < COLS && matrix[nextX][nextY] == numOriginal) {
                Pixel *nextPixel = malloc(sizeof(Pixel));
                nextPixel->x = nextX;
                nextPixel->y = nextY;
                stack_push(stack, nextPixel);
            }
        }
    }
    stack_destroy(stack);
}
//-----------------------------------------------------------------------------------------------------
//__Funcion_queueFloodFill_____________________________________________________________________________

void queueFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo) {
    Queue queue = queue_create(NULL);

    if (queue == NULL) {
        NULL;
    }

    Pixel startPixel = {x, y};
    queue_offer(queue, &startPixel);

    while (!queue_isEmpty(queue)) {
        Pixel *currentPixel = (Pixel *)queue_poll(queue);
        x = currentPixel->x;
        y = currentPixel->y;

        if (matrix[x][y] == numOriginal) {
            matrix[x][y] = numDeReemplazo;
            printMatrix(matrix);
                delay(166);
                //limpiamos la pantalla
                system("cls");
                //dibujamos la matriz
                display();


            Pixel neighbors[] = {
                {x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}
            };

            for (int i = 0; i < 4; i++) {
                int nx = neighbors[i].x;
                int ny = neighbors[i].y;

                if (nx >= 0 && nx < ROWS && ny >= 0 && ny < COLS && matrix[nx][ny] == numOriginal) {
                    Pixel *newPixel = malloc(sizeof(Pixel));
                    newPixel->x = nx;
                    newPixel->y = ny;
                    queue_offer(queue, newPixel);
                }
            }
        }

        free(currentPixel);
    }

    queue_destroy(queue);
}
//-----------------------------------------------------------------------------------------------------