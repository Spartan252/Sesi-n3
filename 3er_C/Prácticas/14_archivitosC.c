#include <stdio.h>


//		(escribir un archivo de texto)


int main()
{
	FILE * f = fopen("archivitoC.mitxt", "w");
	if(f == NULL)
		return -1;
	
	printf("KoAntas estaturas kieres guardar? ");
	int cantidadEstaturas;
	scanf("%d", &cantidadEstaturas);
	fprintf(f, "%i\n", cantidadEstaturas);
	
	for(int i = 0 ; i < cantidadEstaturas; i++)
		fprintf(f, "%lf\n", i / 10.0);
	
	fclose(f);
	
	return 0;
}