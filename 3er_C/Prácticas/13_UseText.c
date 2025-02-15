#include <stdio.h>
#include "Text.h"

int main()
{
	Text s1 = text_create("AdiOs");
	Text s2 = text_clone(s1);
	Text s4 = text_toLowercase(s1);
	Text s3 = text_concat(s1, s2);
	text_println(s1);
	text_println(s2);
	text_println(s3);
	text_println(s4);
	printf("%d, %c\n", text_length(s1), text_charAt(s2, 2));
	text_destroy(s1);
	text_destroy(s2);
	text_destroy(s3);
	text_destroy(s4);
	return 0;
}