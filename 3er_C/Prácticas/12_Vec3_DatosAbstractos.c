#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "Vec3.h"


struct strVec3{
float x, y, z;
};

Vec3 vec3_create(float x, float y, float z){
    Vec3 pointer = (Vec3) malloc(sizeof(struct strVec3));
    //Vec3 pointer = (struct strVec3 *) malloc(sizeof(struct strVec3));
    pointer->x = x;
    pointer->y = y;
    pointer->z = z;
    return pointer;
}

void vec3_destroy(Vec3 v){
    if(v == NULL)
        return; //ERROR
    free(v);
}

void vec3_setX(Vec3 v, float x){
    if(v == NULL)
        return; //ERROR
    v->x = x;
}

void vec3_setY(Vec3 v, float y){
    if(v == NULL)
        return; //ERROR
    v->y = y;
}

void vec3_setZ(Vec3 v, float z){
    if(v == NULL)
        return; //ERROR
    v->z = z;
}

float vec3_getX(Vec3 v){
    if(v == NULL)
        return 0; //error
    return v->x;
}

float vec3_getY(Vec3 v){
    if(v == NULL)
        return 0; //error
    return v->y;
}

float vec3_getZ(Vec3 v){
    if(v == NULL)
        return 0; //error
    return v->z;
}

float vec3_magnitude(Vec3 v){
    if(v == NULL)
        return -1; //ERROR
    return sqrt(v->x * v->x + v->y * v->y + v->z * v->z);
}

Vec3 vec3_normalize(Vec3 v){
    if(v == NULL)
        return NULL; //ERROR
    float m = vec3_magnitude(v);
    return vec3_create(v->x / m, v->y / m, v->z / m);
}

float vec3_dot(Vec3 v1, Vec3 v2){
    if(v1 == NULL || v2 == NULL)
        return -1; //ERROR
    return v1->x * v2->x + v1->y * v2->y + v1->z * v2->z;
}

void vec3_print(Vec3 v){
    if(v == NULL)
        return;
    printf("<%.4f, %.4f, %.4f>", v->x, v->y, v->z);
}

void vec3_println(Vec3 v)
{
    if(v == NULL)
        return;
    vec3_print(v);
    printf("\n");
}

bool vec3_equals(Vec3 v1, Vec3 v2)
{
    if(v1 == NULL && v2 == NULL)
        return TRUE;
    else if(v1 == NULL || v2 == NULL)
        return FALSE; //ERROR
    return v1->x == v2->x && v1->y == v2->y && v1->z == v2->z;
}

Vec3 vec3_clone(Vec3 v)
{
    if(v == NULL)
        return NULL; //ERROR
    return vec3_create(v->x, v->y, v->z);
}
