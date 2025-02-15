#include <stdio.h>
#include <stdlib.h>
#include "Stack.c"

void printIntFromPointer(Type data)
{
	int * pI = (int *) data;
	printf("Destroying: %d\n", *pI);
}

void stringDestructor(Type data)
{
	//char * cI = (char *) data;
	free(data);
}

int main()
{
	Stack st = stack_create(printIntFromPointer);
	int arr[] = { 10, 20, 30, 40, 50 };
	
	stack_push(st, arr);
	stack_push(st, arr + 1);
	stack_push(st, arr + 2);
	stack_push(st, arr + 3);
	stack_push(st, arr + 4);

	int * pI = stack_top(st);
	printf("Top: %d\n", *pI);
	
	while(!stack_isEmpty(st))
	{
		pI = (int *) stack_pop(st);
		printf("Pop: %d\n", *pI);
	}
	
	stack_push(st, arr);
	stack_push(st, arr + 1);
	stack_push(st, arr + 2);
	stack_push(st, arr + 3);
	stack_push(st, arr + 4);
	
	stack_destroy(st);
	
	Stack st1 = stack_create(NULL);
	stack_push(st1, "Hola");
	stack_push(st1, "Tengo hambre");
	stack_push(st1, "AdiOs");
	
	char * cArr1 = (char * ) stack_pop(st1);
	printf("%s\n", cArr1);
	printf("%s\n", stack_pop(st1));
	
	
	stack_destroy(st1);
	
	Stack st2 = stack_create(stringDestructor);
	char * s1 = malloc(3);
	char * s2 = malloc(3);
	char * s3 = malloc(3);
	s1[0] = 'H';
	s1[1] = 'o';
	s2[0] = 'T';
	s2[1] = 'e';
	s3[0] = 'A';
	s3[1] = 'd';
	
	s1[2] = s2[2] = s3[2] = '\0';
	
	stack_push(st2, s1);
	stack_push(st2, s2);
	stack_push(st2, s3);
	
	while(!stack_isEmpty(st2))
	{
		char * string = (char *) stack_pop(st2);
		printf("%s\n", string);
		stringDestructor(string); //free(string);
	}
	
	stack_destroy(st2);
	
	
	return 0;
}