#ifndef PPMFILE_H_
#define PPMFILE_H_


typedef struct rgbColor rgbColor;


typedef struct {
    char *name;
    int nameLength;
    int width;
    int height;
    int max;
    rgbColor **image;
} PPMFile;


PPMFile *ppmFile_create(char *name);
void ppmFile_destroy(PPMFile *pf);
void ppmFile_blackAndWhite(PPMFile *pf);
void ppmFile_grayscale(PPMFile *pf);
void ppmFile_compress(PPMFile *pf);
void ppmFile_dithering(PPMFile *pf);


#endif