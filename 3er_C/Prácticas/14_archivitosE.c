#include <stdio.h>


//		(calcular el tamaño en bytes de un archivo)


//devuelve el tamaNio de un archivo en bytes
//mueve el cursor del archivo al final del mismo
long int miFuncion(FILE * f)
{
	fseek(f, 0, SEEK_END);
	return ftell(f);
}

//mismo propOsito que la funciOn anterior
//pero respeta la posiciOn del cursor
long int miFuncionB(FILE * f)
{
	long int posActual = ftell(f);
	fseek(f, 0, SEEK_END);
	long int tamaNio = ftell(f);
	fseek(f, posActual, SEEK_SET);
	return tamaNio;
}

int main()
{
	FILE * f = fopen("archivitoA.miext", "rb");
	if(f == NULL)
		return -1;
	
	printf("%lf\n", miFuncion(f) / 1024.0);
	fclose(f);

	return 0;
}