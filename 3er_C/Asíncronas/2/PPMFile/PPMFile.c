#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "PPMFile.h"


struct rgbColor {
    unsigned char r;
    unsigned char g;
    unsigned char b;
};


rgbColor **createImage(int width, int height) {
	rgbColor **image = (rgbColor **)malloc(height * sizeof(rgbColor *));
    int i;
    for(i = 0; i < height; i++) {
        image[i] = (rgbColor *)malloc(width * sizeof(rgbColor));
    }
    return image;
}


void freeImage(rgbColor **image, int height) {
    int i;
	for (i = 0; i < height; i++) {
        free(image[i]);
    }
    free(image);
}


void saveImage(char *name, int width, int height, int max, rgbColor **image) {
    FILE *file = fopen(name, "w");
    if (file == NULL) return;

    fprintf(file, "P3\n%d %d\n%d\n", width, height, max);
    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            fprintf(file, "%d %d %d\n", image[i][j].r, image[i][j].g, image[i][j].b);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}


PPMFile *ppmFile_create(char *name) {
    FILE *file = fopen(name, "r");
    if (file == NULL) return NULL;

    PPMFile *pf = (PPMFile *)malloc(sizeof(PPMFile));
    if (pf == NULL) {
        fclose(file);
        return NULL;
    }

    fscanf(file, "P3\n%d %d\n%d\n", &pf->width, &pf->height, &pf->max);

    pf->name = (char *)malloc(pf->nameLength + 1);
    if (pf->name == NULL) {
        free(pf);
        fclose(file);
        return NULL;
    }
    pf->nameLength = strlen(name);
    strcpy(pf->name, name);

    pf->image = createImage(pf->width, pf->height);

    int i, j;
    for (i = 0; i < pf->height; i++) {
        for (j = 0; j < pf->width; j++) {
        	fscanf(file, "%hhu %hhu %hhu", &pf->image[i][j].r, &pf->image[i][j].g, &pf->image[i][j].b);
        }
    }

    fclose(file);
    return pf;
}


void ppmFile_destroy(PPMFile *pf) {
    if (pf == NULL) return;
    free(pf->name);
    freeImage(pf->image, pf->height);
    free(pf);
}


void ppmFile_blackAndWhite(PPMFile *pf) {
    if (pf == NULL) return;

    rgbColor **matricita = createImage(pf->width, pf->height);

    int i, j;
    for (i = 0; i < pf->height; i++) {
        for (j = 0; j < pf->width; j++) {
            int bw = (int)round(((pf->image[i][j].r + pf->image[i][j].g + pf->image[i][j].b) / 3)/ 255.0);
            matricita[i][j].r = matricita[i][j].g = matricita[i][j].b = bw;
        }
    }

    char *newName = (char *)malloc(strlen("bw_") + strlen(pf->name) + 1);
	if (newName == NULL) return;

	strcpy(newName, "bw_");
	strcat(newName, pf->name);
	saveImage(newName, pf->width, pf->height, 1, matricita);
	free(newName);
	freeImage(matricita, pf->height);

}


void ppmFile_grayscale(PPMFile *pf) {
    if (pf == NULL) return;

    rgbColor **matricita = createImage(pf->width, pf->height);

    int i, j;
    for (i = 0; i < pf->height; i++) {
        for (j = 0; j < pf->width; j++) {
            int gs = (int)round((pf->image[i][j].r + pf->image[i][j].g + pf->image[i][j].b) / 3);
            matricita[i][j].r = matricita[i][j].g = matricita[i][j].b = gs;
        }
    }

    char *newName = (char *)malloc(strlen("gs_") + strlen(pf->name) + 1);
	if (newName == NULL) return;

	strcpy(newName, "gs_");
	strcat(newName, pf->name);
	saveImage(newName, pf->width, pf->height, 255, matricita);
	free(newName);
	freeImage(matricita, pf->height);
}


void ppmFile_compress(PPMFile *pf) {
    if (pf == NULL) return;

    rgbColor **matricita = createImage(pf->width, pf->height);

    int i, j;
    for (i = 0; i < pf->height; i++) {
        for (j = 0; j < pf->width; j++) {
        	matricita[i][j].r = ((int)round(pf->image[i][j].r / 255.0));
			matricita[i][j].g = ((int)round(pf->image[i][j].g / 255.0));
			matricita[i][j].b = ((int)round(pf->image[i][j].b / 255.0));
        }
    }

    char *newName = (char *)malloc(strlen("cmp_") + strlen(pf->name) + 1);
	if (newName == NULL) return;

	strcpy(newName, "cmp_");
	strcat(newName, pf->name);
	saveImage(newName, pf->width, pf->height, 1, matricita);
	free(newName);
	freeImage(matricita, pf->height);
}


