#include <stdio.h>
#include <stdlib.h>

int main()
{
    int * ptr;
    for(int i = 0; i < 10; i++)
    {
        //ptr = (int *) malloc(64 * sizeof(int));
        ptr = (int *) calloc(64, sizeof(int));
        printf("\tR: %d\n", ptr[10]);
        //*(ptr + 10) = 5000;
        ptr[10] = 5000 + i;
        printf("%d\n", ptr);
        free(ptr);
        printf("\tL: %d\n", ptr[10]);
    }
    return 0;
}
