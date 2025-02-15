#include <stdio.h>
#include <stdlib.h>
#include "Queue.c"
#include "Queue.h"


void stringDestructor(Type data)
{
	//char * cI = (char *) data;
	free(data);
}

int main()
{
	Queue st = queue_create(NULL);
	int arr[] = { 20, 10, 30, 40, 50 };
	
	queue_offer(st, arr);
	queue_offer(st, arr + 1);
	queue_offer(st, arr + 2);
	queue_offer(st, arr + 3);
	queue_offer(st, arr + 4);

	int * pI = queue_peek(st);
	printf("Peek: %d\n", *pI);
	
	while(!queue_isEmpty(st))
	{
		pI = (int *) queue_poll(st);
		printf("Poll: %d\n", *pI);
	}
	
	queue_offer(st, arr);
	queue_offer(st, arr + 1);
	queue_offer(st, arr + 2);
	queue_offer(st, arr + 3);
	queue_offer(st, arr + 4);
	
	queue_destroy(st);
	
	Queue st1 = queue_create(NULL);
	queue_offer(st1, "Hola");
	queue_offer(st1, "Tengo hambre");
	queue_offer(st1, "AdiOs");
	
	char * cArr1 = (char * ) queue_poll(st1);
	printf("%s\n", cArr1);
	printf("%s\n", queue_poll(st1));
	
	
	queue_destroy(st1);
	
	Queue st2 = queue_create(stringDestructor);
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
	
	queue_offer(st2, s1);
	queue_offer(st2, s2);
	queue_offer(st2, s3);
	
	while(!queue_isEmpty(st2))
	{
		char * string = (char *) queue_poll(st2);
		printf("%s\n", string);
		stringDestructor(string); //free(string);
	}
	
	queue_destroy(st2);
	
	return 0;
}