void ppmFile_dithering(PPMFile *pf) {
	if (pf == NULL) return;
    while (pf->width % 2 != 0) pf->width -= 1;
	while (pf->height % 2 != 0) pf->height -= 1;

	rgbColor **matricita = createImage(pf->width, pf->height);

    int i, j;
    for (i = 0; i < pf->height; i += 2) {
            for (j = 0; j < pf->width; j += 2) {
            float pR = (pf->image[i][j].r + pf->image[i][j + 1].r + pf->image[i + 1][j].r + pf->image[i + 1][j + 1].r) / 4;
            float pG = (pf->image[i][j].g + pf->image[i][j + 1].g + pf->image[i + 1][j].g + pf->image[i + 1][j + 1].g) / 4;
            float pB = (pf->image[i][j].b + pf->image[i][j + 1].b + pf->image[i + 1][j].b + pf->image[i + 1][j + 1].b) / 4;

            if (pR > 255 * 0.875) {
            	matricita[i][j].r = matricita[i][j + 1].r = matricita[i + 1][j].r = matricita[i + 1][j + 1].r = 1;
            } else if (pR > 255 * 0.625) {
            	matricita[i][j].r = matricita[i][j + 1].r = matricita[i + 1][j + 1].r = 1;
            	matricita[i + 1][j].r = 0;
            } else if(pR > 255 * 0.375){
            	matricita[i][j].r = matricita[i + 1][j + 1].r = 1;
            	matricita[i][j + 1].r = matricita[i + 1][j].r = 0;
            } else if(pR > 255 * 0.125) {
            	matricita[i + 1][j].r = 1;
            	matricita[i][j].r = matricita[i][j + 1].r = matricita[i + 1][j + 1].r = 0;
            } else {
            	matricita[i][j].r = matricita[i][j + 1].r = matricita[i + 1][j].r = matricita[i + 1][j + 1].r = 0;
            }

            if (pG > 255 * 0.875) {
            	matricita[i][j].g = matricita[i][j + 1].g = matricita[i + 1][j].g = matricita[i + 1][j + 1].g = 1;
			} else if (pG > 255 * 0.625) {
				matricita[i][j].g = matricita[i][j + 1].g = matricita[i + 1][j + 1].g = 1;
				matricita[i + 1][j].g = 0;
			} else if(pG > 255 * 0.375){
				matricita[i][j].g = matricita[i + 1][j + 1].g = 1;
				matricita[i][j + 1].g = matricita[i + 1][j].g = 0;
			} else if(pG > 255 * 0.125) {
				matricita[i + 1][j].g = 1;
				matricita[i][j].g = matricita[i][j + 1].g = matricita[i + 1][j + 1].g = 0;
			} else {
				matricita[i][j].g = matricita[i][j + 1].g = matricita[i + 1][j].g = matricita[i + 1][j + 1].g = 0;
			}

            if (pB > 255 * 0.875) {
            	matricita[i][j].b = matricita[i][j + 1].b = matricita[i + 1][j].b = matricita[i + 1][j + 1].b = 1;
			} else if (pB > 255 * 0.625) {
				matricita[i][j].b = matricita[i][j + 1].b = matricita[i + 1][j + 1].b = 1;
				matricita[i + 1][j].b = 0;
			} else if(pB > 255 * 0.375){
				matricita[i][j].b = matricita[i + 1][j + 1].b = 1;
				matricita[i][j + 1].b = matricita[i + 1][j].b = 0;
			} else if(pB > 255 * 0.125) {
				matricita[i + 1][j].b = 1;
				matricita[i][j].b = matricita[i][j + 1].b = matricita[i + 1][j + 1].b = 0;
			} else {
				matricita[i][j].b = matricita[i][j + 1].b = matricita[i + 1][j].b = matricita[i + 1][j + 1].b = 0;
			}
        }
    }

    char *newName = (char *)malloc(strlen("dth_") + strlen(pf->name) + 1);
	if (newName == NULL) return;

	strcpy(newName, "dth_");
	strcat(newName, pf->name);
	saveImage(newName, pf->width, pf->height, 1, matricita);
	free(newName);
	freeImage(matricita, pf->height);
}