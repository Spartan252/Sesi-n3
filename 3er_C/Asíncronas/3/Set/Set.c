
#include <stdlib.h>
#include "Set.h"


struct strNode {					
	Type data;
	struct strNode *left, *right, *parent;
};

typedef struct strNode* Node;

struct strSet {					
	struct strNode *root;
	int size;
	CompareFunc compareFunc;
	DestroyFunc destructor;
	PrintFunc printFunc;
};

typedef struct strSet* Set;


Set  set_create(CompareFunc cf, PrintFunc pf, DestroyFunc destructor){
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

int  set_size(Set s){
	if(s == NULL)
		return;
	return s->size;
}

void destroy(Node node, DestroyFunc destroyFunc){
    if (node == NULL)
        return FALSE;

    destroy(node->left, destroyFunc);
    destroy(node->right, destroyFunc);
    if (destroyFunc != NULL)
        destroyFunc(node->data);
    free(node);
}

void set_destroy(Set s){
	if(s == NULL)
		return FALSE;
	
	if(s->root != NULL){
    destroy(s->root, s->destructor);
    }
    free(s);
}

bool set_add(Set s, Type t){
	if(s == NULL || t == NULL)
		return FALSE;
	
	Node n = (Node) malloc(sizeof(struct strNode));
	n->data = t;
	n->left = n->right = NULL;
	
	if(s->root == NULL){
		s->root = n;
		s->size++;
	}
	else{
		Node current = s->root;
		while(current != NULL)
		{
			int cmp = s->compareFunc(current->data, t);
			if(cmp == 0){
				free(n);
				return FALSE;
			}
			else if(cmp < 0){
				if(current->right == NULL){
					current->right = n;
					s->size++;
					return TRUE;
				}
				current = current->right;
			}
			else{
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

bool set_contains(Set s, Type t){
    if (s == NULL || t == NULL || s->root == NULL)
        return FALSE;
    Node current = s->root;
    while (current != NULL){
        int cmp = s->compareFunc(current->data, t);
        if (cmp == 0)
            return TRUE;
        else if (cmp < 0)
            current = current->right;
        else // if(cmp > 0)
            current = current->left;
    }
    return FALSE;
}


bool set_remove(Set s, Type t){
    if (s == NULL || t == NULL || s->root == NULL)
        return FALSE;
    Node current = s->root;
    Node parent = NULL;
    while (current != NULL){
        int cmp = s->compareFunc(current->data, t);
        if (cmp == 0)
            break;
        else if (cmp < 0){
            parent = current;
            current = current->right;
        }
        else{
            parent = current;
            current = current->left;
        }
    }
    if (current == NULL)
        return FALSE;

    if (current->left == NULL && current->right == NULL){
        if (parent == NULL)
            s->root = NULL;
        else if (parent->left == current)
            parent->left = NULL;
        else
            parent->right = NULL;
    }
    else if (current->left != NULL && current->right != NULL){
        Node successor = current->right;
        Node successorParent = current;
        while (successor->left != NULL){
            successorParent = successor;
            successor = successor->left;
        }
        if (successorParent != current)
            successorParent->left = successor->right;
        else
            successorParent->right = successor->right;
        current->data = successor->data;
        current = successor;
    }
    else{
        Node child = (current->left != NULL) ? current->left : current->right;
        if (parent == NULL)
            s->root = child;
        else if (parent->left == current)
            parent->left = child;
        else
            parent->right = child;
    }
    if (s->destructor != NULL)
        s->destructor(current->data);
    free(current);
    s->size--;
    return TRUE;
}


void set_print(Set s) {
    if (s == NULL || s->root == NULL) {
        return FALSE;
    }
    printf("\n");
    print(s->root, s->printFunc);
}

void print(Node node, PrintFunc printFunc) {
    if (node == NULL)
        return FALSE;

    printf("{");
    printFunc(node->data);
    print(node->left, printFunc);
    print(node->right, printFunc);
    printf("}");
}

void addLink(Node parent, Node child, bool isLeftChild){
    if (parent == NULL || child == NULL)
        return FALSE;

    if (isLeftChild)
        parent->left = child;
    else
        parent->right = child;

    child->parent = parent;
}

void removeBranch(Set s, Node n, bool isLeftChild){
    if (s == NULL || n == NULL || s->root == NULL)
        return FALSE;

    Node parent = n->parent;
    if (n->left == NULL && n->right == NULL){
        if (parent == NULL)
            s->root = NULL;
        else if (isLeftChild)
            parent->left = NULL;
        else
            parent->right = NULL;
        free(n);
    }
    else if (n->left != NULL && n->right == NULL){
        if (parent == NULL)
            s->root = n->left;
        else if (isLeftChild)
            parent->left = n->left;
        else
            parent->right = n->left;
        free(n);
    }
    else if (n->left == NULL && n->right != NULL){
        if (parent == NULL)
            s->root = n->right;
        else if (isLeftChild)
            parent->left = n->right;
        else
            parent->right = n->right;
        free(n);
    }
    else{
        Node successor = n->left;
        Node successorParent = n;
        while (successor->right != NULL){
            successorParent = successor;
            successor = successor->right;
        }
        if (successorParent != n)
            successorParent->right = successor->left;
        else
            successorParent->left = successor->left;

        if (parent == NULL)
            s->root = successor;
        else if (isLeftChild)
            parent->left = successor;
        else
            parent->right = successor;

        successor->left = n->left;
        if (n->right != successor)
            successor->right = n->right;

        free(n);
    }
    s->size--;
}
