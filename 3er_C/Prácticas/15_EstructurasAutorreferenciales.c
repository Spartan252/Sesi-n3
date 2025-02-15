#include <stdio.h>

typedef struct strDate
{
	int day, month, year;
	struct strDate * next;
}Date;


void imprimirFechitas(Date * d)
{
	while(d != NULL)
	{
		printf("%d/%d/%d\n", d->day, d->month, d->year);
		d = d->next;
	}
}


int main()
{
	Date d1 = {4, 10, 2023, NULL};
	Date d2 = {5, 10, 2023, NULL};
	Date d3 = {16, 10, 2023, NULL};
	d1.next = &d2;
	d2.next = &d3;
	imprimirFechitas(&d3);
	imprimirFechitas(&d1);
	imprimirFechitas(&d1);
	imprimirFechitas(&d2);



	return 0;
}