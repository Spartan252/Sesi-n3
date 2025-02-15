#include <stdio.h>
#include <stdlib.h>
#include "Text.h"

struct strText{
    char * s;
    unsigned int length;
};

Text text_create(char * chars){
    Text t = (Text) malloc(sizeof(struct strText));
    unsigned int i;
    for(i = 0; chars[i] != '\0'; i++);
    t->length = i;
    t->s = (char *) malloc((i + 1) * sizeof(char));
    for(; i > 0; i--)
        t->s[i] = chars[i];
    t->s[0] = chars[0];
    return t;
}

void text_destroy(Text t){
    if(t == NULL)
        return;
    free(t->s);
    free(t);
}

void text_print(Text t){
    if(t == NULL)
        return;
    printf("%s", t->s);
}

void text_println(Text t)
{
    if(t == NULL)
        return;
    text_print(t);
    printf("\n");
}

unsigned int text_length(Text t){
    if(t == NULL)
        return 0;
    return t->length;
}

char text_charAt(Text t, int index){ // si index no es válido, devuelve 0
    if(t == NULL || index < 0 || index >= t->length)
        return '\0';
    return t->s[index];
}

Text text_clone(Text t){
    if(t == NULL)
        return NULL;
    return text_create(t->s);
}

Text text_concat(Text t1, Text t2){
    if(t1 == NULL || t2 == NULL)
        return NULL;
    Text t3 = (Text) malloc(sizeof(struct strText));
    t3->length = t1->length + t2->length;
    t3->s = (char *) malloc((t3->length + 1) * sizeof(char));
    int i = 0;
    for(; i < t1->length; i++)
        t3->s[i] = t1->s[i];
    for(int j = 0; j <= t2->length; j++)
        t3->s[i + j] = t2->s[j];
    return t3;
}

Text text_toLowercase(Text t){
    if(t == NULL)
        return NULL;
    Text tL = text_clone(t);
    for(int i = 0; i < tL->length; i++)
        if('A' <= tL->s[i] && tL->s[i] <= 'Z')
            tL->s[i] += ('a' - 'A');
    return tL;
}