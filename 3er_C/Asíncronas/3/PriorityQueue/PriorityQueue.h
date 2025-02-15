#ifndef PRIORITY_QUEUE_H__
#define PRIORITY_QUEUE_H__


typedef void * Type;
typedef struct strPriorityQueue * PriorityQueue;
typedef enum {FALSE, TRUE} Bool;
typedef int (*CompareFunc) (Type, Type);
typedef void (*PrintFunc) (Type);
typedef void (*DestroyFunc) (Type);


PriorityQueue priorityqueue_create(DestroyFunc dF, CompareFunc cF, int capacity);
void priorityqueue_destroy(PriorityQueue pq);
int priorityqueue_size(PriorityQueue pq);
void priorityqueue_offer(PriorityQueue pq, Type element);
Type priorityqueue_peek(PriorityQueue pq);
Type priorityqueue_poll(PriorityQueue pq);


int parentIndex(int index);
int leftChildIndex(int index);
int rightChildIndex(int index);
Bool isValidIndex(PriorityQueue q, int index);

#endif