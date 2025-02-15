#ifndef FLOODFILL_H
#define FLOODFILL_H


#define ROWS 20
#define COLS 30

typedef struct {
    int x;
    int y;
} Pixel;

void printMatrix(char matrix[ROWS][COLS]);
void recursiveFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo);
void stackFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo);
void queueFloodFill(char matrix[ROWS][COLS], int x, int y, char numOriginal, char numDeReemplazo);

#endif
