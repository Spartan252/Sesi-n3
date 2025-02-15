#include <stdio.h>
#include <stdlib.h>

int globalA = 3;
int globalB;

void function()
{
    static int calls;
    calls++;
}


int main()
{
    int staticA = 5;
    int staticB;
    short corto = 7;
    int corto2;
    short * ps = (short *) malloc(20 * sizeof(short));
    printf("%d\n", globalB);
    printf("%d\n", staticB);
    printf("%d\n", corto2);
    printf("%p\n", &globalA);
    printf("%p\n", &globalB);
    printf("%p\n", &staticA);
    printf("%p\n", &staticB);
    printf("%p\n", &corto);
    printf("%p\n", &ps);
    printf("%p\n", &ps[0]);
    printf("%p\n", &ps[1]);
    printf("%p\n", &ps[2]);
    printf("%p\n", main);
    printf("%p\n", function);
    return 0;
}
