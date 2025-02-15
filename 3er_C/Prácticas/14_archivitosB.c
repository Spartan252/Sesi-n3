#include <stdio.h>
#include <stdlib.h>


//		(leer un archivo binario)


int main()
{
	FILE * f = fopen("archivitoA.miext", "rb");
	if(f == NULL)
		return -1;
	
	int cantidadEstaturas;
	fread(&cantidadEstaturas, sizeof(int), 1, f);
	
	double * estaturas = (double *) malloc(cantidadEstaturas * sizeof(double));
	
	fread(estaturas, sizeof(double), cantidadEstaturas, f);
	fclose(f);
	
	for(int i = 0; i < cantidadEstaturas; i++)
		printf("%i: %lf\n", i, estaturas[i]);
	
	free(estaturas);
	
	return 0;
}