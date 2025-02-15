#include <stdio.h>
#include <stdlib.h>
#include "PPMFile.c"


int main() {
    
    char filename[] = "Lego.ppm";

    PPMFile *file = ppmFile_create(filename);
    if (file == NULL) {
        printf("No se pudo abrir el archivo %s\n", filename);
        return 1;
    }

    ppmFile_blackAndWhite(file);
    ppmFile_grayscale(file);
    ppmFile_compress(file);
    ppmFile_dithering(file);

    ppmFile_destroy(file);

    return 0;
}
