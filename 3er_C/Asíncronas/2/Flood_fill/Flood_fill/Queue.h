#ifndef QUEUE_H_
#define QUEUE_H_
typedef void * Type;
typedef enum { FALSE, TRUE }bool;

typedef struct strQueue * Queue;

Queue queue_create(void (*destructor)(Type));//	Crea un ejemplar Queue con memoria dinámica void (*destructor)(void *)); y asigna NULL, NULL, 0 y destructor.
int   queue_size(Queue);//	Extrae el tamaño de la cola
bool  queue_isEmpty(Queue);//	¿El primero es nulo?
Type  queue_peek (Queue);//	Consulta quién está al frente (no elimina)
void  queue_offer(Queue, Type);//	Se forma uno nuevo (colocarlo al final)
Type  queue_poll(Queue);//	Atiende al que está al frente (elimina)
void  queue_destroy(Queue);//	Elimina a todos los nodos y a la cola misma

#endif