#include "Queue.h"

typedef void * Type;


typedef struct strStack * Stack;


Stack stack_create(); //Crea un ejemplar Stack con memoria dinámica y asigna NULL y 0 a sus elementos.
int stack_size(Stack st); //Extrae el tamaño de la pila
bool stack_isEmpty(Stack st); //¿El tope es nulo?
Type stack_top(Stack st); //Muestra el dato del tope de la pila
void stack_push(Stack st, Type data);
Type stack_pop(Stack st); //Extrae el dato del tope de la pila
void stack_destroy(Stack st);
