#include "Set.h"
#include <stdlib.h>
#include <stdio.h>

struct strNode {					
	Type data;
	struct strNode *left, *right;
};

typedef struct strNode* Node;

struct strSet {					
	struct strNode *root;	// desde la raíz llegamos a cualquier elemento
	int size;
	CompareFunc compareFunc;
	DestroyFunc destructor;
	PrintFunc printFunc;
};


Set  set_create(CompareFunc cf, DestroyFunc destructor, PrintFunc pf)
{
	Set s = (Set) malloc(sizeof(struct strSet));
	if(s == NULL)
		return NULL;
	
	s->root = NULL;
	s->size = 0;
	s->compareFunc = cf;
	s->destructor = destructor;
	s->printFunc = pf;
	
	return s;
}


int  set_size(Set s)		//Extrae el tamaño del conjunto.
{
	if(s == NULL)
		return -1;
	
	return s->size;
}

void set_destroy_post_order(Node n, DestroyFunc destructor)
{
	if(n != NULL)
	{
		if(n->left != NULL)
			set_destroy_post_order(n->left, destructor);
		if(n->right != NULL)
			set_destroy_post_order(n->right, destructor);
		if(destructor != NULL)
			destructor(n->data);
		free(n);
	}
}

void set_destroy(Set s)
{
	if(s == NULL)
		return;
	
	if(s->root != NULL)
		set_destroy_post_order(s->root, s->destructor);
	
	free(s);
}



void set_print_in_order(Node n, int level, PrintFunc printFunc)
{
	if(n != NULL)
	{
		if(n->left != NULL)
			set_print_in_order(n->left, level + 1, printFunc);
		
		for(int i = 0; i < level; i++)
			printf(" ");
		
		printFunc(n->data);
		printf("\n");
		
		if(n->right != NULL)
			set_print_in_order(n->right, level + 1, printFunc);
		
		
	}
	
}

void set_print(Set s)
{
	if(s == NULL || s->printFunc == NULL || s->root == NULL)
		return;
	
	set_print_in_order(s->root, 0, s->printFunc);
}


Bool set_add(Set s, Type t)
{
	if(s == NULL || t == NULL)
		return FALSE;
	
	Node n = (Node) malloc(sizeof(struct strNode));
	n->data = t;
	n->left = n->right = NULL;
	
	if(s->root == NULL)
	{
		s->root = n;
		s->size++;
	}
	else
	{
		
		Node current = s->root;
		while(current != NULL)
		{
			int cmp = s->compareFunc(current->data, t);
			if(cmp == 0)
			{
				free(n);
				return FALSE;
			}
			else if(cmp < 0)
			{
				if(current->right == NULL)
				{
					current->right = n;
					s->size++;
					return TRUE;
				}
				
				current = current->right;
			}
			else //if(cmp > 0)
			{
				if(current->left == NULL)
				{
					current->left = n;
					s->size++;
					return TRUE;
				}
				
				current = current->left;
			}			
		}
		
		free(n);
		return FALSE;
	}
		
}

Node set_find(Set s, Type t)
{
	Node aux = s->root;
	
	while(aux != NULL)
	{
		int cmp = s->compareFunc(aux->data, t);
		if(cmp == 0)
			return aux;
		else if(cmp > 0)
			aux = aux->left;
		else //if(cmp < 0)
			aux = aux->right;
	}
	
	return NULL;
}

Bool set_contains(Set s, Type t)
{
	if(s == NULL || t == NULL || s->root == NULL)
		return FALSE;
	
	return set_find(s, t) != NULL;	
}