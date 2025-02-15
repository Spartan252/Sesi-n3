#include <stdio.h>
#include <stdlib.h>


//		(escribir en un archivo binario)


int main()
{
	FILE * f = fopen("archivitoA.miext", "wb");
	if(f == NULL)
		return -1;
	
	printf("KoAntas estaturas kieres guardar? ");
	int cantidadEstaturas;
	scanf("%d", &cantidadEstaturas);
	
	double * estaturas = (double *) malloc(cantidadEstaturas * sizeof(double));
	for(int i = 0 ; i < cantidadEstaturas; i++)
		estaturas[i] = i / 10.0;
	
	fwrite(&cantidadEstaturas, sizeof(int), 1, f);
	fwrite(estaturas, sizeof(double), cantidadEstaturas, f);
	fclose(f);
	
	free(estaturas);
	
	return 0;
}