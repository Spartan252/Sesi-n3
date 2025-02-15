#include <stdlib.h>
#include "Queue.h"

struct strNode
{
	Type data;
	struct strNode * next;
};

typedef struct strNode * Node;

struct strQueue
{
	Node first, last;
	int size;
	void (*destructor)(Type);
};

Queue queue_create(void (*destructor)(Type))
{
	Queue q = (Queue) malloc(sizeof(struct strQueue));
	if(q == NULL)
		return NULL;
	
	q->first = q->last = NULL;
	q->size = 0;
	q->destructor = destructor;
	
	return q;
}

int   queue_size(Queue q)//	Extrae el tamaño de la cola
{
	if(q == NULL)
		return -1;
	
	return q->size;
}
Bool  queue_isEmpty(Queue q)//	¿El primero es nulo?
{
	if(q == NULL)
		return TRUE;
	
	return q->size == 0;
}

Type  queue_peek (Queue q)//	Consulta quién está al frente (no elimina)
{
	if(q == NULL || q->size == 0)
		return NULL;
	
	return q->first->data;
}

void  queue_offer(Queue q, Type data)//	Se forma uno nuevo (colocarlo al final)
{
	if(q == NULL)
		return;
	
	Node newNode = (Node) malloc(sizeof(struct strNode));
	newNode->data = data;
	newNode->next = NULL;
	
	if(q->size == 0)
		q->first = newNode;
	else
		q->last->next = newNode;
	
	q->last = newNode;
	q->size++;
}

Type  queue_poll(Queue q)//	Atiende al que está al frente (elimina)
{
	if(q == NULL || q->size == 0)
		return NULL;
	
	Type data = q->first->data;
	Node n = q->first;
	q->first = q->first->next;
	free(n);
	if(q->size == 1)
		q->last = NULL;
	
	q->size--;
	return data;
}


void  queue_destroy(Queue q)//	Elimina a todos los nodos y a la cola misma
{
	if(q == NULL)
		return;
	
	Node current = q->first;
	while(current != NULL)
	{
		Node next = current->next;
		if(q->destructor != NULL)
			q->destructor(current->data);
		free(current);
		current = next;
	}
	
	free(q);
}