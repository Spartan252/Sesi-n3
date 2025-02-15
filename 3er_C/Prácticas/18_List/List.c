#include <stdio.h>
#include <stdlib.h>
#include "List.h"

struct strNode {
    Type data;
    struct strNode* next;
    struct strNode* prior;
};

typedef struct strNode* Node;

struct strList {
    struct strNode* first;
    struct strNode* last;
    int size;
    void (*destructor)(void*);
};

List list_create(void (*destructor)(Type)) {
    List list = (List)malloc(sizeof(struct strList));

    if (list == NULL)
        return NULL;

    list->size = 0;
    list->first = NULL;
    list->last = NULL;
    list->destructor = destructor;

    return list;
}

void list_destroy(List list) {
    if (list == NULL)
        return;

    Node current = list->first;
    while (current != NULL) {
        Node next = current->next;
        if (list->destructor != NULL)
            list->destructor(current->data);
        free(current);
        current = next;
    }

    free(list);
}

int list_size(List list) {
    if (list == NULL)
        return -1;
    return list->size;
}

void list_add(List list, Type data) {
    if (list == NULL)
        return;

    Node newNode = (Node)malloc(sizeof(struct strNode));
    newNode->data = data;
    newNode->next = NULL;
    newNode->prior = list->last;

    if (list->last != NULL) {
        list->last->next = newNode;
    } else {
        list->first = newNode;
    }

    list->last = newNode;
    list->size++;
}

Type list_get(List list, int p) {
    if (list == NULL || p < 0 || p >= list->size)
        return NULL;

    Node current = list->first;
    int i;
    for (i = 0; i < p; i++) {
        current = current->next;
    }

    return current->data;
}

void list_set(List list, Type data, int p) {
    if (list == NULL || p < 0 || p >= list->size)
        return;

    Node current = list->first;
    int i;
    for (i = 0; i < p; i++) {
        current = current->next;
    }

    current->data = data;
}

Type list_remove(List list, int p) {
    if (list == NULL || p < 0 || p >= list->size)
        return NULL;

    Node current = list->first;
    int i;
    for (i = 0; i < p; i++) {
        current = current->next;
    }

    if (current->prior != NULL) {
        current->prior->next = current->next;
    } else {
        list->first = current->next;
    }

    if (current->next != NULL) {
        current->next->prior = current->prior;
    } else {
        list->last = current->prior;
    }

    Type data = current->data;
    free(current);
    list->size--;

    return data;
}

Iterator list_begin(List list) {
    return list->first;
}

Iterator list_end(List list) {
    return list->last;
}

Bool list_hasNext(Iterator it) {
    return (it != NULL && it->next != NULL) ? TRUE : FALSE;
}

Bool list_hasPrior(Iterator it) {
    return (it != NULL && it->prior != NULL) ? TRUE : FALSE;
}

Iterator list_next(Iterator it) {
    return (it != NULL) ? it->next : NULL;
}

Iterator list_prior(Iterator it) {
    return (it != NULL) ? it->prior : NULL;
}

Type list_data(Iterator it) {
    return (it != NULL) ? it->data : NULL;
}
