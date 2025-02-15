#ifndef SET_H__
#define SET_H__
typedef void * Type;
typedef enum { FALSE, TRUE } Bool;
typedef struct strSet * Set;

typedef void (*DestroyFunc) (Type);
typedef void (*PrintFunc) (Type);
typedef int (*CompareFunc) (Type, Type);

Set  set_create(CompareFunc cf, DestroyFunc destructor, PrintFunc pf);
int  set_size(Set);		//Extrae el tamaño del conjunto.
Bool set_add(Set s, Type t);		//Agrega el valor t al conjunto s, sólo si s  
	
#endif