#ifndef LIST__H_
#define LIST__H_
typedef struct strNode * Iterator; 
typedef struct strList * List;
typedef void * Type;
typedef enum { FALSE, TRUE } Bool;

List list_create(void (*destructor)(void *));
void list_destroy(List);		//Elimina a todos los nodos y a la lista.
int  list_size(List);		//Extrae el tamaño de la lista.
void list_add(List, Type);
Type list_get(List, int p);
void list_set(List, Type, int p);
Type list_remove(List, int p);

Iterator list_begin(List);	//Devuelve el iterador al pre-inicio.
Iterator list_end(List);	//Devuelve al post-final.
Bool list_hasNext(Iterator);	//Devuelve TRUE sólo si hay un nodo siguiente.
Bool list_hasPrior(Iterator);	//Devuelve TRUE sólo si hay un nodo anterior.
Iterator list_next(Iterator);	//Devuelve un iterador a la posición siguiente.
Iterator list_prior(Iterator);	//Devuelve un iterador a la posición anterior.
Type list_data(Iterator);	//Devuelve el dato referido por el iterador.
#endif