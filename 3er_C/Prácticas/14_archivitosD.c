#include <stdio.h>
#include <stdlib.h>


//		(leer un archivo de texto)


int main()
{
	FILE * f = fopen("archivitoC.mitxt", "r");
	if(f == NULL)
		return -1;
	
	int cantidadEstaturas;
	fscanf(f, "%d", &cantidadEstaturas);
	
	double * estaturas = (double *) malloc(cantidadEstaturas * sizeof(double));
	
	for(int i = 0 ; i < cantidadEstaturas; i++)
	{
		fscanf(f, "%lf\n", estaturas + i); //&estaturas[i]
		printf("%i: %lf\n", i, estaturas[i]);
	}
	
	fclose(f);
	free(estaturas);
	
	return 0;
}