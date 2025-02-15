#include <stdio.h>
#include "Set.h"

void printInt(Type data)
{
	int * p = (int *) data;
	printf("%d", *p);
}

int compareInts(Type d1, Type d2)
{
	int * p1 = (int *) d1;
	int * p2 = (int *) d2;
	return *p1 - *p2;
}

int main()
{
	int arr[] = {10, 5, 2, 7, 0, -5, -7, 100, 50};
	int x = 1000;
	
	Set s = set_create(compareInts, NULL, printInt);
	set_add(s, &arr[0]);
	set_add(s, &arr[1]);
	set_add(s, &arr[3]);
	set_add(s, &arr[2]);
	set_add(s, &arr[4]);
	set_add(s, &arr[6]);
	set_add(s, &arr[5]);
	set_add(s, &arr[7]);
	set_add(s, &arr[8]);
	set_add(s, &x);
	
	set_print(s);
	
	int y = 100;
	int z = 5000;
	
	printf("%s\n", set_contains(s, &x) ? "YES" : "NO");
	printf("%s\n", set_contains(s, &y) ? "YES" : "NO");
	printf("%s\n", set_contains(s, &arr[4]) ? "YES" : "NO");
	printf("%s\n", set_contains(s, arr + 3) ? "YES" : "NO");
	printf("%s\n", set_contains(s, &z) ? "YES" : "NO");
	
	
	set_destroy(s);

	return 0;
}