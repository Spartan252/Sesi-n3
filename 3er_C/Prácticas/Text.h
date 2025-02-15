
#ifndef TEXT_H_
#define TEXT_H_

typedef struct strText * Text;
Text text_create(char * chars);
void text_destroy(Text);
void text_print(Text);
void text_println(Text);
unsigned int text_length(Text);
char text_charAt(Text, int index); // si index no es válido, devuelve 0
Text text_clone(Text);
Text text_concat(Text, Text);
Text text_toLowercase(Text);

#endif