#include <stdlib.h>
#include "Stack.h"
#include "Queue.h"

struct strNodeS {
	Type data;
	struct strNodeS * prior;
};

typedef struct strNodeS * NodeS;


struct strStack {
	struct strNodeS* top;
	int size;
	void (*destructor)(Type);
};

Stack stack_create(void (*destructor)(Type))
{
	Stack st = (Stack) malloc(sizeof(struct strStack));
	if(st == NULL)
		return NULL;
	
	st->size = 0;
	st->top = NULL;
	st->destructor = destructor;
	return st;
}

int stack_size(Stack st)
{
	if(st == NULL)
		return -1;
	
	return st->size;
}

bool stack_isEmpty(Stack st)
{
	if(st == NULL)
		return TRUE;
	
	return st->size == 0; //return st->top == NULL;
}

Type stack_top(Stack st) //Muestra el dato del tope de la pila
{
	if(st == NULL || stack_isEmpty(st))
		return NULL;
	
	return st->top->data;
}

void stack_push(Stack st, Type data)
{
	if(st == NULL)
		return;
	
	
	NodeS node = (NodeS) malloc(sizeof(struct strNodeS));
	node->data = data;
	node->prior = st->top;
	
	st->top = node;
	st->size++;
}

Type stack_pop(Stack st)
{
	if(st == NULL || st->size == 0)
		return NULL;
	
	Type data = st->top->data;
	NodeS node = st->top;
	
	st->top = node->prior;
	free(node);
	st->size--;
	
	return data;
}

void stack_destroy(Stack st)
{
	if(st == NULL)
		return;
	
	NodeS current = st->top;
	
	while(current != NULL)
	{
		NodeS prior = current->prior;
		//free current->data in case destructor isn't NULL
		if(st->destructor != NULL)
			st->destructor(current->data);
		free(current);
		current = prior;
	}
	
	//free node->data in case destructor isn't NULL
	free(st);
}