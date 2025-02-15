#include <stdlib.h>
#include "Stack.h"

struct strNode {
	Type data;
	struct strNode * prior;
};

typedef struct strNode * Node;


struct strStack {
	struct strNode* top;
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
	
	
	Node node = (Node) malloc(sizeof(struct strNode));
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
	Node node = st->top;
	
	st->top = node->prior;
	free(node);
	st->size--;
	
	return data;
}

void stack_destroy(Stack st)
{
	if(st == NULL)
		return;
	
	Node current = st->top;
	
	while(current != NULL)
	{
		Node prior = current->prior;
		//free current->data in case destructor isn't NULL
		if(st->destructor != NULL)
			st->destructor(current->data);
		free(current);
		current = prior;
	}
	
	//free node->data in case destructor isn't NULL
	free(st);
}