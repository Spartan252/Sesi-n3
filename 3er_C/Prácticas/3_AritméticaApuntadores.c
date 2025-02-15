#include <stdio.h>

    //3
    typedef struct{
        unsigned int pesos: 24;
        unsigned int centavos: 7;
        unsigned int signo: 1; //0 (positivo), 1 (negativo)
    } Moneda;

    void imprimir(Moneda m){
        if(m.signo == 0)
            printf("$%d.%02d\n", m.pesos, m.centavos);
        else
            printf("($%d.%02d)\n", m.pesos, m.centavos);
            
        //printf(m.signo == 0 ? "%d.%02d\n" : "(%d.%02d)\n", m.pesos, m.centavos);
        //printf(m.signo ? "(%d.%02d)\n" : "%d.%02d\n", m.pesos, m.centavos);
    }

    void sumarUnCentavo(Moneda * pm){
        if(pm->signo == 0){
            pm->centavos++;
            if(pm->centavos == 100){
                pm->centavos = 0;
                pm->pesos++;
            }
        }
        else{
            if(pm->centavos == 0){
                pm->centavos = 99;
                pm->pesos--;
            }
            else if(pm->centavos == 1 && pm->pesos == 0){
                pm->centavos = 0;
                pm->signo = 0;
            }
            else
                pm->centavos--;
        }
        
    }



int main(){

    double r1 = -7.528;
    double * p1 = &r1;

    printf("p1= %p\ndireccion p1= %p \n", p1, &p1);

    *p1 /= 2;

    printf("valor de r1= %.3f\n", *p1);


    //2
    short a1[100] ={};
    //for(int i=0; i<100; i++)  Elementos de a1
        //printf("");

    short * p2 = &a1[0];

    short * p3 = &a1[2];

    *p2 = 10;

    p3 ++;
    *p3= 20;
    printf("valor de a1[0]= %d\n", a1[0]);
    printf("valor de a1[3]= %d\n", a1[3]);

    p3 += 6;
    *p3= 3 * *p2;
    printf("valor de a1[9]= %d\n", a1[9]);

    printf("Tras cambiar los apuntadores:\nvalor de a1[0]= %d\nvalor de a1[2]= %d\nvalor de a1[3]= %d\nvalor de a1[9]= %d\n", a1[0],a1[2],a1[3],a1[9]);


    //3
    Moneda m0 = {16, 8, 1};
    imprimir(m0);
    sumarUnCentavo(&m0);
    imprimir(m0);

    Moneda m1 = {0, 1, 1};
    imprimir(m1);
    sumarUnCentavo(&m1);
    imprimir(m1);

    Moneda m2 = {16, 8, 0};
    imprimir(m2);
    sumarUnCentavo(&m2);
    imprimir(m2);

    Moneda m3 = {99, 99, 0};
    imprimir(m3);
    sumarUnCentavo(&m3);
    imprimir(m3);

    Moneda m4 = {100, 0, 1};
    imprimir(m4);
    sumarUnCentavo(&m4);
    imprimir(m4);
}